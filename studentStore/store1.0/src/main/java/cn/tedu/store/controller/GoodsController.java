package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private IGoodsService goodsService;
	@RequestMapping("/showSearch.do")
	public String showSearch(
				Integer categoryId,
				Integer page,
				ModelMap map){
		if(page==null){
			page = 1;
		}
		Integer offset = (page-1)*12;
		List<Goods> list = 
				goodsService.getByCategoryId(
				categoryId, offset, 12);
		//获取商品的数量
		Integer count = 
			goodsService.getCount(categoryId);
		//共显示多少页
		int pageSize = 
				count%12==0?count/12:count/12+1;
		
		//把商品添加的map
		map.addAttribute("list",list);
		//把商品的数量添加到map
		map.addAttribute("count",count);
		//把显示商品的页数添加到map
		map.addAttribute("pageSize",pageSize);
		//把categoryId添加到map
		map.addAttribute("categoryId",categoryId);
		//把当前页添加到map
		map.addAttribute("curpage",page);
		return "search";
	}
	//显示商品详情页面
	@RequestMapping("/showProductDetails.do")
	public String showProductDetails(
			String id,ModelMap map){
		Goods goods = 
			goodsService.getById(id);
		map.addAttribute("goods",goods);
		return "product_details";
	}
}










