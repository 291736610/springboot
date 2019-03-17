package thread;
/**
 * 有效的缩小同步范围可以在保证并发安全的前提下尽可
 * 能提高并发效率。
 * 
 * 同步块可以更准确的控制需要同步运行的代码片段。
 * synchronized(同步监视器){
 * 	  需要同步运行的代码片段
 * }
 * 
 * 同步监视器是java中任意的一个对象，只要保证多个
 * 线程看到的该对象是"同一个"，即可保证同步块中的
 * 代码是并发安全的。
 * 
 * @author adminitartor
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
//	public synchronized void buy(){
	public void buy(){
		Thread t = Thread.currentThread();
		try {
			System.out.println(
					t.getName()+":正在挑衣服...");
			Thread.sleep(5000);			
			synchronized (this) {
				System.out.println(
						t.getName()+":正在试衣服...");
				Thread.sleep(5000);	
			}		
			System.out.println(
					t.getName()+":结账离开.");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
















