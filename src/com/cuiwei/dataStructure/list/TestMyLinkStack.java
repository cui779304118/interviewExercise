package com.cuiwei.dataStructure.list;

import org.junit.Test;

public class TestMyLinkStack {
	
	  @Test
	public void test(){
		MyLinkStack<String> stack=new MyLinkStack<String>(); 
		stack.push("cui");
		stack.push("wei");
		stack.push("is");
		stack.push("good");
		
		for(int i=0;i<3;i++){
			System.out.print(stack.pop()+" ");
		}
		
		System.out.println(" ");
		System.out.println("ջ�Ĵ�СΪ�� "+stack.size());
		System.out.println("ջΪ��ջ�𣿣� "+stack.isEmpty());
		System.out.println("ջ��Ԫ��Ϊ�� "+stack.peek());
	}
}
