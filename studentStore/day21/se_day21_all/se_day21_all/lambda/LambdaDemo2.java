package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 重写有参数的抽象方法
 * @author adminitartor
 *
 */
public class LambdaDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("苍老师");
		list.add("传奇");
		list.add("小泽老师");		
		Collections.sort(list,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}		
		});
		System.out.println(list);
		
		/*
		 *	编译器会结合上下文分析参数类型，若不能确定
		 *  时编译器会要求指定参数类型。
		 *  若可以省略{}时，方法若需要返回值，那么return
		 *  关键字也需要一同省略。
		 */
		Collections.sort(list,
			(o1,o2)->o1.length()-o2.length()
		);
		
	}
}






