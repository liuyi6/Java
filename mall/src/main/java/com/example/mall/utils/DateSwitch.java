package com.example.mall.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSwitch {
	
	private DateSwitch() {
	}
	
	/**
	 * 获取当天时间 年-月-日，不要小时
	 * @return
	 * @throws ParseException
	 */
	public static Date getTodayDate() throws ParseException {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = simpleDateFormat.format(date);
		return simpleDateFormat.parse(today);
	}
	
	public static Date getYesterDate() throws ParseException {
		Date date = getTodayDate();
		return new Date(date.getTime() - 24 * 60 * 60 * 1000L);
	}
	
	public static Date[] timeConversion(String selectWay,String date) throws ParseException {
		Date start = null;
		Date end = null;
		Long oneDay = 24 * 60 * 60 * 1000L;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		start = simpleDateFormat.parse(date);
		if (selectWay.equals("day")) {
			end = new Date(start.getTime() + oneDay);
		}else if (selectWay.equals("week")) {
			end = new Date(start.getTime() + 7*oneDay);
		}else if (selectWay.equals("month")) {
			end = new Date(start.getTime() + 30*oneDay);
		}else { // 匹配year
			end = new Date(start.getTime() + 365*oneDay);
		}
		Date[] dates = new Date[2];
		dates[0] = start;
		dates[1] = end;
		return dates;
	}
}
