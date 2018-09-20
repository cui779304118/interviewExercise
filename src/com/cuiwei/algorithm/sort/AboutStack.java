package com.cuiwei.algorithm.sort;

import java.util.Stack;

/**
 * created by cuiwei on 2018/8/13
 */
public class AboutStack {

    //模拟堆栈操作：将原数列依次压栈，栈顶元素与所给出栈队列相比，如果相同则出栈，
    //如果不同则继续压栈，直到原数列中所有数字压栈完毕。
    //检测栈中是否为空，若空，说明出栈队列可由原数列进行栈操作得到。否则，说明出栈队列不能由原数列进行栈操作得到。
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null
                || pushA.length != popA.length) return false;
        int len = pushA.length;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty() && (stack.peek() == popA[index])){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }


}
