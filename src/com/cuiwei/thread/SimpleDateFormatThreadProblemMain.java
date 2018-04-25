package com.cuiwei.thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;

public class SimpleDateFormatThreadProblemMain {

	public static void main(String[] args) {
		String datePattern = "yyyy-MM-dd";
//		SimpleDateFormat sf = new SimpleDateFormat(datePattern);
//		String [] dateStrings = new String[]{"1997-09-29","1994-02-28","1992-01-28","1972-02-26","1991-03-29",
//				"1999-01-29","1987-05-29","1977-02-22","1988-06-16","1993-01-29"};
//		Thread [] threads = new Thread[dateStrings.length];
//		for(int i=0;i<dateStrings.length;i++){
//			threads[i] = new SimpleDateFormatThreadProblem(datePattern, dateStrings[i]);
//		}
//		for(Thread t : threads){
//			t.start();
//		}
		String dateString = "1997_09_09";
		SimpleDateFormatThreadProblem.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("线程 ：" + t.getName() + " 出现了异常： ");
				e.printStackTrace();
			}
		});
		SimpleDateFormatThreadProblem t1 = new SimpleDateFormatThreadProblem(datePattern, dateString);
		t1.start();
		SimpleDateFormatThreadProblem t2 = new SimpleDateFormatThreadProblem(datePattern, dateString);
		t2.start();
	}
}
