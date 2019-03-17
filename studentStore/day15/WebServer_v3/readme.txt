本版本改动:
将客户端发送过来的请求完整解析出来，生成一个
HttpRequest对象保存。以便后续操作。

1:新建一个包:http
2:在http包中定义类HttpRequest，用其每一个实例表示
    一个具体的客户端发送过来的请求
3:在ClientHandler中实例化HttpRequest并将Socket传入
    以便HttpRequest获取输入流解析客户端请求
4:在HttpRequest的构造方法中完成解析工作。        
    由于一个请求含有三部分:请求行，消息头，消息正文
    所以在构造方法中也分为三部分进行解析。







