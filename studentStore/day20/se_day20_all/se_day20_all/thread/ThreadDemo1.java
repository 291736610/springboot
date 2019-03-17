package thread;
/**
 * 线程能允许我们"同时执行"多段代码。
 * 线程有两种创建方式
 * 1:继承Thread并重写run方法，在run方法中定义线程
 *   要执行的任务
 * @author adminitartor
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {		
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 线程启动要调用start，而不是直接调用run
		 * 方法。
		 * start方法的作用是将线程纳入线程调度中，
		 * 线程调度会统一管理需要并发运行的多个线程，
		 * 调度CPU，分配时间片段给线程，得到时间片段
		 * 的线程会被CPU运行这段时间，运行完毕后，线程
		 * 调度会再分配时间片段给一个线程使CPU运行该线
		 * 程。
		 * 线程调度分配时间片段给每个线程并非有序的"一人一次"
		 * 但是在整体过程中，每个线程获取的CPU时间片段的次数
		 * 是基本一致的。
		 */
		t1.start();
		t2.start();
	}
}

/**
 * 第一种创建线程方式存在两种不足:
 * 1:由于java是单继承的，这就导致在实际开发中我们
 *   往往需要继承某个类复用方法，而当前类又需要并发
 *   运行，导致不能同时又继承复用方法的类又继承线程
 *   
 * 2:定义线程的同时重写run方法定义任务，这就导致了
 *   线程和任务有一个必然的耦合关系。不利于线程的
 *   重用。  
 *   
 * @author adminitartor
 *
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的!");
		}
	}
}









