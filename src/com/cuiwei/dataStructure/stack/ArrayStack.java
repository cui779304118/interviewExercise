package com.cuiwei.dataStructure.stack;

/**
 * created by cuiwei on 2018/7/20
 * 数组实现stack
 */
public class ArrayStack<E> {
    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 10;
    private E[] arrs;
    private int top;
    private int cap;


    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int cap) {
        if (cap < 0) {
            return;
        }
        if (cap > MAX_CAPACITY) {
            this.cap = MAX_CAPACITY;
        }
        this.cap = cap;
        expand();
    }

    private void expand() {
        if (top == 0) {
            this.arrs = (E[]) new Object[cap];
        }
        int newCap = cap << 1;
        E[] newArrs = (E[]) new Object[newCap];
        System.arraycopy(arrs, 0, newArrs, 0, top);
        this.cap = newCap;
        arrs = newArrs;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size(){
        return top;
    }

    public boolean push(E e) {
        if (e == null) return false;
        arrs[top++] = e;
        if (top >= arrs.length){
            expand();
        }
        return true;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E val = arrs[--top];
        arrs[top] = null;
        return val;
    }

    public E peek(){
        if (isEmpty()) {
            return null;
        }
        return arrs[top - 1];
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        System.out.println("stack size:" + stack.size());
        for (int i = 0; i < 50; i++) {
            System.out.print(i + " ");
            stack.push(i);
        }
        System.out.println("stack size:" + stack.size());
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("stack size:" + stack.size());
    }
}
