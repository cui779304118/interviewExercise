package com.cuiwei.dataStructure.list;

import java.util.LinkedList;

public class MyStackByLinkedList<E> {
	
	private int top;
	private LinkedList<E> theStack;
	
	public MyStackByLinkedList(){
		top=0;
		theStack=new LinkedList<E>();
	}
	
	public int size(){
		return top;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public boolean push(E e){
		
		theStack.add(e);
		top++;
		return true;
	}
	
	public E pop(){
		if(isEmpty()){
			System.out.println("the stack is empty! ");
			return null;
		}else{
			top--;
			E e=theStack.get(top);
			theStack.remove(top);
			return e;
		}
	}
	
	public E peek(){
		if(isEmpty()){
			System.out.println("the stack is empty! ");
			return null;
		}else{
			return theStack.get(top-1);
		}
	}

}
