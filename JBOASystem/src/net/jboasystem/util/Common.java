package net.jboasystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用操作
 * @author CXJ
 *
 */
public final class Common {
	/**
	 * 将字符串转换为数字
	 * @param num
	 * @return
	 */
	public static int parseInt(String num){
		try {
			return Integer.parseInt(num);
		} catch (Exception e) {
			System.err.println("将【"+num+"】转换为数字错误："+e.getMessage());
			return 0;
		}
	}
	/**
	 * 将对象转换为String类型
	 * @param obj
	 * @return
	 */
	public static String parseString(Object obj){
		if(obj==null)
			return "";
		
		return obj.toString();
	}
	
	/**
	 * 将字符串转化为Date类型
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date now=null;
		try {
			now=sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("将【"+date+"】转换为日期格式错误："+e.getMessage());
		}
		return now;
	}
	/**
	 * 将Date类型转换为String类型
	 * @param date
	 * @return
	 */
	public static String parseStringFromDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			System.out.println("将["+date+"]转换为String错误："+e.getMessage());
		}
		return "";
	}
}
