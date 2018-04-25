package com.cuiwei.thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatThreadProblem extends Thread {
	String pattern;
	private DateFormat dateFormat;
	private String dateString;
	public SimpleDateFormatThreadProblem(String pattern, String dateString){
		this.pattern = pattern;
		this.dateString = dateString;
	}
	public void run(){
		dateFormat = new SimpleDateFormat(pattern);
		System.out.println(1/0);
		try {
			Date dateParse = dateFormat.parse(dateString);
			String dateParseString = dateFormat.format(dateParse).toString();
			if(!dateParseString.equals(dateString)){
				System.out.println("ThreadName=" + this.getName() + ""
						+ "解析错误 日期字符串： " + dateString + " 转换成的日期为： " + dateParseString);
			}else{
				System.out.println("解析正确！");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
