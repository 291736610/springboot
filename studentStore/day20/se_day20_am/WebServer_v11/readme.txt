本版本改动:
重构项目,利用反射机制，使得ClientHandler无需再关注
具体的请求应当实例化哪个Servlet。而是将请求与对应的
Servlet的名字进行可配置的，让ClientHandler根据请求
获取对应的Servlet的名字，然后利用反射实例化该Servlet
并调用其service方法执行业务。这样做的好处在于，无论
将来再添加什么业务，ClientHandler都无需再修改。

1:在core包中定义类ServerContext，用于定义服务端
    使用的一些配置信息。

2:在ServerContext中定义一个静态属性:
  Map<String,String> servletMapping;

3:在项目目录中的conf里添加一个新的配置文件:
  server.xml,并在其中添加请求与Servlet之间的对应
    关系。
    定义一个静态方法用于初始化servletMapping:
  static void initServletMapping()   

4:定义静态块，并在静态块中调用initServletMapping
    来初始化请求与对应Servlet名字的映射关系。

5:定义根据请求获取对应Servlet名字的方法
  static String getServletName(String url)     
 
6:修改ClientHandler,首先通过ServerContext根据
    用户请求获取对应的Servlet名字，若找到，则使用
    反射的方式实例化该Servlet并调用service方法。
     
 
 
 
 
 
 
    
    
    
    