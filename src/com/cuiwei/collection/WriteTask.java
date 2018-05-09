package com.cuiwei.collection;

import java.io.File;

public class WriteTask implements Runnable {

	ReadAndWriteBlockingQueue queue;
	File exitFile;
	String name;
	
	public WriteTask(ReadAndWriteBlockingQueue queue, File exitFile, String name){
		this.queue = queue;
		this.exitFile = exitFile;
		this.name = name;
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(randomTime());
				int index = queue.getWc().incrementAndGet();
				File file = queue.getQueue().take();
				if(file == exitFile){
					queue.getQueue().put(file);
					break;
				}
				System.out.println(name + ":" + index + " " + file.getPath());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
	public long randomTime(){
		return (long)(Math.random()*1000);
	}

}
