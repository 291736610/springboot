package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;

public class TestUser {
	@Test
	public void testUpdateImage(){
		//1.获取Spring容器
		AbstractApplicationContext ac =
		new ClassPathXmlApplicationContext(
			"application-dao.xml",
			"application-service.xml");
		//2.获取bean对象
		UserMapper um = 
			ac.getBean("userMapper",UserMapper.class);
		um.updateImage(5, "abc.png");
	}
	@Test
	public void testUpdateUser1(){
		//1.获取Spring容器
		AbstractApplicationContext ac =
		new ClassPathXmlApplicationContext(
			"application-dao.xml",
			"application-service.xml");
		//2.获取bean对象
		IUserService us = 
			ac.getBean("userService",
					IUserService.class);
		us.updateUser(2, "admin", 1, 
				"admin@tedu.cn", 
				"13900187000");
		ac.close();
		
	}
	@Test
	public void testChangePassword(){
		//1.获取Spring容器
		AbstractApplicationContext ac =
			new ClassPathXmlApplicationContext(
				"application-dao.xml",
				"application-service.xml");
		IUserService us = 
			ac.getBean("userService",
					IUserService.class);
		us.changePassword(44, "111111", "666666");
		ac.close();
	}
	@Test
	public void testSelectById(){
	//1.获取Spring容器
	AbstractApplicationContext ac =
		new ClassPathXmlApplicationContext(
			"application-dao.xml");
	//2.获取bean对象
	UserMapper um =ac.getBean("userMapper",
					UserMapper.class);
	System.out.println(
			um.selectUserById(11));
	ac.close();
					
	}
	@Test
	public void testUpdateUser(){
		//1.获取Spring容器
		AbstractApplicationContext ac =
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
		//2.获取bean对象
		UserMapper um =
				ac.getBean("userMapper",
				UserMapper.class);
		//3.调用方法
		User user = new User();
		user.setId(4);
		//user.setPassword("111111");
		user.setUsername("lisi123");
		user.setGender(0);
		user.setPhone("12321232123");
		user.setEmail("lisi@tedu.cn");
		um.updateUser(user);
		System.out.println("???");
		ac.close();
	}
	@Test
	public void testLogin(){
		//1.获取Spring容器
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
			"application-dao.xml",
			"application-service.xml");	
		//2.获取bean对象
		IUserService us = 
			ac.getBean("userService",
					IUserService.class);
		System.out.println(
				us.login("admin1","123456"));
		ac.close();
	}
	@Test
	public void testCheckUsername(){
		//1.获取Spring容器
			AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
				"application-dao.xml",
				"application-service.xml");	
		//2.获取bean
			IUserService us = 
			ac.getBean("userService",
					IUserService.class);
			System.out.println(
					us.checkUsername("admin6"));
	}
	
	
	
	@Test
	public void testCheckEmail(){
		//1.获取Spring容器
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
					"application-dao.xml",
					"application-service.xml");
		//2.获取bean对象
		IUserService us = 
			ac.getBean("userService",
					IUserService.class);
		/*System.out.println(
				us.checkEmail("admin4@tedu.cn"));*/
		System.out.println(
				us.checkPhone("13300138000"));
	}
	@Test
	public void testSelectByPhone(){
		//1.获取Spring容器
		AbstractApplicationContext ac = 
			new ClassPathXmlApplicationContext(
				"application-dao.xml",
				"application-service.xml");
		//2.获取bean对象
		UserMapper um = 
				ac.getBean("userMapper",
						UserMapper.class);	
		//3.调用方法
		System.out.println(
				um.selectByPhone("13700138000"));
		
	}
	
	
	@Test
	public void testSelectByEmail(){
		//1.获取Spring容器
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
				"application-dao.xml",
				"application-service.xml");
		//2.获取bean对象
		UserMapper um = 
				ac.getBean("userMapper",
						UserMapper.class);
		//3.调用方法
		System.out.println(
			um.selectByEmail("admin4@tedu.cn"));
		ac.close();
	}
	
	
	
	
	@Test
	public void testAddUser(){
		//1.获取Spring容器
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
		"application-dao.xml",
		"application-service.xml");
		//2.获取bean对象
		IUserService us =
				ac.getBean("userService",
				IUserService.class);
		//3.调用方法
		User user = new User();
		user.setUsername("admin1");
		user.setPassword("123456");
		user.setEmail("admin1@tedu.cn");
		user.setPhone("13800139000");
		us.addUser(user);
		
		ac.close();
		
	}
	//1.测试方法的返回类型为void类型
	//2.测试方法的访问修饰符为public
	//3.测试方法的参数列表为空
	@Test
	public void testSelectByUsername(){
		//1.获取Spring容器
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
			"application-dao.xml");
		//2.从容器中获取bean对象
		UserMapper um = 
			ac.getBean("userMapper",UserMapper.class);
		
		//3.调用方法
		System.out.println(
				um.selectByUsername("admin"));
		//4.关闭容器
		ac.close();
	}
	
	@Test
	public void testInsertUser(){
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"application-dao.xml");
		UserMapper um = 
				ac.getBean("userMapper",
						UserMapper.class);
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setEmail("admin@tedu.cn");
		user.setPhone("13800138000");
		um.insertUser(user);
		
	}
}









