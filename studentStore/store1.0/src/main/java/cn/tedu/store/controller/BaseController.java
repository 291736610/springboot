package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import cn.tedu.store.bean.User;

public class BaseController {
	//获取用户id的值
	public Integer getId(HttpSession session){
		//id?从session中获取user对象，在从对象中获取id
		Integer id = null;
		User user = (User)session.
				getAttribute("user");
		if(user!=null){
			id = user.getId();
		}
		return id;
	}
}
