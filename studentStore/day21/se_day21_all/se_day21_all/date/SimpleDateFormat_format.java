package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * SDF可以根据给定的日期格式将字符串与Date之间相互
 * 转换。
 * @author adminitartor
 *
 */
public class SimpleDateFormat_format {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);		
		/*
		 * 2018-05-25 10:23:55
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat sdf 
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"
			);
		/*
		 * String format(Date date)
		 * 将给定的Date按照当前SDF指定的日期格式
		 * 转换为对应内容的字符串
		 */
		String str = sdf.format(date);
		System.out.println(str);
	}
}









