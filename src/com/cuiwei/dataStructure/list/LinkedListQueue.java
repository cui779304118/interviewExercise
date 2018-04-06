package com.cuiwei.dataStructure.list;

import java.util.LinkedList;

public class LinkedListQueue<E> {
	
	private LinkedList<E> queue;
	
	public LinkedListQueue(){
		queue=new LinkedList<E>();
	}
	
	public void clear(){
		queue=new LinkedList<E>();
	}
	
	public int size(){
		return queue.size();
	}
	public boolean isEmpty(){
		return size()==0;
	}
	
	public void enqueue(E e){
		queue.add(e);
	}
	
	public E dequeue(){
		return queue.remove(0);
	}
	
	public E peek(){
		return queue.getFirst();
	}
	
	

}
