package com.tedu.webserver.http;

import java.util.HashMap;
import java.util.Map;

/**
 * 该类定义了HTTP协议相关信息
 * @author adminitartor
 *
 */
public class HttpContext {
	/**
	 * 状态代码与对应状态描述的映射关系
	 * key:状态代码
	 * value:状态描述
	 */
	private static Map<Integer,String> STATUS_REASON_MAPPING = new HashMap<Integer,String>();
	/**
	 * 资源后缀与Content-Type之间的映射关系
	 * key:资源的后缀名
	 * value:该资源对应的Content-Type的值
	 * 注:不同的资源对应的Content-Type的值在w3c上都有定义
	 *    ，可前往w3c官网查询MIME定义
	 * 
	 */
	private static Map<String,String> MIME_MAPPING = new HashMap<String,String>();
	
	
	
	static{
		initStatusReasonMapping();
		initMimeMapping();
	}
	/**
	 * 初始化资源后缀与Content-Type的映射Map
	 */
	private static void initMimeMapping(){
		MIME_MAPPING.put("html", "text/html");
		MIME_MAPPING.put("png", "image/png");
		MIME_MAPPING.put("gif", "image/gif");
		MIME_MAPPING.put("jpg", "image/jpeg");
		MIME_MAPPING.put("css", "text/css");
		MIME_MAPPING.put("js", "application/javascript");
	}
	
	/**
	 * 初始化状态代码与描述的映射MAP
	 */
	private static void initStatusReasonMapping(){
		STATUS_REASON_MAPPING.put(200, "OK");
		STATUS_REASON_MAPPING.put(302, "Move Temporaily");
		STATUS_REASON_MAPPING.put(404, "Not Found");
		STATUS_REASON_MAPPING.put(500, "Internal Server Error");
	}
	/**
	 * 根据资源后缀名获取对应的Content-Type的值
	 * @param ext
	 * @return
	 */
	public static String getMimeType(String ext){
		return MIME_MAPPING.get(ext);
	}
	
	/**
	 * 根据给定的状态代码获取对应的状态描述
	 * @param statusCode
	 * @return
	 */
	public static String getStatusReason(int statusCode){
		return STATUS_REASON_MAPPING.get(statusCode);
	}
	
	
	public static void main(String[] args) {
		//介质
		String type = getMimeType("js");
		System.out.println(type);
	}
}





