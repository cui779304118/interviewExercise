package com.cuiwei.algorithm.test;

import java.util.Stack;

/**
 * created by cuiwei on 2018/8/10
 */
public class StackQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop(){
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        for (int i = 0; i < 5 ; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.pop());
        }
    }


}
