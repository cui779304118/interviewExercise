package com.cuiwei.collection;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		ReadAndWriteBlockingQueue queue = new ReadAndWriteBlockingQueue();
		ThreadPoolExecutor exe = new ThreadPoolExecutor(5, 8, 2, TimeUnit.MINUTES,new LinkedBlockingQueue<Runnable>());
		File root = new File("F:\\C语言");
		File exitFile = new File("");
		ReadTask readTask = new ReadTask(queue, root, exitFile);
		exe.submit(readTask);
		
		for(int i=0;i<4;i++){
			WriteTask writeTask = new WriteTask(queue, exitFile, "写线程" + (i+1));
			exe.submit(writeTask);
		}
		exe.shutdown();
	}
}
