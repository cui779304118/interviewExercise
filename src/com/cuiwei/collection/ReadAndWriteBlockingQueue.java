package com.cuiwei.collection;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadAndWriteBlockingQueue {
	final BlockingQueue<File> queue = new LinkedBlockingQueue<File>(100);
	final AtomicInteger rc = new AtomicInteger();
	final AtomicInteger wc = new AtomicInteger();
	
	public BlockingQueue<File> getQueue() {
		return queue;
	}
	public AtomicInteger getRc() {
		return rc;
	}
	public AtomicInteger getWc() {
		return wc;
	}
}
