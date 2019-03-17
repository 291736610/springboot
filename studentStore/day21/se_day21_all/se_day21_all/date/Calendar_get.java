package date;

import java.util.Calendar;

/**
 * Calendar提供了一个方法:
 * int get(int field)
 * 该方法可以获取指定的时间分量所对应的值。
 * 
 * 时间分量是一个int值，不同值表示不同时间分量，无需
 * 记忆这些数具体是多少，Calendar提供了对应的常量。
 * @author adminitartor
 *
 */
public class Calendar_get {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		
		//获取年
		int year = calendar.get(Calendar.YEAR);
		
		//获取月  月从0开始
		int month = calendar.get(Calendar.MONTH)+1;
		
		/*
		 * 获取日
		 * 和"天"相关的常量有:
		 * DAY_OF_MONTH:月中的天，就是俗称的"几号"
		 * DAY_OF_WEEK:周中的天，就是指星期几
		 * DAY_OF_YEAR:年中的天。
		 * DATE:与DAY_OF_MONTH意义相同。
		 */
		int date = calendar.get(Calendar.DATE);
		System.out.println(year+"-"+month+"-"+date);

		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		System.out.println(h+":"+m+":"+s);
		/*
		 * 根据当前Calendar表示的日期获取指定时间分量
		 * 所允许的最大值
		 * 今年总共多少天?
		 */
		int days = calendar.getActualMaximum(
			Calendar.DAY_OF_YEAR
		);
		System.out.println("今年共:"+days+"天");
		
	}
}








