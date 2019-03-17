package thread;
/**
 * 互斥锁
 * 当使用synchroinzed锁住多段不同的代码片段，但是
 * 这些同步块使用的同步监视器对象是同一个时，那么这些
 * 代码片段之间就是互斥的。多个线程不能同时执行他们。
 * @author adminitartor
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo boo = new Boo();
		Thread t1 = new Thread(){
			public void run(){
				boo.methodA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				boo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在运行A方法...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+":运行A方法完毕!");
	}
	public void methodB(){
		synchronized(this){
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":正在运行B方法...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getName()+":运行B方法完毕!");
		}
	}
}







