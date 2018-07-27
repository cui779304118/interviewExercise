package com.cuiwei.dataStructure.list;

public class MyArrayStack<E> {
    private int top;
    private E[] theStack;
    private static final int SIZE = 10;

    public MyArrayStack() {
        top = 0;
        this.expand(SIZE);
    }

    public void expand(int size) {
        if (size < top) {
            return;
        }
        E[] oldStack = theStack;
        theStack = (E[]) new Object[size];
        for (int i = 0; i < top; i++) {
            theStack[i] = oldStack[i];
        }
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(E e) {
        if (isEmpty()) {
            this.expand(SIZE);
        }
        if (top == theStack.length) {
            this.expand(SIZE * 2 + 1);
        }

        theStack[top] = e;
        top++;
    }

    public E pop() {

        if (isEmpty()) {
            System.out.println("the stack is empty! ");
            System.exit(1);
        }

        top--;
        E result = theStack[top];
        theStack[top] = null;
        return result;

    }

    public E peek() {
        if (isEmpty()) {
            return null;
        } else {
            return theStack[top - 1];
        }
    }

}
