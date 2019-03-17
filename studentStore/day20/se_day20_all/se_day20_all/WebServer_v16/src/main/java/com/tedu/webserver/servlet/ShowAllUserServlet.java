package com.tedu.webserver.servlet;

import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import com.tedu.webserver.http.HttpRequest;
import com.tedu.webserver.http.HttpResponse;
/**
 * 查看所用注册用户信息
 * @author adminitartor
 *
 */
public class ShowAllUserServlet extends HttpServlet{
	public void service(HttpRequest request, HttpResponse response) {
		try {
			//拼接动态页面
			StringBuilder builder = new StringBuilder();
			builder.append("<html>");
			builder.append("<head>");
			builder.append("<title>用户列表</title>");
			builder.append("<meta charset='UTF-8'>");
			builder.append("</head>");
			builder.append("<body>");
			builder.append("<center>");
			builder.append("<h1>用户列表</h1>");
			builder.append("<table border='1'>");
			builder.append("<tr>");
			builder.append("<td>用户名</td><td>密码</td><td>昵称</td><td>年龄</td>");
			builder.append("</tr>");
			try (RandomAccessFile raf = new RandomAccessFile("user.dat","r")){
				for(int r=1;r<=raf.length()/100;r++){
					//读取用户名
					byte[] arr = new byte[32];
					raf.read(arr);
					String username = new String(arr,"UTF-8").trim();
					//读取密码
					arr = new byte[32];
					raf.read(arr);
					String password = new String(arr,"UTF-8").trim();
					//读取昵称
					arr = new byte[32];
					raf.read(arr);
					String nickname = new String(arr,"UTF-8").trim();
					//读取年龄
					int age = raf.readInt();
					builder.append("<tr>");
					builder.append("<td>"+username+"</td>");
					builder.append("<td>"+password+"</td>");
					builder.append("<td>"+nickname+"</td>");
					builder.append("<td>"+age+"</td>");
					builder.append("</tr>");
				}
			} catch (Exception e) {
			}
			builder.append("</table>");
			builder.append("</center>");
			builder.append("</body>");
			builder.append("</html>");
			String html = builder.toString();
			byte[] data = html.getBytes("UTF-8");
			
			response.setStatusCode(200);
			response.putHeaders("Content-Length", data.length+"");
			response.putHeaders("Content-Type", "text/html");
			response.setData(data);
			
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}
}







