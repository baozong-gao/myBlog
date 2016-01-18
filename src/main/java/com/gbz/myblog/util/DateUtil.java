package com.gbz.myblog.util;

import java.util.Calendar;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateFormatUtils;

public  class DateUtil {

	public static String getCurrentDate(){
		Calendar date = Calendar.getInstance();
		TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai"); 
		date.setTimeZone(timezone);
		return DateFormatUtils.format(date, "yyyyMMdd");
	}
	
	public static String getCurrentTime(){
		Calendar date = Calendar.getInstance();
		TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai"); 
		date.setTimeZone(timezone);
		return DateFormatUtils.format(date, "HHmmss");
	}
	
}
