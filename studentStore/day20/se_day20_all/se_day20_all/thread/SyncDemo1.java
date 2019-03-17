package thread;
/**
 * 当多个线程并发操作同一资源时就形成了“抢”的局面，
 * 由于线程切换不确定，可能会导致线程操作该资源时未
 * 按照程序预定的执行顺序执行代码，导致逻辑出现混乱。
 * 严重时可能导致系统瘫痪。
 * @author adminitartor
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();//让出CPU，模拟线程切换
					System.out.println(
						getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();//让出CPU，模拟线程切换
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Table{
	//一个桌子上有20个豆子
	private int beans = 20;
	/*
	 * 当一个方法被synchronized修饰后，那么该方法
	 * 称为同步方法，即:多个线程不能同时在方法内部
	 * 执行，从而解决了并发安全问题。
	 * 
	 * 在方法上使用synchronzied，那么同步监视器
	 * 对象就是当前方法所属对象，即:方法内部看到
	 * 的this
	 */
	public synchronized int getBean(){
		if(beans == 0){
			throw new RuntimeException("没有豆子了!");
		}
		Thread.yield();//让出CPU，模拟线程切换
		return beans--;
	}
}











