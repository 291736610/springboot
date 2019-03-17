本版本改动:
使服务端支持处理业务操作:完成登录业务。

1:在webapps/myweb中准备三个页面:
  login.html 登录页面
    页面中应当包含两个输入框:username,password
    然后该页面中的form表单action指定为login。
    
  login_success.html  提示用户登录成功的页面
  login_fail.html 提示用户登录失败的页面  
  
2:在ClientHandler的判断注册业务下面再添加一个分支
    判断请求路径是否为"/myweb/login",若是则开始处理
    登录业务。

3:首先通过request获取用户在登录页面中输入的用户名
    及密码，然后使用RAF读取user.dat文件，顺序匹配每个
    注册用户，若其中一个用户信息与该登录信息匹配则设置
  response跳转登录成功页面，若最终没有任何记录匹配，
    则跳转登录失败页面。
    登录操作参考SE项目raf包中的Demo3.java案例







