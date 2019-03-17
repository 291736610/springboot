package date;

import java.util.Calendar;

/**
 * Calendar提供了一个set方法，可以对指定时间分量
 * 设置对应的值:
 * void set(int field,int value)
 * @author adminitartor
 *
 */
public class Calendar_set {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		
		/*
		 * 设置Calendar为2008-08-08 20:08:08
		 */
		//设置年
		calendar.set(Calendar.YEAR, 2008);
		//设置月
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		//设置日
		calendar.set(Calendar.DAY_OF_MONTH,8);

		calendar.set(Calendar.HOUR_OF_DAY,20);
		calendar.set(Calendar.MINUTE,8);
		calendar.set(Calendar.SECOND,8);
		System.out.println(calendar.getTime());
		
		/*
		 * 设置为周4
		 * 按照西方的标准，一周的第一天为周日
		 */
		calendar.set(Calendar.DAY_OF_WEEK, 5);
		System.out.println(calendar.getTime());
	}
}











