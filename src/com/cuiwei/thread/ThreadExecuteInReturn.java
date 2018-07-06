package com.cuiwei.thread;

public class ThreadExecuteInReturn extends Thread {

	private Object lock;
	private String showChar;
	private int showPosition;
	private int printCount;
	volatile private static int addNumbers = 1;
	volatile private static int showNumbers = 3;
	
	public ThreadExecuteInReturn(Object lock, String showChar, int showPosition ){
		this.lock = lock;
		this.showChar = showChar;
		this.showPosition = showPosition;
	}
	
	public static void setAddNumbers(int numbers){
		addNumbers = numbers;
	}
	
	public static int getAddNumbers(){
		return addNumbers;
	}
	
	public void run(){
		try {
			synchronized (lock) {
			while(true){
					if(addNumbers % showNumbers == showPosition){
						System.out.println("ThreadName=" + Thread.currentThread().getName() + 
								" runCount=" + addNumbers + " " +showChar);
						lock.notifyAll();
						addNumbers ++ ;
						printCount++;
						if(printCount == showNumbers){
							break;
						}
					}else{
						lock.wait();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
