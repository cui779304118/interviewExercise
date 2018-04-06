package com.cuiwei.dataStructure.list;

public class MyQueue<E>{
	
	private int theSize;
	private int front;
	private int back;
	
	private E[] theQueue;
	private final static int SIZE = 10;
	
	public MyQueue(){
		doClear();
	}
	
	public void clear(){
		doClear();
	}
	
	public void doClear(){
		front=0;
		back=0;
		theSize=0;
		expand(SIZE);
	}
	
	private void expand(int size){
		if(size<SIZE){
			return;
		}
		E[] oldQueue=theQueue;
		theQueue=(E []) new Object[size];
		for(int i=0;i<size();i++){
			theQueue[i]=oldQueue[i];
		}
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public void enqueue(E e){
		if(size()==SIZE){
			expand(SIZE*2+1);
		}
		theQueue[back++]=e;
		theSize++;
	}
	
	public E dequeue(){
		if(isEmpty()){
			System.out.println("the queue is empty!");
			return null;
		}
		theSize--;
		return theQueue[front++];	
	}
	

}
