创建数据库 tedustore

建表-看需求文档和静态页面
id            int           primary      
username      varchar(50)   unique
password      varchar(50)   not null
phone         varchar(32)   not null
email         varchar(50)   not null
image         varchar(100)  可以为空
gender        int(1)        可以为空    
created_user  varchar(50)   
created_time  date
modified_user varchar(50)
modified_time date

