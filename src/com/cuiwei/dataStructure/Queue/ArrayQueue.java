package com.cuiwei.dataStructure.Queue;


import java.util.Arrays;

/**
 * created by cuiwei on 2018/7/20
 * 循环队列
 */
public class ArrayQueue<E> {

    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 30;
    private int cap;//容量
    private int head;//队首
    private int tail;//队尾
    private int size;//队列大小
    private E[] table;//容器

    public ArrayQueue(int cap) {
        if (cap < 0) {
            return;
        }
        if (cap > MAX_CAPACITY) {
            this.cap = MAX_CAPACITY;
        }
        this.cap = cap;
        int tmpCap = 1;
        while (tmpCap < cap) {
            tmpCap = tmpCap << 1;
        }
        this.cap = tmpCap;
        System.out.println(tmpCap);
        expand();
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void expand() {
        if (isEmpty()) {
            this.table = (E[]) new Object[cap];
        } else {
            int p = head;
            int r = table.length - p;//head左边有多少个元素
            int newCap = cap << 1;
            E[] newTable = (E[]) new Object[newCap];
            System.arraycopy(table, p, newTable, 0, r);
            System.arraycopy(table, 0, newTable, r, p);
            cap = newCap;
            table = newTable;
            System.out.println(Arrays.toString(table));
        }
    }

    public boolean offer(E e){
        table[(tail++) & (cap - 1)] = e;
        if (++size >= cap )expand();
        return true;
    }

    public E take(){
        if (isEmpty())return null;
        E e = table[head];
        table[head++] = null;//GC
        size--;
        return e;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        System.out.println("the queue size = " + queue.size());
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        System.out.println("the queue size = " + queue.size());
        for (int i = 0; i < 5; i++) {
            System.out.print(queue.take() + " ");
        }
        System.out.println("the queue size = " + queue.size());
        for (int i = 0; i < 20; i++) {
            queue.offer(i);
        }
        System.out.println("the queue size = " + queue.size());
        for (int i = 0; i < 5 ; i++) {
            System.out.print(queue.take() + " ");
        }
        System.out.println("the queue size = " + queue.size());
    }


}
