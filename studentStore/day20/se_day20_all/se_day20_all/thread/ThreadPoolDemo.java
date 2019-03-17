package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池主要有两个作用:
 * 1:控制线程数量
 *   每个线程都会占用进程的一部分内存，线程数量过多
 *   会导致资源消耗大，由于所有线程都是并发运行，那
 *   么过多的线程也会导致CPU过度切换，导致并发效率
 *   变差。
 * 2:重用线程
 *   频繁的创建销毁线程会给线程调度带来负担，所以也
 *   应当重用线程。  
 * 
 * 
 * @author adminitartor
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		//固定大小线程池
		ExecutorService threadPool 
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable r = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					try {
						System.out.println(
							t.getName()+":正在运行任务...");
						Thread.sleep(5000);
						System.out.println(
							t.getName()+":运行任务完毕!");
					} catch (Exception e) {
					}
				}
			};
			//将任务指派给线程池
			threadPool.execute(r);
			System.out.println("将任务指派给线程池");
		}
		
		
		threadPool.shutdownNow();
		System.out.println("已停止线程池...");
		
	}
}
















