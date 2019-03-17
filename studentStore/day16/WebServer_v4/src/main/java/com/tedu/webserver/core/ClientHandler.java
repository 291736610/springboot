package com.tedu.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.tedu.webserver.http.HttpRequest;

/**
 * 处理客户端请求的线程任务
 * @author adminitartor
 *
 */
public class ClientHandler implements Runnable{
	private Socket socket;
	public ClientHandler(Socket socket){
		this.socket = socket;
	}
	public void run(){
		/*
		 * 处理该客户端的请求的大致步骤
		 * 1:解析请求
		 * 2:处理请求
		 * 3:给予响应
		 */
		try {
			//1解析请求,生成HttpRequest对象
			HttpRequest request = new HttpRequest(socket);
			
			//2处理请求
			/*
			 * 通过request获取请求的资源路径，从
			 * webapps中寻找对应资源
			 */
			String url = request.getUrl();
			File file = new File("webapps"+url);
			if(file.exists()){
				System.out.println("资源已找到!");
				/*
				 * 以一个标准的HTTP响应格式回复客户端该资源
				 */
				OutputStream out = socket.getOutputStream();
				//发送状态行
				String line = "HTTP/1.1 200 OK";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送响应头
				line = "Content-Type: text/html";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				line = "Content-Length: "+file.length();
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				//表示响应头部分发送完毕
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送响应正文
				FileInputStream fis 
					= new FileInputStream(file);
				byte[] data = new byte[1024*10];
				int len = -1;
				while((len = fis.read(data))!=-1){
					out.write(data, 0, len);
				}				
			}else{
				System.out.println("资源未找到!");
				file = new File("webapps/myweb/404.html");
				OutputStream out = socket.getOutputStream();
				//发送状态行
				String line = "HTTP/1.1 404 NOT FOUND";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送响应头
				line = "Content-Type: text/html";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				line = "Content-Length: "+file.length();
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				//表示响应头部分发送完毕
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送响应正文
				FileInputStream fis 
					= new FileInputStream(file);
				byte[] data = new byte[1024*10];
				int len = -1;
				while((len = fis.read(data))!=-1){
					out.write(data, 0, len);
				}				
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//响应后与客户端断开连接
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}







