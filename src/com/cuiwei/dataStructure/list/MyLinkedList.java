package com.cuiwei.dataStructure.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	private int theSize;
	private int modCount=0;//��������Ĵ���
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	//Ƕ����,���ܷ����ⲿ�������,����staticȥ��,�����ڲ��࣬���Է����ⲿ���е��������ԡ�
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		
		public Node(AnyType d,Node<AnyType> p,Node<AnyType> n){
			this.data=d;
			this.prev=p;
			this.next=n;
		}
	}
	
	public MyLinkedList(){
		this.doClear();
	}
	
	public void clear(){
		this.doClear();
	}
	
	public void doClear(){
		theSize=0;
		beginMarker=new Node<AnyType>(null,null,endMarker);
		endMarker=new Node<AnyType>(null,beginMarker,null);
		
		modCount++;
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return theSize==0;
	}
	
	public boolean add(AnyType x){
		this.add(theSize,x);
		return true;
	}
	
	public void add(int index,AnyType x){
		addBefore(getNode(index,0,size()),x);
	}
	
	private void addBefore(Node<AnyType> p,AnyType x){
		Node<AnyType> newNode=new Node<AnyType>(x,p.prev,p);
		newNode.prev.next=newNode;
		p.prev=newNode;
		
		theSize++;
		modCount++;
		
	}
	
	private AnyType remove(Node<AnyType> p){
		p.prev.next=p.next;
		p.next.prev=p.prev;
		
		theSize--;
		modCount++;
		
		return p.data;
	}
	
	public AnyType remove(int index){
		return remove(getNode(index));
	}
	
	public AnyType get(int index){
		
		Node<AnyType> p=getNode(index);
		return p.data;
		
	}
	
	private AnyType set(int index,AnyType newVal){
		Node<AnyType> p=getNode(index);
		AnyType oldVal=p.data;
		p.data=newVal;
		return oldVal;
		
	}
	
	
	
	private Node<AnyType> getNode(int index){
		return getNode(index,0,size()-1);
	}
	
	private Node<AnyType> getNode(int index,int lower,int upper){
		Node<AnyType> p;
		
		if(index<lower||index>upper){
			throw new IndexOutOfBoundsException();
		}
		
		if(index<size()/2){
			p=beginMarker.next;
			for(int i=0;i<index;i++){
				p=p.next;
			}
		}else{
			p=endMarker;
			for(int i=size();i>index;i--){
				p=p.prev;
			}
		}
		return p;
	}

	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<AnyType>{
		private Node<AnyType> current=beginMarker.next;
		private int expectedModCount=modCount;
		private boolean okToRemove=false;
		
		public boolean hasNext(){
			return current!=endMarker;
		}
		
		public AnyType next(){
			if(modCount!=expectedModCount){
				throw new ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			
			AnyType nextItem=current.data;
			current=current.next;
			okToRemove=true;
			return nextItem;
		}
		
		public void remove(){
			
			if(modCount!=expectedModCount){
				throw new ConcurrentModificationException();
			}
			
			if(!okToRemove){
				throw new IllegalStateException();
			}
			
			MyLinkedList.this.remove(current.prev);
			expectedModCount++;
			okToRemove=false;
		}
	}

}
