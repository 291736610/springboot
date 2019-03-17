package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算商品促销日期
 * 促销日计算规则:该商品过期日前两周的周三
 * 
 * 程序启动后，要求用户输入商品的生产日期，格式
 * 为:yyyy-MM-dd
 * 然后再输入保质期的天数
 * 
 * 然后经过计算，输出该商品促销日期，输出的格式
 * 也是:yyyy-MM-dd
 * 
 * 
 * @author adminitartor
 *
 */
public class Test2 {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入生产日期:");
		String dateStr = scanner.nextLine();	
		System.out.println("请输入保质期天数:");
		int days = Integer.parseInt(scanner.nextLine());	
		//得到生产日期的Date
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		Calendar calendar = Calendar.getInstance();
		//让Calendar表示生产日期
		calendar.setTime(date);	
		//计算过期日
		calendar.add(Calendar.DAY_OF_YEAR, days);
		//减去2周
		calendar.add(Calendar.DAY_OF_YEAR, -14);
		//设置为当周的周三
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		
		date = calendar.getTime();
		String str = sdf.format(date);
		System.out.println("促销日为:"+str);
		
	}
}












