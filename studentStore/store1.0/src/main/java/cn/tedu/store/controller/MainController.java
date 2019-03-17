package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	
	//显示首页
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map){
	//List<List<GoodsCategory>> list3 = 
		//new ArrayList<List<GoodsCategory>>();
	List<List<GoodsCategory>> list3 = 
		new ArrayList<List<GoodsCategory>>();
	
	//1.调用业务层getByParentId(161,0,3);返回集合 list2
	List<GoodsCategory> list2=
	goodsCategoryService.getByParent(161, 0, 3);
	
	//2.遍历list2 ，可以得到goodsCategory的id值
		//调用业务层方法getByParentId(id,null,null),返回list
		//把list添加到list3
	
	for(GoodsCategory goodsC:list2){
		Integer id = goodsC.getId();
		List<GoodsCategory> list =
		goodsCategoryService.getByParent(
				id,null,null);
		list3.add(list);
	}
	
	//获取热卖的商品集合
	List<Goods> goodsList = 
	goodsService.getByCategoryId(163, 0, 3);
	
	//3.把list2 和list3添加到map中
		map.addAttribute("list2",list2);
		map.addAttribute("list3",list3);
	//把热卖商品的集合添加到map中
		map.addAttribute("goodsList",goodsList);
		
		return "index";
	}
}








