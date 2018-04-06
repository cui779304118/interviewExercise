package com.cuiwei.dataStructure.list;

import org.junit.Test;

public class TestLoopQueue {
	@Test
	public void test(){
	MyLoopQueue<Integer> queue=new MyLoopQueue<Integer>(5);
	
	for(int i=1;i<=10;i++){
	  queue.enqueue(i);
	}
	System.out.println("���еĴ�СΪ�� "+queue.size());
	System.out.println("����Ϊ�ն��𣿣� "+queue.isEmpty());
	System.out.println("******************************");
	for(int i=1;i<=5;i++){
		System.out.print(queue.dequeue()+" ");
	}
	System.out.println("\n******************************");
	System.out.println("���еĴ�СΪ�� "+queue.size());
	for(int i=11;i<=13;i++){
		  queue.enqueue(i);
		}
	System.out.println("���еĴ�СΪ�� "+queue.size());
	System.out.println("����Ϊ�ն��𣿣� "+queue.isEmpty());
	System.out.println("******************************");
	for(int i=1;i<=8;i++){
		System.out.print(queue.peek()+" ");
	}
	
 }
}
