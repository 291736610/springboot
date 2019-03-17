##数据库
###io流文件存储数据的弊端
1. 存储效率低
2. 不管存还取操作比较麻烦
3. 一般只能保存小量字符串数据
###DB
- data base 数据库
- 什么是数据库： 数据库实际上就是一个文件集合
- 数据库就是一个存储数据的仓库，本质就是一个文件系统，数据库是按照特定的格式把数据存储起来，用户可以对存储的数据进行增删改查操作
###DBMS
- DataBaseManagementSystem：数据库管理系统(软件)
- 什么是DBMS： 用来管理数据库文件的软件，用户需要访问DBMS对数据进行增删改查操作。
常见DBMS： MySQL  oracle DB2 sqlite sqlserver..
###数据库的分类
分为两类：
1. 关系型数据库： 经过数学理论验证 可以保存现实生活中的各种关系数据， 数据库中存储数据以表为单位。
2. 非关系型数据库：通常用来解决某些特定的需求如：数据缓存，高并发访问。 存储数据的形式有多种，举例：Redis数据库：通过键值对的形式存储数据。
###主流关系型数据库介绍
1. MySQL： 08年被sun公司收购 09年sun被oracle收购，开源免费，到oracle发布了5.0版本（使用了oracle核心技术 性能提高30%），因为Oracle数据库地位受到威胁，计划把mysql闭源，原mysql作者们不干了，原程序员出去单干 发布了MariaDB数据库 名字是因为作者女儿叫Maria ，市场排名第一
2. Oracle： 闭源， 最贵 性能最高 拉里埃里森32 市场排名第二
3. SQLServer：微软公司的产品 市场排名第三，主要应用在.net(C#)开发的网站中
4. DB2： IBM公司 有做网站的完整解决方案（操作系统，we服务器（如tomcat），数据库等）主要应用在银行等国有大型企业中
5. sqlite：轻量级数据库 只有几十k，一般应用在嵌入式和移动设备中
###开源和闭源的区别
1. 开源： 开发源代码，盈利方式靠卖服务（赚钱慢，少），用户群大，大牛程序员会无偿帮着升级维护 
2. 闭源：不开放源代码，盈利方式卖产品+服务（赚钱快，多），大牛们各种攻击找漏洞 
###数据库的安装
- 两点注意： 端口号默认3306，字符集选择utf-8

###SQL
	Structured Query Language:结构化 查询 语言
- sql是写在客户端 执行在DBMS中，DBMS解析后执行
###打开数据库客户端 并登陆
- 在终端中执行以下命令
mysql -uroot -p  敲回车  因为没有密码 所以再次敲回车 如果有密码则先敲密码再回车
- 退出命令： exit;

---------------------------------------------------------------------------------------
###数据库相关的SQL
1. 查看所有数据库
	
		show databases;
2. 创建数据库
	-格式：create database 数据库名称;

		create database db1;
3. 查看数据库详情
	-格式： show create database 数据库名;

		show create database db1;

4. 创建数据库指定字符集 utf8或gbk
	
		create database db2 character set utf8;

		create database db2 character set gbk;
5. 删除数据库 

		drop database db2;

6. 使用数据库

	use db1;
	
---------------------------------------------------------------------------------------

###和表相关的SQL
- 什么是表： 关系型数据库中保存数据的单元，类似于Excel中的表，创建表时需要指定字段信息
1. 创建表
	-格式： create table 表名 (字段1名 字段1类型,字段2名 字段2类型);

	create table person(name varchar(10),
	age int);

	create table student(id int,name varchar(10),gender varchar(5),chinese int,math int,english int);


###和表相关的SQL
#### 查询所有表

		show tables;

#### 查看单个表属性

	show create table person;

###表的引擎
1. Myisam： 只支持数据基础的增删改查，不支持高级操作，如：事务、外键等
2. InnoDB：支持高级操作，默认为InnoDB。

####创建表并且指定引擎和字符集

	create table t1(id int,name varchar(10)) engine=myisam charset=gbk;
	-查询：
	show create table t1;
####查看表字段信息

	desc student;

###对创建好的表进行修改

####修改表名

		rename table 原名 to 新名；

		rename table student to t_stu;
		
####修改表引擎和字符集
	
		alter table hero engine=myisam charset=gbk;

####添加表字段
- 最后位置添加
		alter table hero add age int;
- 最前面添加
		alter table hero add money int first;
- 在某个字段的后面添加
		alter table hero add gender varchar(5) after name;
####删除表字段
	
		alter table hero drop money;

####修改表字段名和类型

		alter table hero change 原字段名 新字段名 类型;
		alter table hero change name heroname varchar(10);
####修改表字段类型和位置

		alter table hero modify age int first;
		alter table hero modify age int after xxx;
####删除表

		drop table hero;

###数据相关的SQL

####插入数据
- 创建学生表
	
		create table student(id int,name varchar(10),chinese int,math int,english int);
- 插入数据 全表插入：每个字段都赋值 顺序要和表字段一致

		insert into student values(1,'zhangsan',88,38,98);
- 指定字段插入

		insert into student (id,name) values (2,'张飞');

- 批量插入
	
		insert into student values(6,'唐僧',56,57,58),(7,'八戒',88,89,99);

		insert into student (id,name) values
		(8,'吕布'),(9,'貂蝉'),(10,'孙尚香');

####查询
-查询全部数据的全部字段信息
		
		select * from student;

-查询指定字段
		
		select id,name from student;

-条件查询
		
		select * from student where id<5;

####修改数据

		update student set math=100; 
		 
		update student set english=30 where id=7;
####删除数据
		
		delete from student where id=7;
		
		delete from student;


-----------------------------------------MySQL02---------------------------------------	
###主键约束
- 给主键添加约束，起到非空并且唯一的作用，主键指表示数据唯一性的字段，一张表中只有一个主键
- 如何使用：
	
	create table t1(id int primary key,name varchar(10));
- 测试 以下代码第二行报错因为id重复了
	insert into t1 values(1,'李白');
	insert into t1 values(1,'杜甫');
- 测试：第一行mariaDB报错，mysql会插入一个0，第二行会报错 id值不能为null；
	insert into t1 (name) values ('黄忠');
	insert into t1 values (null,'张三');
- 主键约束+自增
	create table t2(id int primary key auto_increment, name varchar(10));
	
- 自增总结：
1. 表内自增的数值 只增不减
2. 清空表的数据 数值不归零 继续增长
3. 数值以出现过的最大值的基础+1
###注释 comment
- 注释 可以在创建表添加字段的时候对字段进行介绍，便于以后查看表的时候知道每个字段的作用
- 如何使用：
		
		create table t3(id int primary key auto_increment comment '这是个主键',name varchar(10),comm int comment '这是奖金');

		show create table t3;

###` '区别
- `的作用是用来修饰表名和字段名,可以省略
- '的作用是用来修饰字符串的

###数据冗余
- 什么是冗余：如果设计表不够合理，随着数据量的增多，出现大量的重复数据，称为数据的冗余。

###事务
- 事务是数据库中执行sql语句的最小工作单元
- 如何开启事务： 关闭客户端自动提交，改成手动提交，把多次修改数据库的sql 放在一次提交中，则多次操作数据库的sql就相当于是放到了同一个事务中
- 数据库默认的提交方式是自动提交
- 没有事务是如下过程
1. 超人+300  提交

2. 蝙蝠侠-300 提交
以上代码如果第一次提交中断（断电）则数据库中的数据会异常
- 有事务的过程：
1. 关闭自动提交
2. 超人+300
3. 蝙蝠侠-300
4. 手动提交 
以上代码就算中间异常中断 ，结果要么同时成功 要么同时失败

- 为什么使用事务？ 
		如果不使用事务，客户端会自动提交，多次操作数据库做某一件事儿的时候（如：转账）会出现部分成功部分失败，则数据会出现异常，使用事务，把多次操作数据库的sql合并到一次提交中，这样就能保证同时成功或失败。
- 使用事务的执行过程？ 
1. 关闭自动提交
2. 执行多次sql （在内存中执行）
3. 手动提交

####查看客户端自动提交的状态

	show variables like '%autocommit%';
####关闭自动提交 仅对当前窗口生效
	
- 关闭：
		set autocommit=0;
- 打开：
		set autocommit=1;
####验证转账流程：
1. 创建表
	create table person(id int primary key auto_increment, name varchar(10),money int);
2. 插入数据
	insert into person values(null,'超人',200),(null,'蝙蝠侠',10000);

3. 关闭自动提交
4. 转账 
	update person set money=500 where id=1;
	update person set money=9700 where id=2;
5. 打开新的窗口 验证是否转账成功？ 数据没变 因为两次操作都是在内存中操作 并未提交

6. 手动提交
		commit;
####数据回滚
- 执行rollback会将数据回滚到上次提交的点
	rollback;
- 验证回滚：
1. 修改一次数据
2. 查看数据 发现已经在内存中改了
3. 执行rollback
4. 查询发现回到了上次提交的点
####设置回滚点
1. 保存回滚点： savepoint s1(标识);
2. 回滚到指定的回滚点：  rollback to s1;
- 验证回滚：
1. 先将超人500改成600
2. 保存回滚点 s1
3. 将超人钱从600改成700
4. 回滚到s1 如果超人的钱 为600则说明成功！
---------------------------------------------------------------------------------------
###SQL分类
#### DDL 
- Data Definition Language 数据定义语言
- 包括: create,alter,drop, truncate， 不支持事务。
#### DML
- Data Manipulation Language 数据操作语言
- 包括: insert, update,delete,select(DQL)
- 支持事务
#### DQL
- Data Query Language数据查询语言
- 包括：select
- 和事务没关系 
#### TCL
- Transaction Control Language：事务控制语言
- 包括：commit rollback savepoint 
#### DCL
- Data Control Language:数据控制语言
- 分配用户权限相关的sql 

#####truncate 删除表 并且创建一个新表
- 用法： truncate table t1;
####truncate，delete，drop的区别
1. delete：删除表中的数据 自增数值不清零 支持事务
2. drop：删除表 不支持事务
3. truncate：删除表并且创建一个新表 自增数值清零 不支持事务

###数据库的数据类型

- 五种数据类型分别为：
1. 整数
2. 浮点数
3. 字符串
4. 日期
5. 其它
####整数
- 常用： int(m)  bigint(m) ,m代表显示长度，如果数据长度不足m时会在数值前面补0, 但是必须和zerofill关键字结合使用，使用方式如下：

	create table t_int(num int(10) zerofill);

	insert into t_int values(25);
	
	select * from t_int;
####浮点数
- 常用：
1. double(m,d): m代表总长度 d代表小数长度
	75.233
	-测试：
 	create table t_double(num double(5,3));
	insert into t_double values(12.3456);//四舍五入
	insert into t_double values(1.23);//不足3则补零
2. decimal(m,d):m代表总长度 d代表小数长度,超高精度小数，需要涉及超高精度运算的时候使用。
####字符串
- char(m): m代表字符长度，固定长度，执行效率高（不用改变长度），最大长度255
- varchar(m):可变长度，会根据内容长度改变自身长度，更节省资源，最大长度65535，如果长度超过255建议使用text。
- text：可变长度，最大值65535。
####日期
- date:只能保存 年月日
- time:只能保存 时分秒
- datetime:年月日时分秒，默认值null，最大值9999年12月31日
- timestamp:年月日时分秒，默认值为当前时间，最大值2038年01月19号

- 测试：
	create table t_date(t1 date,t2 time,t3 datetime,t4 timestamp);
	
	insert into t_date values('2018-05-16',null,null,null);
	select * from t_date;
	
	insert into t_date values(null,'12:32:18','2018-05-11 18:30:08',null);

-----------------------------------------mysql03---------------------------------------	

## 查询
#### is null
1. 查询没有上级领导的员工编号，姓名，工资
	
		select empno,ename,sal from emp
		where mgr is null;
2. 查询emp表中没有奖金(comm)的员工姓名，工资和奖金
	
		select ename,sal,comm from emp
		where comm is null;
####is not null 不为null
1. 查询emp表中有奖金的员工所有信息

		select * from emp 
		where comm is not null;
####别名
1. 查询emp中所有姓名 将ename 显示成'姓名'
	select ename as '姓名' from emp;
	select ename '姓名' from emp;
	select ename 姓名 from emp;
####去重 
1. 查询emp表中出现的所有职位
	select distinct job from emp;
#### 比较运算符 >, <, >=, <=, =, !=和<>
1. 查询工资小于等于1600的所有员工姓名和工资
	select ename,sal from emp
	where sal<=1600;
2. 查询部门编号是20的所有员工姓名、职位job和部门编号deptno
	select ename,job,deptno from emp
	where deptno=20;
3. 查询职位是manager的所有员工姓名和职位
	select ename,job from emp
	where job='manager';
4. 查询部门不是10号部门的所有员工姓名和部门编号使用两种方式实现
	select ename,deptno from emp
	where deptno!=10;
	select ename,deptno from emp
	where deptno<>10;
5. 查询t_item表中单价price等于23的商品信息
	select * from t_item 
	where price=23;
6. 查询t_item表中单价不等于8443的商品信息
	select * from t_item 
	where price!=8443;
#### and 和 or
- and 和java中的&&效果一样
- or 和java中的||效果一样
1. 查询不是10号部门并且工资小于3000的员工信息
	select * from emp
	where deptno!=10 and sal<3000;
2. 查询部门编号为30或者上级领导为7698的员工姓名，职位，上级领导和部门编号
	select ename,job,mgr,deptno from emp
	where deptno=30 or mgr=7698;
#### in
1. 查询emp表中工资为5000，1500,3000的员工信息
		
		select * from emp where sal in (5000,1500,3000);

#### between x and y  在x和y之间 包括x和y
1. 查询emp表中 工资在2000至4000之间的员工信息
	
		select * from emp
		where  sal between 2000 and 4000;
#### like 
- _： 代表单个未知字符
- %: 代表0个或多个未知字符
- 举例： 
1. 包含字符a ：     %a%
2. 以a开头：      a%
3. 以a结尾：     %a
4. 第二个字符是a：    _a%
5. 倒数第三个字符是a： %a__
6. 第二个字符是a,最后一个字符是b： _a%b
#####like案例
1. 查询标题中包含记事本的商品标题
	
		select title from t_item
		where title like '%记事本%';
2. 查询单价低于100的记事本(title包含记事本)标题和单价
		select title from t_item
		where title like '%记事本%' 
		and price<100; 
3. 查询单价在50到200之间的得力(title包含得力)商品
		select title,price from t_item
		where title like '%得力%' 
		and price between 50 and 200;
4. 查询有图片(image字段不为null)的得力商品
		select * from t_item
		where title like '%得力%'
		and image is not null;
5. 查询分类(category_id)为238,917的商品信息
		select * from t_item
		where category_id in (238,917);
6. 查询含有赠品的商品信息（sell_point中包含赠字）
	select sell_point from t_item 
	where sell_point like '%赠%';
7. 查询标题中不包含得力的商品标题
	select * from t_item
	where title not like '%得力%'
8. 查询价格介于50到200之外的商品信息
	select * from t_item
	where price not between 50 and 200;
	
###排序 order by
- order by 写在where后面 没有where 写在最后
- by 的后面写排序的字段名称
- 默认排序是升序，也可指定 升序：asc 降序：desc
- 举例： select name,age from person where age<50 order by age desc;
1. 查询所有员工的姓名和工资，按照工资降序排序
		select ename,sal from emp
		order by sal desc;
2. 查询所有dell商品，按单价降序排序
		select title,price from t_item
		where title like '%dell%'
		order by price desc;
3. 查询所有员工信息按照部门编号升序排序,工资降序排序。
		select * from emp
		order by deptno, sal desc;
		
####分页查询 limit   
- limit 跳过数量,每页的数量 ，第5页 每页3条 
	limit (页数-1)*每页条数,每页条数
	第1页 每页5条
	limit 0,5
- limit 关键字通常写在sql的最后面
1. 查询所有商品 按照单价升序排序，显示第二页，每页7条数据
	
		select * from t_item order by price 
		limit 7,7;
2. 查询工资金额前三名的三位员工信息
	
		select * from emp order by sal desc
		limit 0,3;
###数值计算 + - * /  %   7%2 等效 mod(7,2)
1. 查询员工姓名，工资，及年终奖信息（年终奖=工资*5）;

	select ename,sal,sal*5 年终奖 from emp;
2. 查询t_item表中商品单价，库存和总金额（单价*库存）
	select price,num,price*num 总金额 from t_item;
###日期相关函数
- select 'helloworld';

- 获取当前日期+时间  now() 

		select now();
- 获取当前的日期 current：当前
		select curdate();
- 获取当前的时间
		select curtime();
- 从年月日时分秒中 提取年月日  和 提取时分秒
		select date(now());
		select time(now());
- 从年月日时分秒中 提取 年,月，日，时，分，秒
	
		select extract(year from now());
		select extract(month from now());
		select extract(day from now());
		select extract(hour from now());
		select extract(minute from now());
		select extract(second from now());
- 日期格式化函数

		格式： date_format(date,format)
- format:  
%Y 四位年， %y 两位年，
%m 两位月，%c 一位月份，
%d 日， 
%H 24小时 ，%h 12小时，
%i 分，
%s 秒
1. 把now()转换成 2018年06月19日 16时27分30秒的格式
		
		select date_format(now(),'%Y年%m月%d日 %H时%i分%s秒');
- 把非标准格式的时间转成标准格式 

		str_to_date(非标准格式的时间,格式);
1. 把14.08.2008 08:00:00 转成标准格式
		
		select str_to_date('14.08.2008 08:00:00','%d.%m.%Y %H:%i:%s');

 
###ifnull()函数
	
		age=ifnull(x,y) 如果x的值为null则age=y如果x不为null则age的值为x 
1. 将emp表中奖金为null的全部修改为0
	
		update emp set comm=ifnull(comm,0);

###聚合函数
- 对多行数据进行统计：
- 求和：sum(字段名)
	
		举例：emp中工资总和
		select sum(sal) from emp;
- 平均值:avg(字段名)
		
		select avg(sal) from emp where deptno=10;
- 最大值:max(字段名)
		
		select max(sal) from emp where deptno=10;
- 最小值:min(字段名)

		select min(sal) from emp where deptno=10;
- 统计数量:count(*)

		select count(*) from emp where sal<1000;

###字符串相关函数
1. 字符串拼接 concat(s1,s2)  s1s2
- 案例：查询emp表中 员工姓名和工资 工资后面有单位元

		select ename,concat(sal,'元') from emp;
2. 获取字符串的长度 char_length(str)
- 案例： 查询员工姓名和名字的长度
	
		select char_length('abc');
		select ename,char_length(ename) from emp;
3. 获取字符串在另外一个字符串中出现的位置 从1开始
	-格式：instr(str,substr)

		select instr('abcdefg','d');
	-格式2：locate(substr,str)

		select locate('d','abcdefg');
4. 插入字符串 位置从1开始
	-格式：insert(str,start,length,newstr)
	
		select insert('abcdefg',3,2,'m');
5. 转大写和转小写  
	-格式：upper(str) lower(str)

		select upper('Nba'),lower('NBA');
6. 从左边截取 和从右边截取
	-格式： left(str,count) right(str,count)
	
		select left('abcdefg',2);
		select right('abcdefg',2);
7. 去字符串两端的空格 
		
		select trim('  a b  ');
8. 截取字符串

		select substring('abcdefg',2);
		select substring('abcdefg',2,3);
9. 重复 repeat(str,count)

		select repeat('ab',2);

10. 替换 replace(str,old,new);

		select replace('abcde','c','m');
11. 反转 reverse(str)

		select reverse('abc');

		----------------------------------------------------------------------------
		
###分组查询
- 分组查询通常和聚合函数结合使用
- 一般情况下 每个部门(职位、分类) 就以部门(职位、分类)作为分组的条件
- 可以有多个分组条件

1. 查询每个部门的最高工资
	
		select deptno,max(sal) from emp group by deptno;
2. 查询每个职位的平均工资
		
		select job,avg(sal) from emp 
		group by job;

3. 查询每个部门下每个主管的手下人数
		
		select deptno,mgr,count(*) from emp
		group by deptno,mgr;

- group by 存在的位置
	select * from emp 
	where ......
	group by ...
	order by ...
	limit ...
	---------------------------------------------------
###子查询(嵌套查询)

1. 查询emp表中工资最高的员工信息
	select max(sal) from emp;
	select * from emp where sal=5000;
- 将以上两条合并成一条sql
	select * from emp where sal=(select max(sal) from emp);
2. 查询emp表中工资超过平均工资的所有员工信息
	select * from emp where sal>(select avg(sal) from emp);
3. 查询工资高于20号部门平均工资的员工信息
	select * from emp where sal>(select avg(sal) from emp where deptno=20);
4. 查询和Jones相同工作的其它员工信息
	select job from emp where ename='jones';
	select * from emp where job=(select job from emp where ename='jones') and ename!='jones';
5. 查询工资最低的员工的相同部门的员工信息
	select min(sal) from emp;

	select deptno from emp where sal=(select min(sal) from emp);

	select * from emp where deptno=(select deptno from emp where sal=(select min(sal) from emp));

- having 要和 group by 结合使用 
6. 查询最后入职的员工信息 

	select * from emp where hiredate=(select max(hiredate) from emp);
	
7. 查询姓名为king的部门编号和部门名称（需要使用dept表）
	select deptno from emp where ename='king';

	select deptno,dname from dept where deptno=(select deptno from emp where ename='king');
8. 查询有商品的分类id和分类名称（有商品 就是在商品表中出现的分类，需要使用t_item_category表）
- 先从商品表中得到所有的分类id 
	 
	select distinct category_id from t_item;
- 从分类表中查询id等于上面结果的分类信息
	select id,name from t_item_category
	where id in(select distinct category_id from t_item);
9. 查询有员工的部门信息
	
	select distinct deptno from emp;

	select * from dept where deptno in(select distinct deptno from emp);
10. 扩展题（难度最高）：查询平均工资最高的部门信息
- 得到最高的平均工资
	select avg(sal) a from emp group by deptno order by a desc limit 0,1;
- 通过最高的平均工资 得到 部门的编号
	select deptno from emp
	group by deptno
	having avg(sal)=(select avg(sal) a from emp group by deptno order by a desc limit 0,1);
- 通过部门编号得到部门信息
	select * from dept where deptno in(select deptno from emp
	group by deptno
	having avg(sal)=(select avg(sal) a from emp group by deptno order by a desc limit 0,1));

###子查询总结
1. 嵌套在SQL语句中查询语句称为子查询
2. 子查询能嵌套n层 
3. 子查询可写的位置：
- 可以写在 where/having的后面作为查询条件的值
- 可以写在 from后面 当一张新表 **新表必须有别名**
- 可以写在创建表的时候
	
		create table t_emp_10 as (select * from emp where deptno=10);
		-------------------------------------------------------------------
###关联查询
- 同时查询多张表的数据称为关联查询
1. 查询每一个员工的姓名和对应的部门名称
	select e.ename,d.dname
	from emp e,dept d
	where e.deptno=d.deptno;
2. 查询在纽约工作的所有员工的信息
	select e.*
	from emp e,dept d
	where e.deptno=d.deptno and d.loc='new york';
###笛卡尔积

- 关联查询如果不写关联关系，则查询结果为两张表的乘积，这个乘积称为 笛卡尔积
- 笛卡尔积是一种错误的查询结果，工作中切记不要出现

###等值连接和内连接
1. 等值连接：
	select * from A,B 
	where A.x=B.x and A.age=18
2. 内连接 用的更多
	select * from A join B
	on A.x=B.x
	where A.age=18;
- 查询每个员工的姓名和对应的部门名称
	select e.ename,d.dname
	from emp e join dept d
	on e.deptno=d.deptno;
###外连接
	
- 左外连接： 以join 左边表为主表 左边表显示所有数据右边交集数据

	select e.ename,d.dname
	from emp e left join dept d
	on e.deptno=d.deptno;
- 右外连接： 以join 右边表为主表 右边表显示所有数据左边交集数据

	select e.ename,d.dname
	from emp e right join dept d
	on e.deptno=d.deptno;

###关联查询总结：
	
		等值连接，内连接，外连接都是关联查询的查询方式使用哪一种取决于具体业务需求
1. 查两个表的交集数据 使用内连接(推荐)或等值连接
2. 查一个表所有数据另外一个表交集数据使用外连接
### 练习
	1.案例：查询没有上级领导的员工的编号，姓名，工资
	2.案例：查询emp表中没有奖金的员工的姓名，职位，工资，以及奖金
	3.案例：查询emp表中含有奖金的员工的编号，姓名，职位，以及奖金
	4.案例：查询含有上级领导的员工的姓名，工资以及上级领导的编号
	5.案例：查询emp表中名字以‘S’开头的所有员工的姓名
	6.案例：查询emp表中名字的最后一个字符是'S'的员工的姓名
	7.案例：查询倒数的第2个字符是‘E’的员工的姓名
	8.案例：查询emp表中员工的倒数第3个字符是‘N’的员工姓名
	9.案例：查询emp表中员工的名字中包含‘A’的员工的姓名	
	10.案例：查询emp表中名字不是以'K'开头的员工的所有信息
	11.案例：查询emp表中名字中不包含‘A’的所有员工的信息
	12.案例：做文员的员工人数（job_id 中 含有 CLERK 的）
	13.案例：销售人员 job: SALESMAN 的最高薪水
	14.案例：最早和最晚入职时间
	15.案例：查询类别 163的商品总库存量
	16.案例：查询 类别 163 的商品
	17.案例：查询商品价格不大于100的商品名称列表
	18.案例：查询品牌是联想,且价格在40000以上的商品名称和价格
	19.案例：查询品牌是三木,或价格在50以下的商品名称和价格
	20.案例：查询品牌是三木、广博、齐心的商品名称和价格
	21.案例：查询品牌不是联想、戴尔的商品名称和价格
	22.案例：查找品牌是联想且价格大于10000的电脑名称
	23.案例：查询联想或戴尔的电脑名称列表
	24.案例：查询联想、戴尔、三木的商品名称列表
	25.案例：查询不是戴尔的电脑名称列表
	26.案例：查询所有是记事本的商品品牌、名称和价格
	27.案例：查询品牌是末尾字符是'力'的商品的品牌、名称和价格
	28.案例：名称中有联想字样的商品名称
	29.案例：查询卖点含有'赠'产品名称
	30.案例：查询emp表中员工的编号，姓名，职位，工资，并且工资在1000~2000之间。
	31.案例：查询emp表中员工在10号部门，并且含有上级领导的员工的姓名，职位，上级领导编号以及所属部门的编号
	32.案例：查询emp表中名字中包含'E'，并且职位不是MANAGER的员工的编号，姓名，职位，以及工资。	
	33.案例：查询emp表中10号部门或者20号部门中员工的编号，姓名，所属部门的编号
	34.案例：查询emp表中没有奖金或者名字的倒数第2个字母不是T的员工的编号，姓名，职位以及奖金
	35.案例：查询工资高于3000或者部门编号是30的员工的姓名，职位，工资，入职时间以及所属部门的编号	
	36.案例：查询不是30号部门的员工的所有信息
	37.案例：查询奖金不为空的员工的所有信息
	38.案例：查询emp表中所有员工的编号，姓名，职位，根据员工的编号进行降序排列
	39.案例：查询emp表中部门编号是10号或者30号中，所有员工姓名，职务，工资，根据工资进行升序排列
	40.案例：查询emp表中所有的数据，然后根据部门的编号进行升序排列，如果部门编号一致，根据员工的编号进行降序排列
	41.案例：查询emp表中工资高于1000或者没有上级领导的员工的编号，姓名，工资，所属部门的编号，以及上级领导的编号，根据部门编号进行降序排列，如果部门编号一致根据工资进行升序排列。
	42.案例：查询emp表中名字中不包含S的员工的编号，姓名，工资，奖金，根据工资进行升序排列，如果工资一致，根据编号进行降序排列
	43.案例：统计emp表中员工的总数量
	44.案例：统计emp表中获得奖金的员工的数量
	45.案例：求出emp表中所有的工资累加之和
	46.案例：求出emp表中所有的奖金累加之和
	47.案例：求出emp表中员工的平均工资
	48.案例：求出emp表中员工的平均奖金
	49.案例：求出emp表中员工的最高工资
	50.案例：求出emp表中员工编号的最大值
	51.案例：查询emp表中员工的最低工资。
	52.案例：查询emp表中员工的人数，工资的总和，平均工资，奖金的最大值，奖金的最小值,并且对返回的列起别名。
	53.案例：查询emp表中每个部门的编号，人数，工资总和，最后根据人数进行升序排列，如果人数一致，根据工资总和降序排列。
	54.案例：查询工资在1000~3000之间的员工信息，每个部门的编号，平均工资，最低工资，最高工资，根据平均工资进行升序排列。
	55.案例：查询含有上级领导的员工，每个职业的人数，工资的总和，平均工资，最低工资，最后根据人数进行降序排列，如果人数一致，根据平均工资进行升序排列
	56.案例：查询工资在1000~3000之间每一个员工的编号，姓名，职位，工资
	57.案例：查询emp表中奖金在500~2000之间所有员工的编号，姓名，工资以及奖金
	58.案例：查询员工的编号是7369，7521，	
	59.案例：查询emp表中，职位是ANALYST，
	60.案例：查询emp表中职位不是ANALYST,		
	10. 扩展题（难度最高）：查询平均工资最高的部门信息
- 得到最高的平均工资
	select avg(sal) a from emp group by deptno order by a desc limit 0,1;
- 通过最高的平均工资 得到 部门的编号
	select deptno from emp
	group by deptno
	having avg(sal)=(select avg(sal) a from emp group by deptno order by a desc limit 0,1);
- 通过部门编号得到部门信息
	select * from dept where deptno in(select deptno from emp
	group by deptno
	having avg(sal)=(select avg(sal) a from emp group by deptno order by a desc limit 0,1));	
		
		
		-------------------------------------------------------------------------------------
		
		###视图
- 什么是视图： 数据库中表和视图都是其内部的对象，视图可以理解成一个虚拟的表，视图本质就是取代了一段sql查询语句。
- 为什么使用视图：因为有些数据的查询需要使用大量的sql语句，每次书写比较麻烦，使用视图可以起到sql重用的作用，可以隐藏表中的敏感信息。
- 如何使用：
	
		格式：create view 视图名 as 子查询;
1. 练习1：创建部门是20并且工资小于3000的视图
		
		create view v_emp_20 as (select * from emp where deptno=20 and sal<3000);
2. 练习2：创建每个部门的工资总和，平均工资，最大工资，最小工资的视图
	
		create view v_emp_dept_info as (select deptno,sum(sal), avg(sal), max(sal), min(sal) from emp group by deptno );
####视图的分类
1. 简单视图： 创建视图的子查询中不包含：去重，函数，分组，关联查询的视图称为简单视图，可以对数据进行增删改查操作
2. 复杂视图： 创建视图的子查询中包含：去重，函数，分组，关联查询的视图称为复杂视图，只能进行查的操作
####简单视图的增删改操作 操作方式和table一样
1. 插入数据 如果插入的数据在视图中不显示但是原表中显示，称为数据污染
	insert into v_emp_10 (empno,ename) 
	values(10010,'Tom');
	-正确写法

		insert into v_emp_10 (empno,ename,deptno)
		values(10086,'Jerry',10);
	
	-可以通过with check option 关键字禁止出现数据污染
	
		create view v_emp_30 as (select * from emp where deptno=30) with check option;
	-测试：
		insert into v_emp_30 (empno,ename,deptno) 
		values(10011,'张三',30);
		
		insert into v_emp_30 (empno,ename,deptno) 
		values(10012,'李四',20);
2. 修改数据 只能修改视图中存在的数据

	update v_emp_30 set ename='zhangsan' where empno=10011;(成功)
	update v_emp_30 set ename='汤姆' where empno=10010;（失败）
3. 删除数据 只能删除视图中存在的数据
	
	delete from v_emp_30 where empno=10011;
	delete from v_emp_30 where empno=10010;
###修改视图
- 格式： create or replace view 视图名 as 子查询;

	create or replace view v_emp_10 as(select * from emp);
###删除视图

	drop view v_emp_10;
	drop view if exists v_emp_10; 没有也不会报错

###视图别名
- 创建视图的时候子查询对字段起了别名，则后期对视图进行操作只能使用别名。

	create view v_emp_10 as (select empno,ename name from emp);
- 测试：
	update v_emp_10 set name='汤姆' where empno=10010;(成功)
	update v_emp_10 set ename='汤姆aaa' where empno=10010;（失败）
###视图总结：
1. 视图是数据库中的对象，代表一段sql，可以理解成虚拟表
2. 作用： 重用sql ， 隐藏敏感字段
3. 分类： 简单 和 复杂  简单（不包含去重 函数 分组 关联查询） 复杂反之只能查看
4. 插入数据时可能数据污染 通过with check option解决
5. 修改和删除只能操作视图中存在的数据
6. 起了别名 只能用别名
###约束
- 什么是约束：约束是给表字段添加的限制条件
####非空约束 not null
- 字段值不能为null	
	
	create table t1(id int,age int not null);
- 测试：
	insert into t1 values(1,20);（成功）
	insert into t1 values(2,null);(失败)
####唯一约束 unique
- 字段值不能重复
	create table t2(id int,age int unique);
- 测试：
	insert into t2 values(1,20);（成功）
	insert into t2 values(2,20); (失败)
####主键约束 primary key
- 字段值不能重复也不能为null
- 创建表的时候添加主键
	create table t_pri(id int primary key auto_increment); 
- 创建表后添加主键
	create table t_pri2(id int);

	alter table t_pri2 add primary key (id);
- 删除主键  一个表只能有一个主键
	alter table t_pri2 drop primary key;
###自增
1. 当字段的值为null的时候数值自动+1
2. 删除数据数值不减
3. 如果插入数据指定比较大的值，下次从最大值基础上+1，如果删除最大值，也是从曾经出现的最大值基础上+1
4. 使用delete删除全表数据 自增值不变
5. 使用truncate删除 自增数值清零
###默认约束 default
- 当字段的值不赋值的时候 默认约束的内容生效
	create table t_def(id int, age int default 10);
###检查约束 check
- mysql语法支持 不报错 但是没有效果
	
		create table t_check(id int,age int check(age>10));

###外键约束
- 作用：
1. 外键值可以为null，可以重复，但是不能是不存在的值
2. 外键指向的表，不能先删除
3. 外键指向的数据不能先删除，如果需要删除，先删除外键约束或先删除外键的数据（断开关联关系）

- 使用外键必须要求两张表相同的InnoDB引擎，myisam不支持外键约束

- 除非特定情况 一般工作中不使用外键约束，使用java代码通过逻辑对插入和删除的数据进行限制，因为加了外键约束后不方便测试

#####如何使用外键约束
1. 创建部门表
	create table dept(id int primary key auto_increment,name varchar(10));
2. 创建员工表
	create table emp(id int primary key auto_increment,name varchar(10),deptid int,constraint fk_dept foreign key(deptid) references dept(id));
- 内容介绍
	constraint 外键约束名 foreign key(外键字段) references 表名(主键)
- 插入数据
	insert into dept values(null,'神仙'),(null,'妖怪');
	- 测试：
	insert into emp values(null,'悟空',1);(成功)
	insert into emp values(null,'赛亚人',3);（失败）
	drop table dept;(失败)
	delete from dept where id=1;(失败)
	
---------------------------------------------------------------------------------------------
###索引
####导入数据
在db6数据库下 执行source命令
- 学生机（linux）
	source /home/soft01/桌面/item_backup.sql;
- 个人电脑（windows）
	source d:/item_backup.sql;

测试：
1. show tables;  看是否有item2的表
2. select count(*) from item2;  看是否有172万
3. select * from item2 where title='100'; 看查询时间是多少    1.15秒 

- 什么是索引： 索引是数据库中用来提高查询效率的技术，类似于目录
- 为什么使用索引： 如果不使用索引数据会零散的保存在磁盘块中，查询数据需要挨个的遍历每一个磁盘块，直到找到数据为止，使用用索引后会在磁盘中以树状结构对数据进行保存，查询数据时会大大降低磁盘块的访问量，从而提高查询效率。
- 索引原理图（了解）

####索引是越多越好吗？
索引会占用磁盘空间，只对常用的查询字段创建索引
####有索引就一定好吗？
不一定，如果数据量比较小，使用索引反而会降低查询效率
####索引的分类
1. 聚集索引：一张表只有一个聚集索引，数据库会自动为添加了主键的表创建聚集索引，一般情况下聚集索引就是通过主键值创建的索引，聚集索引的树状结构中保存了数据

2. 非聚集索引：一张表可以有多个非聚集索引，通过非主键字段创建的索引称为非聚集索引，非聚集索引中没有数据保存的是磁盘块的地址。
###如何创建索引
- 格式： create index 索引名 on 表名(字段名(长度));
- 创建title索引 

	create index index_item2_title on item2(title);
-测试：之前的时间1.1秒  添加索引后0.03 提高30多倍 
	select * from item2 where title='100';

####查看索引
	
	show index from item2;
####删除索引
	
	drop index index_item2_title on item2;

####复合索引
- 通过多个字段创建的索引称为复合索引
- 应用场景：频繁使用多个字段作为查询条件时，可以为这个几个字段创建一个复合索引
- 创建格式: create index index_item2_title_price on item2(title,price);

####索引总结
1. 索引是用来提高查询效率的技术，类似目录的作用
2. 因为会占空间不是越多越好
3. 数据量小时 会降低查询效率
4. 聚集索引自动通过主键创建 保存数据 只有一个 和非聚集索引 有多个 没有数据只有磁盘块地址
5. 尽量不要在频繁修改的表上创建索引
		
------------------------------------------------------------------------------------------		

1. possible_keys：显示可能应用在这张表中的索引，一个或多个。查询涉及到的字段上若存在索引，
	则该索引奖杯列出，但不一定被查询实际使用。
2. key：实际使用的索引，若为null，则没有使用到索引。
	（两种可能，①没建立索引。②建立索引，但索引失效）。
	查询中若使用了覆盖索引，则该索引仅出现在key列表中。
3. key_len：表示索引中使用的字节数，可通过该列计算查询中使用的索引的长度。
	在不损失精确型的情况下，长度越短越好，key_len显示的值为索引字段的最大可能长度，
	并非实际使用长度，即key_len是根据定义计算而得，不是通过表内检索出的。


	
	
