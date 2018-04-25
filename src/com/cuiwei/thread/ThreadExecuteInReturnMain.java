package com.cuiwei.thread;

public class ThreadExecuteInReturnMain {

	public static void main(String[] args) {
		Object lock = new Object();
		ThreadExecuteInReturn.setAddNumbers(3);
		ThreadExecuteInReturn t1= new ThreadExecuteInReturn(lock, "I", 1);
		ThreadExecuteInReturn t2= new ThreadExecuteInReturn(lock, "love", 2);
		ThreadExecuteInReturn t3= new ThreadExecuteInReturn(lock, "you", 0);
		ThreadExecuteInReturn t4= new ThreadExecuteInReturn(lock, "very", 4);
		ThreadExecuteInReturn t5= new ThreadExecuteInReturn(lock, "much", 5);
		t1.start();
		t2.start();
		t3.start();
//		t4.start();
//		t5.start();
	}

}
