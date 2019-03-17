本版本改动:
使得服务端支持客户端以POST形式提交form表单数据。
当一个form表单中含有用户隐私数据或者附件时，都应当
使用POST形式提交数据。而POST请求会将用户提交的数据
放在请求的消息正文部分传递给服务端。


1:将注册页面中form表单的提交形式改为POST。 

2:在HttpRequest中完成parseContent解析消息正文的
    方法。
    根据消息头判断是否含有Content-Length来决定此请求
    是否包含消息正文。
    然后在根据Content-Type来判断消息正文内容。这里指
    判定form表单的。
  
3:将原来parseURL方法中解析参数的功能代码提出来，定义
    为方法parseParameter,并让parseURL对应功能改为调
    用此方法。这样在解析消息正文时读取到post提交过来的
    表单数据时也可以利用该方法解析。    
      










