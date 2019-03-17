package com.tedu.webserver.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务端环境信息
 * 
 * @author adminitartor
 *
 */
public class ServerContext {
	/**
	 * 请求与Servlet映射。
	 * key:请求路径
	 * value:对应Servlet的名字
	 */
	private static Map<String,String> servletMapping = new HashMap<String,String>();
	
	static{
		initServletMapping();
	}
	
	/**
	 * 初始化请求与Servlet映射信息
	 */
	private static void initServletMapping(){
		servletMapping.put("/myweb/reg", "com.tedu.webserver.servlet.RegServlet");
		servletMapping.put("/myweb/login", "com.tedu.webserver.servlet.LoginServlet");
	}
	
	/**
	 * 根据请求获取对应的Servlet名字
	 * @param url
	 * @return
	 */
	public static String getServletName(String url){
		return servletMapping.get(url);
	}

	public static void main(String[] args) {
		String servletName = getServletName("/myweb/reg");
		System.out.println(servletName);
	}
}






