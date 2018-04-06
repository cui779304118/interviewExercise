package com.cuiwei.dataStructure.list;

public class MyLoopQueue<E> {
	
	private int theSize;
	private int front;
	private int back;
	private int maxSize;
	
	private E[] theQueue;
	private final static int SIZE = 10;
	
	public MyLoopQueue(int maxSize){
		this.maxSize=maxSize;
		doClear(maxSize);
	}
	
	public void clear(){
		doClear(maxSize);
	}
	
	public void doClear(int maxSize){
		front=0;
		back=0;
		theSize=0;
		theQueue=(E []) new Object[maxSize];
	}
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public void enqueue(E e){
		if(theSize==maxSize){
			System.out.println("the queue is full!");
			return;
		}
//		back++;
//		theSize++;
//		if(back==maxSize){
//			back=0;
//		}
//		theQueue[back]=e;
		theQueue[back]=e;
		back=(back+1)%maxSize;
		theSize++;
	}
	
	public E dequeue(){
		if(isEmpty()){
			System.out.println("the queue is empty!");
			return null;
		}
//		front++;
//		theSize--;
//		if(front==maxSize){
//			front=0;
//		}
//			return theQueue[front];
		E value=theQueue[front];
		theQueue[front]=null;
		front=(front+1)%maxSize;
		theSize--;
		return value;
	}
	
	public E peek(){
		if(isEmpty()){
			System.out.println("the queue is empty!");
			return null;
		}
		return theQueue[front];
	}
	


}
