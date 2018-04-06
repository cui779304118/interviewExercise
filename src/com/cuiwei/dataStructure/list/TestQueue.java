package com.cuiwei.dataStructure.list;

import org.junit.Test;

public class TestQueue {
	@Test
	public void test(){
	LinkedListQueue<Integer> queue=new LinkedListQueue<Integer>();
	
	for(int i=0;i<20;i++){
	  queue.enqueue(i);
	}
	System.out.println("���еĴ�СΪ�� "+queue.size());
	System.out.println("����Ϊ�ն��𣿣� "+queue.isEmpty());
	System.out.println("******************************");
	for(int i=1;i<=15;i++){
		System.out.print(queue.dequeue()+" ");
	}
	System.out.println("\n******************************");
	System.out.println("���еĴ�СΪ�� "+queue.size());
 }
}
