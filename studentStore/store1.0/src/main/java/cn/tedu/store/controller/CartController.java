package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.vo.CartVo;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{

	@Resource
	private ICartService cartService;
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(
			HttpSession session,
			String goodsId,
			Integer num){
		ResponseResult<Void> rr = 
			new ResponseResult<Void>(1,"添加成功");
		Cart cart = new Cart();
		cart.setUid(this.getId(session));
		cart.setGoodsId(goodsId);
		cart.setNum(num);
		cartService.addCart(cart);
		
		return rr;
	}
	//显示购物车页面
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,
			ModelMap map){
		//调用业务层方法
		List<CartVo> list=
				cartService.getByUid(this.getId(session));
		
		//把list添加到map中
		map.addAttribute("listVo",list);
		
		//返回页面名称
		return "cart";
	}
	//批量删除
	@RequestMapping("/removeByIds.do")
	public String removeByIds(Integer[] ids){
		cartService.removeByIds(ids);
		return "redirect:../cart/showCart.do";
	}
	//单行删除
	@RequestMapping("/removeById.do")
	public String removeById(Integer id){
		cartService.removeById(id);
		return "redirect:../cart/showCart.do";
	}
	//异步请求，修改数量
	@RequestMapping("/updCart.do")
	@ResponseBody
	public ResponseResult<Void> updCart(
			Integer id,Integer num){
		ResponseResult<Void> rr=
				new ResponseResult<Void>(1,"成功");
		cartService.updNumById(id, num);
		
		return rr;
	}
}








