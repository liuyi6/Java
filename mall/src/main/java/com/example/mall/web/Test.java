package com.example.mall.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) throws ParseException {
		/*
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date);
		System.out.println(simpleDateFormat.format(date));
		String today = simpleDateFormat.format(date);
		System.out.println(simpleDateFormat.parse(today));
		
		List<Integer> l1 = new ArrayList<>();
		l1.add(2);
		l1.add(3);
		
		List<String> l2 = new ArrayList<>();
		l2.add("hello world");
		l2.add("haha");
		
		List<Object> l3 = new ArrayList<>();
		l3.addAll(l1);
		l3.addAll(l2);
		
		System.out.println(l3);
		*/
		String date = "2018-01-02";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = simpleDateFormat.parse(date);
		Date date3 = new Date(date2.getTime() + 24*60*60*1000);
		System.out.println(date2);
		System.out.println(date3);
	}
}
