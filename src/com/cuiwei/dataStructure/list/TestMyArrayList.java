package com.cuiwei.dataStructure.list;

import java.util.Iterator;

import org.junit.Test;

public class TestMyArrayList {

	@Test
	public void test() {
		// TODO Auto-generated method stub
		MyArrayList<String> ma=new MyArrayList<String>();
		ma.add("I");
		ma.add("love");
		ma.add("you");
		ma.add("China");
		ma.add("cui");
		
		Iterator<String> it=ma.iterator();
		while(it.hasNext()){
			String nextString=it.next();
			if(nextString.equals("love")){
				it.remove();
				continue;
			}
			System.out.println(nextString);
		}

	}
}
