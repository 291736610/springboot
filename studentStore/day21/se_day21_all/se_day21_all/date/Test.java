package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 输入自己的生日，然后经过程序计算，输出到今天为止
 * 一共活了多少天
 * 例如:
 * 1992-08-02
 * 
 * 计算后输出到今天为止共活了xxxx天
 * 
 * 再输出出生10000天的纪念日为哪天?
 * 格式还是:yyyy-MM-dd
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入您的生日:");
		String birthStr = scanner.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd"	
		);
		Date birth = sdf.parse(birthStr);
		Date now = new Date();
		
		long time = now.getTime()-birth.getTime();
		//换算成天
		time = time/1000/60/60/24;
		System.out.println("恭喜您！一共活了"+time+"天，请继续保持!");
		
		//计算10000天纪念日
		time = birth.getTime()+1000L*60*60*24*10000;
		Date date = new Date(time);
		
		String str = sdf.format(date);
		System.out.println("您出生10000天的纪念日为:"+str);
	}
}








