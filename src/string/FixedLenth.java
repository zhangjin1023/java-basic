package string;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 定长字符串
 * @author zhang_jin[zhang_jin@suixingpay.com]
 *
 */
public class FixedLenth {
	public static void main(String[] args) {
		System.out.println("["+formatNumStr("999988800",5) + "]");
		System.out.println("["+formatFloat("22222.000",15) + "]");
		try {
			System.out.println("张锦".getBytes("GBK").length);//中文转换为GBK格式，获取长度为String 的length()的二倍。也就是单个汉字占2字节长度
			System.out.println("aa".getBytes("GBK").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+formatStr("张锦",4)+ "]");
		
		BigDecimal bigDecimal = new BigDecimal("100.999");
		String str = bigDecimal.movePointRight(2).setScale(0,RoundingMode.HALF_EVEN).toString();
		System.out.println(str);
		
	}
	
	/**
	 * 数字类型(整形)，定长域，靠右对齐左边补0
	 * @param numStr
	 * @param length
	 * @return
	 */
	public static String formatNumStr(String numStr,int length){
		String format = String.format(("%" + "0" + String.valueOf(length) + "d"), Long.valueOf(numStr));
		return format;
	}
	
	/**
	 * 数字类型(浮点型,两位小数)，定长域，靠右对齐左边补0
	 * @param numStr
	 * @param length
	 * @return
	 */
	public static String formatFloat(String numStr,int length){
		String format = String.format(("%" + "0" + String.valueOf(length) + ".2f"), Float.valueOf(numStr));
		return format;
	}
	
	/**
	 * 字符串类型，定长域，左对齐右边补空格
	 * @param str
	 * @param length
	 * @return
	 */
	public static String formatStr(String str,int length){
		String format = String.format(("%" + "-" + String.valueOf(length) + "s"), str);
		return format;
	}

}
