package date;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar 日历类
 * Calendar是一个抽象类，规定了操作日期的相关方法。
 * 由于不同的日期历法对日期的计算不同，需要靠不同的
 * 子类去实现这些方法。
 * 常用的实现类:java.util.GregorianCalendar，即
 * 阳历
 * 
 * Calendar提供了一个静态方法:getInstance()可以获
 * 取一个当前系统所在地区适用的实现类，大部分获取的
 * 都是阳历实现类。
 * 
 * 
 * @author adminitartor
 *
 */
public class CalendarDemo1 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * toString可读性差
		 */
		System.out.println(calendar);
		/*
		 * Calendar提供了一个可以转换为Date的方法:
		 * Date getTime()
		 * 将当前Calendar表示的时间以Date形式返回。
		 * 
		 * 
		 * 也提供了一个可以让Calendar表示指定日期的
		 * 方法:
		 * void setTime(Date date)
		 * 是当前Calendar表示给定的Date所表示的日期
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
	}
}









