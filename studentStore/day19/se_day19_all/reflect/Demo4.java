package reflect;

import java.lang.reflect.Method;

/**
 * 调用含有参数的方法
 * @author adminitartor
 *
 */
public class Demo4 {
	public static void main(String[] args)throws Exception {
		Person p = new Person();
		p.sayHello("传奇",23);
		
		
		//1加载Person
		Class cls = Class.forName("reflect.Person");
		
		//2实例化
		Object o = cls.newInstance();
		
		//3获取sayHello(String name,int age)
		Method method = cls.getDeclaredMethod(
			"sayHello", 
			new Class[]{String.class,int.class}
		);
		
		//4 p.sayHello("传奇",23);
		method.invoke(o, new Object[]{"传奇",23});
		
		
		
	}
}






