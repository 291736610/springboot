package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 利用反射机制调用某个类实例的方法
 * @author adminitartor
 *
 */
public class Demo3 {
	public static void main(String[] args)throws Exception {
		//1 实例化
		Person p = new Person();
		//2 调用该对象的方法
		p.sayHello();
		
		
		Class cls = Class.forName("reflect.Person");
		Object o = cls.newInstance();
		//获取Person类的sayHello()方法
		/*
		 * Class提供了获取其表示的类相关信息的一组方法，
		 * 其中:
		 * Method getDeclaredMethod(String name,Class[] args)
		 * 是获取当前Class所表示的类定义的指定名字及参数列表
		 * 的方法。
		 * 
		 * Method是反射API中一个重要的类。
		 * 其每一个实例用于表示某个类的一个具体方法。
		 * 通过Method可以获取到其表示的方法的相关信息，如：
		 * 方法名，返回值类型，参数类型，访问修饰符等。
		 * 并且也可以通过Method动态调用其表示的方法。
		 */
		Method method = cls.getDeclaredMethod("sayHello", null);
		/*
		 * Method的invoke方法是用来调用当前Method所
		 * 表示的方法。
		 * 参数1:由于成员方法所属对象，那么调用Method
		 *       所表示的方法时要传入该方法所属对象
		 * 参数2:实际参数，若该方法无参，则传入null即可
		 * 
		 * 即：
		 * 若method表示的是Person类的方法sayHello
		 * 那么
		 * method.invoke(o,null);
		 * 等同于
		 * o.sayHello();      
		 *       
		 */
		method.invoke(o, null);
		
		
	}
}









