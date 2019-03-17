本版本改动:
将客户端请求的页面响应给客户端。
本次版本要了解HTTP协议中的响应(response)规则。要严
格按照HTTP协议的响应格式给与客户端响应，这样浏览器
才能得到正确的结果。

1:在项目目录中添加一个新目录webapps
    使用该目录保存不同网站所需要的素材等内容。

2:在webapps目录下新建子目录myweb
  myweb作为我们测试的网站资源的目录    

注:在TOMCAT中webapps目录是存放所有web应用的。其中每
      一个子目录都是一个具体的web应用(一个网站内容，涵盖
      页面，图片等素材以及处理业务逻辑的java代码等)

3:在myweb中添加页面index.html


4:浏览器的地址栏中请求某个服务端资源时，是无法写在服务
     端该资源的绝对路径的，只能写相对路径(这样的好处也很
     多，比如没有平台差异性等。)。
例如:浏览器地址栏输入的地址为:
http://localhost:8080/index.html
协议部分  服务器地址信息   资源路径部分(请求行url内容)

我们可以规定在资源路径部分中的根为我们定义的保存所有
资源的目录webapps。
那么，若想找到webapps/myweb/index.html页面的话，浏
览器地址栏要输入为:
http://localhost:8080/myweb/index.html
当该请求发送到服务端时，我们解析请求中请求行里的url部
分会得到/myweb/index.html,那么我们就对应的从webapps
目录中找到对应资源:webapps/myweb/index.html并将该
资源响应给客户端。












