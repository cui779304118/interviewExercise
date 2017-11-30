package com.cuiwei.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class StackWithMin {
	
	ArrayList<Integer> stack=new ArrayList<Integer>();

	public void push(int node) {
        stack.add(node);
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int min() {
        int min=stack.get(0);
        Iterator<Integer> it=stack.iterator();
        while(it.hasNext()){
        	int temp=it.next();
        	if(temp<min){
        		min=temp;
        	}
        }
        return min;
    }

}
