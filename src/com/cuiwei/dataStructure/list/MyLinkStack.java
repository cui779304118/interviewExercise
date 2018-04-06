package com.cuiwei.dataStructure.list;

public class MyLinkStack <E>{
	
	int theSize;
	Node<E> top;
	
	
	private static class Node<E>{
		public E e;
		public Node<E> next;
		
		public Node(E e,Node<E> next){
			this.e=e;
			this.next=next;
		}
	}
	
	public MyLinkStack(){
		top=null;
		theSize=0;
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public void push(E e){
		top=new Node(e,top);
		theSize++;
	}
	
	public E pop(){
		if(isEmpty()){
			System.out.println("the stack is empty!");
			return null;
		}else{
		Node<E> value=top;
		top=top.next;
		value.next=null;
		theSize--;
		return value.e;
		}
	}
	
	public E peek(){
		if(isEmpty()){
			System.out.println("the stack is empty!");
			return null;
		}else{
			return top.e;
		}
	}

}
