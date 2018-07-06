package com.cuiwei.collection;

import java.io.File;
import java.io.FileFilter;

public class ReadTask implements Runnable {
	
	ReadAndWriteBlockingQueue queue;
	File root;
	File exitFile;
	
	public ReadTask(ReadAndWriteBlockingQueue queue, File root, File exitFile){
		this.queue = queue;
		this.root = root;
		this.exitFile = exitFile;
	}
	public void run() {
		scanFile(root);
		scanFile(exitFile);
	}
	
	private void scanFile(File file){
		if(file.isDirectory()){
//			File[] files = file.listFiles(new FileFilter() {
//				public boolean accept(File pathname) {
//					return pathname.isDirectory() || pathname.getPath().endsWith(".txt");
//				}
//			});
			File[] files = file.listFiles();
			for(File one : files){
				scanFile(one);
			}
		}else{
			int index = queue.getRc().incrementAndGet();
			System.out.println("read: " + index + " " + file.getPath());
			queue.getQueue().add(file);
		}
	}
}
