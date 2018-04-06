package com.cuiwei.dataStructure.list;

public class MyLinkedQueue <E>{
	
	private int theSize;
	private Node<E> front;
	private Node<E> back;
	
	private static class Node<E>{
		public E e;
		public Node<E> next;

		public Node(E e,Node<E> next){
			this.e=e;
			this.next=next;
		}
	}
	
	public MyLinkedQueue(){
		clear();
	}
	
	public void clear(){
		theSize=0;
		front=back=null;
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public boolean enqueue(E e){
		if(isEmpty()){
			back=front=new Node<E>(e,null);
		}else{
			Node<E> newNode=new Node<E>(e,null);
			back.next=newNode;
			back=newNode;
		}
		theSize++;
		return true;
	}
	
	public E dequeue(){
		if(isEmpty()){
			System.out.println("����Ϊ�գ�");
			return null;
		}
		Node<E> value=front;
		front=front.next;
		value.next=null;
		theSize--;
		return value.e;
	}
	
	public E peek(){
		if(isEmpty()){
			System.out.println("����Ϊ�գ�");
			return null;
		}
		return front.e;
	}
	
	

}
