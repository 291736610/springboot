package reflect;

import java.lang.reflect.Method;
/**
 * 反射可以调用一个类的私有成员
 * @author adminitartor
 *
 */
public class Demo5 {
	public static void main(String[] args) throws Exception, IllegalAccessException {
//		Person p = new Person();
//		p.dosome(); //编译错误，私有方法不可见
		
		Class cls = Class.forName("reflect.Person");
		Object o = cls.newInstance();
		
		Method method = 
			cls.getDeclaredMethod("dosome", null);
		System.out.println("以获取私有方法dosome");
		
		//若要调用私有方法，需要设置访问权限
		method.setAccessible(true);
		method.invoke(o, null);
		
		
		
		
	}
}
