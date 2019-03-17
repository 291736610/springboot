package lambda;
/**
 * JDK8之后推出了一个新的特性:lambda表达式
 * 使用lambda可以快速简单的创建仅含有一个抽象方法
 * 的接口或抽象类的子类实例(替代匿名内部类创建)。
 * 
 * lambda语法:
 * ([参数列表])->{方法体}
 * 
 * @author adminitartor
 *
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("hello");
			}
		};
		/*
		 * lambda是编译器认可的，最终会改为内部类形式创建
		 * 并且编译器会结合源代码上下文自动分析要匿名创建的
		 * 类型。由于要求该接口只能有一个方法，所以方法不存
		 * 在争议。
		 */
		Runnable r2 = ()->{
			System.out.println("hello");
		};
		/*
		 * 当重写的方法中只有一句代码时，lambda
		 * 可以忽略{}
		 */
		Runnable r3 = ()->System.out.println("hello");
		
	}
}











