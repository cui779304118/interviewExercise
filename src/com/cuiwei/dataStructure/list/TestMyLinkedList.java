package com.cuiwei.dataStructure.list;

import java.util.Iterator;

import org.junit.Test;

public class TestMyLinkedList {
	
	@Test
	public void test(){
		MyLinkedList<String> list=new MyLinkedList<String>();
//		for(int i=0;i<10;i++)
//			list.add("cuiwei");
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
