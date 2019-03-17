package date;

import java.util.Date;

/**
 * java.util.Date
 * Date的每一个实例用于表示一个确切的时间。内部维护
 * 一个long值，该值为1970年1月1日 00:00:00到当前
 * Date所表示的时间之间所经过的毫秒。
 * 由于Date设计时存在时区问题，所以大部分操作时间的
 * 方法都被声明为过时的，不再建议使用。
 * @author adminitartor
 *
 */
public class DateDemo{
	public static void main(String[] args) {
		//默认实例化表示当前系统时间
		Date date = new Date();
		System.out.println(date);
		//获取Date内部维护的long值
		long time = date.getTime();
		
		time += 1000*60*60*24;
		//可以设置一个long指使Date表示该日期
		date.setTime(time);
		
		System.out.println(date);
		
	}
}





