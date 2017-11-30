package com.cuiwei.offer;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class IsPopOrder {
	
	@Test
	public void test(){
		int [] pushA={1,2,3,4,5};
		int [] popA={4,5,3,1,2};
		System.out.println("popA是否是PushA的弹出序列？"+isPopOrder(pushA, popA));
	}
	
	public boolean isPopOrder(int [] pushA,int [] popA){
		Stack<Integer> stack=new Stack<Integer>();
		int j=0;
		for(int i=0;i<pushA.length;i++){
			if(pushA[i]!=popA[j]){
				stack.push(pushA[i]);
			}else{
				j++;
			}
		}
		for(int i=j;i<popA.length;i++){
			if(popA[i]!=stack.pop()){
				return false;
			}
		}
		return true;
	}
	
	 public boolean isPopOrder2(int [] pushA,int [] popA) {
	      ArrayList<Integer> stack=new ArrayList<Integer>();
			int j=0;
	        int i;
			for(i=0;i<pushA.length;i++){
				if(pushA[i]!=popA[j]){
					stack.add(pushA[i]);
				}else{
					j++;
				}
			}
			for(int k=j;k<popA.length;k++){
				if(popA[k]!=stack.get(i--)){
					return false;
				}
			}
			return true;
	    }

}
