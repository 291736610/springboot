package reflect;

import java.util.Scanner;

/**
 * java反射机制
 * 反射机制允许我们对一个类的加载，实例化，调用方法,
 * 操作属性从编码期改为在运行期进行。这大大的提高了
 * 代码的灵活度。
 * 但是运行期进行反射操作会消耗额外的资源与性能。所以
 * 要适度使用。
 * 
 * @author adminitartor
 *
 */
public class Demo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * JVM加载一个类有以下几种方式:
		 * 1:执行代码时，发现需要用到某个类时
		 *   如:Person p = new Person()
		 *   这时候JVM会加载Person.class
		 *   
		 * 2:通过反射机制中的:
		 *   Class.forName(String className)
		 *   方法以字符串形式告知JVM加载指定的类
		 *   此方法只能寻找环境变量中配置的类路径
		 *   中指定的类
		 * 
		 * 3:通过类加载器ClassLoader来加载指定的类
		 *   类加载器可以额外指定环境变量中没有指定
		 *   的类路径，并从中寻找指定的类进行加载。
		 *   
		 * 除第一种方式外，剩下两种都是基于反射机制
		 * 动态加载一个类。
		 * 
		 */
		//JVM首先会加载Person.class文件
//		Person p = new Person();
		
		Scanner scanner = new Scanner(System.in);
		String cn = scanner.nextLine();
		Class cls = Class.forName(cn);
	}
}











