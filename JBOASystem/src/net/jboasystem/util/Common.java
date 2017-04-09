package net.jboasystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ͨ�ò���
 * @author CXJ
 *
 */
public final class Common {
	/**
	 * ���ַ���ת��Ϊ����
	 * @param num
	 * @return
	 */
	public static int parseInt(String num){
		try {
			return Integer.parseInt(num);
		} catch (Exception e) {
			System.err.println("����"+num+"��ת��Ϊ���ִ���"+e.getMessage());
			return 0;
		}
	}
	/**
	 * ������ת��ΪString����
	 * @param obj
	 * @return
	 */
	public static String parseString(Object obj){
		if(obj==null)
			return "";
		
		return obj.toString();
	}
	
	/**
	 * ���ַ���ת��ΪDate����
	 * @param date
	 * @return
	 */
	public static Date parseDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date now=null;
		try {
			now=sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("����"+date+"��ת��Ϊ���ڸ�ʽ����"+e.getMessage());
		}
		return now;
	}
	/**
	 * ��Date����ת��ΪString����
	 * @param date
	 * @return
	 */
	public static String parseStringFromDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			System.out.println("��["+date+"]ת��ΪString����"+e.getMessage());
		}
		return "";
	}
}
