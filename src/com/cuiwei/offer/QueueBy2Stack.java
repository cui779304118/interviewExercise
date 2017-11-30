package com.cuiwei.offer;

import java.util.Stack;

import org.junit.Test;

public class QueueBy2Stack {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    @Test
    public void test(){
    	for(int i=1;i<=10;i++){
    		push(i);
    	}
    	for(int i=1;i<=10;i++){
    		System.out.print(pop()+" ");
    	}
    	
    }
    public void push(int node){
    	stack1.push(node); 	
    }
    
    public int pop(){
    	if(stack1.isEmpty()&&stack2.isEmpty()){
    		throw new RuntimeException("Queue is empty!");
    	}
        while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
        int first=stack2.pop();
        while(!stack2.isEmpty()){
        	stack1.push(stack2.pop());
        }
 
    	return first;
    	
    }

}
