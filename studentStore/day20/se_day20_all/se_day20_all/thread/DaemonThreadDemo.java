package thread;
/**
 * 守护线程
 * 守护线程又称为后台线程，一个线程创建出来默认
 * 都是普通(前台线程)，守护线程需要在线程启动前
 * 单独进行设置。
 * 使用上守护线程与普通线程无差别，但是在结束时机上
 * 有一点不同，即:当进程结束时，所有正在运行的守护
 * 线程都会被强制中断。
 * 进程结束:当一个进程中的所有前台线程都结束时，进程
 *         即结束
 * @author adminitartor
 *
 */
public class DaemonThreadDemo {
	public static void main(String[] args) {
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:啊啊啊啊AAAAAAaaaa....");
				System.out.println("噗通!");
			}
		};
	
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println("jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		rose.start();
		
		//设置为守护线程，必须在start之前调用
		jack.setDaemon(true);
		jack.start();
		
		
	}
}









