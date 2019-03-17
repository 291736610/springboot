package com.tedu.webserver.core;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.Arrays;

import com.tedu.webserver.http.HttpRequest;
import com.tedu.webserver.http.HttpResponse;

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
		 * 1:解析请求,创建HttpRequest
		 *   创建响应对象HttpResponse
		 * 2:处理请求
		 * 3:给予响应
		 */
		try {
			//1解析请求,生成HttpRequest对象
			HttpRequest request = new HttpRequest(socket);
			HttpResponse response = new HttpResponse(socket);
			
			//2处理请求
			/*
			 * 通过request获取请求的资源路径，从
			 * webapps中寻找对应资源
			 */
			String url = request.getRequestURI();
			//判断是否请求注册业务
			if("/myweb/reg".equals(url)){
				System.out.println("开始处理注册业务！！");
				/*
				 * 注册业务流程
				 * 1:通过request获取用户在注册页面上输入的
				 *   注册信息
				 * 2:使用RandomAccessFile打开user.dat文件
				 * 3:将该用户信息写入文件
				 * 4:设置response，响应注册成功页面。 
				 */
				//1
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String nickname = request.getParameter("nickname");
				int age = Integer.parseInt(request.getParameter("age"));
				//还要对用户数据进行必要验证
				
				//2
				try(
					RandomAccessFile raf 
						= new RandomAccessFile("user.dat","rw");
				){
					raf.seek(raf.length());
					//写用户名
					byte[] data = username.getBytes("UTF-8");
					data = Arrays.copyOf(data, 32);
					raf.write(data);
					
					//写密码
					data = password.getBytes("UTF-8");
					data = Arrays.copyOf(data, 32);
					raf.write(data);
					
					//写昵称
					data = nickname.getBytes("UTF-8");
					data = Arrays.copyOf(data, 32);
					raf.write(data);
					
					//写年龄
					raf.writeInt(age);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//3响应客户端注册成功页面
				response.setStatusCode(200);
				File file = new File("webapps/myweb/reg_success.html");
				response.setEntity(file);

			}else if("/myweb/login".equals(url)){
				//处理登录流程
				//1
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				//2
				try(
					RandomAccessFile raf = new RandomAccessFile("user.dat","r");	
				){
					boolean check = false;
					for(int i=0;i<raf.length()/100;i++){
						//每次读取前先将指针移动到该条记录的开始位置
						raf.seek(i*100);
						
						//读取用户名
						byte[] data = new byte[32];
						raf.read(data);
						String name = new String(data,"UTF-8").trim();
						
						//判断是否为该用户
						if(name.equals(username)){
							//读取密码
							raf.read(data);
							String pwd = new String(data,"UTF-8").trim();
							if(pwd.equals(password)){
								//登录成功
								check = true;
								response.setStatusCode(200);
								response.setEntity(new File("webapps/myweb/login_success.html"));
								break;
							}
						}
					}
					if(!check){
						//跳转登录失败页面
						response.setStatusCode(200);
						response.setEntity(new File("webapps/myweb/login_fail.html"));
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			
			}else{
				File file = new File("webapps"+url);
				if(file.exists()){
					System.out.println("资源已找到!");
					/*
					 * 以一个标准的HTTP响应格式回复客户端该资源
					 */				
					response.setStatusCode(200);
					response.setEntity(file);						
				}else{
					System.out.println("资源未找到!");
					file = new File("webapps/myweb/404.html");
					response.setStatusCode(404);			
					response.setEntity(file);
				}
			}
			//3响应客户端
			response.flush();
		}catch(EmptyRequestException e){
			System.out.println("空请求!");
		}catch (Exception e) {
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







