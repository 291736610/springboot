package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;
	//显示注册页面
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	//显示登录页面
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	//显示修改密码页面
	@RequestMapping("/showPassword.do")
	public String showPassword(){
		return "personal_password";
	}
	//显示个人信息页面
	@RequestMapping("/showPersonpage.do")
	public String showPersonpage(){
		return "personpage";
	}
	
	
	//实现异步验证，用户名是否存在
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(
			String username){
		//1.声明ResponseResult<Void>对象
		ResponseResult<Void> rr = null;
		//2.调用业务层方法
		boolean b = 
		userService.checkUsername(username);
		//3.如果b为true；定义状态码 ： 0
		//   和状态信息:用户名不可以使用
		if(b){
			rr = new ResponseResult<Void>(0,
				"用户名不可以使用");
		}else{
		//4.如果b为false；定义状态码 ：1
		//   和状态信息:用户名可以使用
			rr = new ResponseResult<Void>(1,
				"用户名可以使用");
		}
		return rr;
	}
	//验证邮箱的异步请求方法
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(
			String email){
		//1.声明rr对象
		ResponseResult<Void> rr = null;
		//2.调用业务层方法：checkEmail(email);返回Boolean b
		//3.如果b为true
		//创建rr对象，state：0 message:邮箱不可以使用
		//4.如果b为false
		//创建rr对象，state：1 message:邮箱可以使用
		if(userService.checkEmail(email)){
			rr = new ResponseResult<Void>(
					0,"邮箱不可以使用");
		}else{
			rr = new ResponseResult<Void>(
					1,"邮箱可以使用");
		}
		
		//5.返回rr；
		return rr;
	}
	//验证电话
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(
			String phone){
		ResponseResult<Void> rr = null;
		if(userService.checkPhone(phone)){
			rr =
			new ResponseResult<Void>(0,
					"电话号码不可以使用");
		}else{
			rr =
			new ResponseResult<Void>(1,
							"电话号码可以使用");
		}
		return rr;
	}
	//异步提交注册
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
		@RequestParam("uname") String username,
		@RequestParam("upwd") String password,
		String email,String phone){
		//1.声明rr对象
		ResponseResult<Void> rr = null;
		//2.
		try{
		//调用业务层方法addUser(user);
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			userService.addUser(user);
		//3.创建rr对象 state：1 message:添加数据成功
			rr = new ResponseResult<Void>(
					1,"添加数据成功");
		}catch(RuntimeException ex){
			//4.创建rr对象 state：0 message:ex.getMessage();
			rr = new ResponseResult<Void>(
					0,ex.getMessage());
		}
		//5.返回rr；
		return rr;
	}
	//异步提交登录
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(
			String username,String password,
			HttpSession session){
		//1.声明rr对象
		ResponseResult<Void> rr =  null;
		try{
			//2.调用业务层方法：login(username,password)返回user对象
			User user = 
					userService.login(
					username, password);
			//3.rr设置 state：1 message：登录成功
			rr = 
			new ResponseResult<Void>(1,"登录成功");
			//4.把user 对象绑定到session中
			session.setAttribute("user",user);
			}catch(RuntimeException ex){
				//5.rr设置 state：0 message：ex.getMessage();
				rr = 
				new ResponseResult<Void>(0,ex.getMessage());
			}
		return rr;
	}
	//退出
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:../main/showIndex.do";
	}
	//修改密码
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(
			HttpSession session,
			String oldPwd,String newPwd){
		//1.声明rr对象
		ResponseResult<Void> rr = null;
		try{
		
		//2.调用业务层方法changePassword(id,oldPwd,newPwd);
			userService.changePassword(
					this.getId(session), oldPwd, newPwd);
		//3.rr state : 1 message:修改密码成功
			rr = new ResponseResult<Void>(1,
					"修改密码成功");
		}catch(RuntimeException ex){
			//4.rr state : 0 message:ex.getMessage()
			rr = new ResponseResult<Void>(0,
					ex.getMessage());
		}
		return rr;
	}
	//修改个人信息
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(
			HttpSession session,
			String username,Integer gender,
			String email,String phone){
		ResponseResult<Void> rr = null;
		try{
			userService.updateUser(
					this.getId(session),
					username, gender, 
					email, phone);
			rr = new ResponseResult<Void>(1,
					"修改成功");
			//把session中的user对象替换成修改后的对象
			session.setAttribute("user",
					userService.getUserById(
							this.getId(session)));
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,
					ex.getMessage());
		}
		return rr;
	}
	//异步请求，上传图片
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(
			MultipartFile file,
			HttpSession session) throws Exception{
		//1.创建rr对象 state:1 messae :成功
		ResponseResult<Void> rr =
		 new ResponseResult<Void>(1,"成功");
		//2.上传图片
		//获取应用的真实路径
		String path = session.
				getServletContext().getRealPath("/");
		 
		System.out.println(path);
		 
		file.transferTo(
				new File(
				path,"/upload/"+
				file.getOriginalFilename()));
		
		//3.修改数据库image字段
		userService.updImage(
				this.getId(session), 
				"/upload/"+
					file.getOriginalFilename());
		
		 return rr;
		
	}
}










