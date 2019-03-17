package thread;
/**
 * join方法可以协调线程之间的同步运行。
 * join方法会让运行该方法的线程处于阻塞状态，直到
 * 该方法所属线程运行完毕才会解除阻塞。
 * @author adminitartor
 *
 */
public class JoinDemo {
	//图片是否下载完毕的状态
	private static boolean isFinish = false;
	
	public static void main(String[] args) {
		final Thread down = new Thread(){
			public void run(){
				System.out.println("down:开始下载图片...");
				for(int i=1;i<=100;i++){
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:下载完毕!");
				isFinish = true;
			}
		};
		
		Thread show = new Thread(){
			public void run(){
				System.out.println("show:开始显示图片...");
				
				//先等待下载线程将图片下完再加载
				try {
					//将show线程阻塞，直到down将任务执行完毕
					down.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(!isFinish){
					throw new RuntimeException("图片加载失败!");
				}
				System.out.println("show:图片显示完毕!");
			}
		};
		
		down.start();
		show.start();
	}
}








