本版本改动:
支持所有介质类型。tomcat中的conf目录里有一个web.xml
文件，该文件中配置着所有资源后缀与对应的Content-Type
的值。我们将该文件拷贝到我们的项目中，并在HttpContext
的initMimeMapping方法中解析该文件来初始化介质映射。

1:在项目目录中新建一个目录conf
2:将tomcat中的web.xml文件拷贝到conf目录中
3:导入dom4j的jar包
4:修改HttpContext初始化介质类型映射的方法:
  intMimeMapping
  































