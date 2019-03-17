package com.tedu.webserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * WebServer主类
 * @author adminitartor
 *
 */
public class WebServer {
	private ServerSocket server;
	
	public WebServer(){
		try {
			//Tomcat默认开启的端口就是8080
			server = new ServerSocket(8080);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		try {
			//暂时不处理多次客户端连接
//			while(true){
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				
				//启动一个线程，处理该客户端请求
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
//			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
}

















