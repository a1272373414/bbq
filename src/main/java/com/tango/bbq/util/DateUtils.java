package com.tango.bbq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;


public class DateUtils {
	
	public final static String TO_TIMESTAMP ="to_timestamp(?,'yyyy-mm-dd hh24:mi:ss.ff3')";
//	public final static DateFormat dataFormat_SSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//	public final static DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	public final static DateFormat dataFormat_S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	public final static String SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public final static String noS = "yyyy-MM-dd HH:mm:ss";
	public final static String S = "yyyy-MM-dd HH:mm:ss.S";
	
	public static String format(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
    public static Date convert(String str) {
        if (!StringUtils.isEmpty(str)) {
            try {
            	if(str.lastIndexOf('.') < 0){
            		str += ".000";
            	}
            	Date date = new SimpleDateFormat(SSS).parse(str);
//            	Date date = dataFormat_SSS.parse(str);
                return date;
            } catch (ParseException e) {  
            }
        }
        return null;
    }
    public static  String convertTimestampStr(Date date){
		String str="";
		DateFormat df = new SimpleDateFormat(SSS);
		String dateStr=df.format(date);
		str="to_timestamp('"+dateStr +"','yyyy-mm-dd hh24:mi:ss.ff3')";
		return str;
	}
	public  static String convertDate(Date date){
		String str="";
		DateFormat df = new SimpleDateFormat(SSS);
		String dateStr=df.format(date);
		str="to_date('"+dateStr +"','yyyy-MM-dd HH:mm:ss.SSS')";
		return str;
	}
	
	public  static String convertDateToString(Date date){
		
		DateFormat df = new SimpleDateFormat(SSS);
		String dateStr=df.format(date);
		return dateStr;
	}
	public  static String convertDToString(Date date){
		
		DateFormat df = new SimpleDateFormat(noS);
		String dateStr=df.format(date);
		return dateStr;
	}
	
	public  static String dateToString(Date date){
		
		DateFormat df = new SimpleDateFormat(noS);
		String dateStr=df.format(date);
		return dateStr;
	}
	
	 public static String nowAddSecondTime(Date date, int millionSecond){
	        SimpleDateFormat df = new SimpleDateFormat(S);
	        return df.format(new Date(date.getTime() + millionSecond));
	}
	 
//	public static void main(String args[]){
//		
//		String dateStr = "2012-10-16 09:02:50.090";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date d = null;
//		try {
//			d = targetDay(sdf.parse(dateStr), -1);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(DateUtils.convertDToString(d));
//	}
	
	/**
	 * 根据传入日期获取目标日期（天）
	 * @author Huangxiawu
	 * @time 20160322
	 * @param date 原日期
	 * @param day （day小于0则日期往前）
	 * @return
	 */
	public static Date targetDay(Date date, int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
		return calendar.getTime();
	}
	
	/**
	 * 根据传入时间，获取范围内随机产生的时间
	 * @param date 传入时间
	 * @param minHour 时间范围起点
	 * @param maxHour 时间范围终点
	 * @return 范围内的随机时间
	 */
	public static Date getRandomHour(Date date, int minHour, int maxHour){
		if(date == null){
			return null;
		}
		
		Long dateL = date.getTime();
		Long dateMin = dateL + minHour*1000*60*60;
		Long dateMax = dateL + maxHour*1000*60*60;
		
		long result = dateMin + (int)(Math.random() * ((dateMax - dateMin) + 1));
		
//		System.out.println("   max="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(dateMax)));
//		System.out.println("   min="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(dateMin)));
//		System.out.println("target="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(result)));
		
		return new Date(result);
	}	
	
	public static Date getRandomMinut(Date date, int min, int max){
		if(date == null){
			return null;
		}
		
		Long dateL = date.getTime();
		Long dateMin = dateL + min*1000*60;
		Long dateMax = dateL + max*1000*60;
		
		long result = dateMin + (int)(Math.random() * ((dateMax - dateMin) + 1));
		
		return new Date(result);
	}	
	
//	public static void main(String[] args) {
//		Date result = DateUtils.getRandomMinut(new Date(), 1, 2);
//		System.out.println("target="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result));
//	}
	
	public static String dateCompare(Date date) {
		if(date == null) {
			return null;
		}
		
		Date d = new Date();
		if (d.before(date)) {
			return new SimpleDateFormat(noS).format(d) + ".999";
		} 
		return new SimpleDateFormat(SSS).format(date);
	}
	
}
