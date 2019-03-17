本版本改动:
实现动态页面的生成

完成查看所有用户信息的功能。
1:创建一个ShowAllUserServlet
    并在该Servlet中将user.dat文件中数据全部读取出来
    并拼接为一个htnl代码。然后作为响应正文内容最终
    通过response发送给客户端
    
2:HttpResponse中再定义一个byte[]类型的属性data
    用于作为另一种响应正文内容
    
3:在发送响应正文的部分添加另一种分支，若data数组有
    数据，则将该数据作为正文内容发送给客户端    


