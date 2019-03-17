本版本改动:
使服务端支持处理业务操作:完成注册业务。
  
1:在webapps/myweb/下新建一个注册页面reg.html

2:当页面上的form表单以GET形式提交时，表单中用户输入
    的内容会拼接到地址栏中url里。所以服务端在解析请求
    时获取请求行中url部分时，可能会得到两种情况的内容:
  1:不含有参数的，如:
    /myweb/index.html
  
  2:含有参数的，如:
    /myweb/reg?username=fan&password=123&...  
  
    因此我们要重构HttpRequest这个类的解析工作，对请求
    行中url部分要进行进一步的解析工作。
  2.1:在HttpRequest中添加三个新的属性，用于保存url
            中的各部分内容
      String requestURI:保存请求部分
      String queryString:保存参数部分
      Map parameters:保存每个参数(通过解析queryString得到)             
  
  2.2:提供一个专门用来解析请求行中url部分的方法:
  	  void parseUrl(String url)
            解析后，将url各部分内容设置到2.1定义的属性上
  
  2.3:在解析请求行的方法中，得到url后，调用2.2
            提供的方法进一步解析url
  
  2.4:为2.1定义的属性提供对应的get方法，便于外面获
            取这些信息          

3:在ClientHandler中添加一个新的分支，判断请求是否为
    请求注册业务

4:若是请求注册业务，则通过request获取用户在注册页面
    上输入的注册信息，并通过RandomAccessFile打开
  user.dat文件，将该记录写入文件。
    每条记录占100字节，其中用户名，密码，昵称为字符串
    各占32字节，年龄为int值占4字节。
    具体写入的操作可以参考SE项目中raf包中Demo1.java。
    
5:在webapps/myweb/下新建一个页面reg_success.html

6:当注册完毕后，设置response跳转reg_success.html
    完成注册流程        
























