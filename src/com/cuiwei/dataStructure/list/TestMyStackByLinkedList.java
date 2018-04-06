package com.cuiwei.dataStructure.list;

import org.junit.Test;

public class TestMyStackByLinkedList {
	
	@Test
	public void test(){
		MyStackByLinkedList<String> stack=new MyStackByLinkedList<String>(); 
		stack.push("cui");
		stack.push("wei");
		stack.push("is");
		stack.push("good");
		
		for(int i=0;i<1;i++){
			System.out.print(stack.peek()+" ");
		}
		
		System.out.println(" ");
		System.out.println("ջ�Ĵ�СΪ�� "+stack.size());
		System.out.println("ջΪ��ջ�𣿣� "+stack.isEmpty());
		System.out.println("ջ��Ԫ��Ϊ�� "+stack.peek());
	}

}
