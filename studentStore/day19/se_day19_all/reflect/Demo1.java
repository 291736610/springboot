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
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
		Person p = null;
		//实例化的过程
		p = new Person();
		/*
		 * 加载类的过程就是让JVM读取该类对应的class文件
		 * 
		 * 当JVM读取一个类的class文件后，会实例化一个
		 * Class类的实例用于保存加载的这个类的信息。
		 * 并且每个被加载的类只会进行一次加载过程，这
		 * 意味着每个被JVM加载的类都会在JVM内部以一个
		 * Class类的实例进行保存。所以每个类有且只有
		 * 一个Class类的实例与之对应。
		 * Class也称为类对象。每个实例用于表示JVM加载
		 * 的一个类，通过它可以获取其表示的类的相关信息
		 * 比如:类的名字，有哪些属性，构造器，以及所有
		 * 方法。并且通过Class还可以实例化其表示的类。
		 */
		Class cls = Class.forName("reflect.Person");
		/*
		 * Class提供了一个方法：
		 * Object newInstance()
		 * 该方法是调用当前Class所表示的类的无参构造方法
		 * 实例化一个该类实例并将其返回。注意，该类必须有
		 * 无参构造方法才可以使用这个方法。
		 */
		Object obj = cls.newInstance();
		System.out.println(obj);
		
		
		
		
	}
}











