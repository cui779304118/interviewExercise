package com.cuiwei.dataStructure.tree;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/9/11
 * 最大堆或者最小堆的实现
 */
public class MaxOrMinHeap<K> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final boolean DEFAULT_MIN_HEAP = false ;

    private K[] elements;
    private int size;
    private int capacity;
    private boolean isMax = false;
    int sign = -1;//用于区别是最大堆还是最小堆

    public MaxOrMinHeap(K[] arr, boolean isMax) {
        this.elements = arr;
        capacity = arr.length;
        size = arr.length;
        this.isMax = isMax;
        sign = isMax ? 1 : -1;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeapDown(arr, arr.length, i);
        }
    }

    public MaxOrMinHeap(){
        this(DEFAULT_CAPACITY,DEFAULT_MIN_HEAP);
    }
    public MaxOrMinHeap(boolean isMax){
        this(DEFAULT_CAPACITY,isMax);
    }
    public MaxOrMinHeap(int capacity,boolean isMax){
        this.capacity = capacity;
        this.isMax = isMax;
        this.sign = isMax ? 1 : -1;
        this.elements = (K[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    //添加一个元素
    public boolean add(K ele) {
        if (size() >= capacity) ensureCapacity();
        elements[size] = ele;
        adjustHeapUp(elements, size);
        size++;
        return true;
    }

    public K poll(){
        if (isEmpty()) return null;
        K ele = elements[0];
        elements[0] = elements[--size];//等于最后一个元素，进行调整
        elements[size] = null;//gc
        adjustHeapDown(elements,size,0);
        return ele;
    }

    public K peek(){
        if (isEmpty()) return null;
        return elements[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public K[] toArray() {
        K[] eles = (K[]) new Object[size];
        System.arraycopy(elements,0,eles,0,size);
        return eles;
    }

    //下沉
    private void adjustHeapDown(K[] arr, int len, int index) {
        K flag = arr[index];
        for (int i = 2 * index + 1; i < len; i = 2 * i + 1) {
            if (i + 1 < len && compare(arr[i + 1], arr[i]) * sign > 0) {
                i++;
            }
            if (compare(arr[i], flag) * sign > 0) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        arr[index] = flag;
    }

    //上浮
    private void adjustHeapUp(K[] arr, int index) {
        K flag = arr[index];
        for (int i = index / 2 - 1; i >= 0; i = (i/2 -1) ) {
            if (compare(arr[i], flag) * sign < 0) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        arr[index] = flag;
    }

    //扩容
    private void ensureCapacity() {
        K[] oldEles = this.elements;
        if (oldEles.length < capacity) return;
        int newCapacity = capacity << 1;//扩充两倍
        K[] newEles = (K[]) new Object[newCapacity];//新建一个数组
        System.arraycopy(oldEles, 0, newEles, 0, capacity);
        capacity = newCapacity;
        elements = newEles;
    }

    final int compare(Object k1, Object k2) {
        return ((Comparable<? super K>) k1).compareTo((K) k2);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 1, 5, 10, 23};
//        MaxOrMinHeap<Integer> heap = new MaxOrMinHeap<>(arr, true);
        MaxOrMinHeap<Integer> heap = new MaxOrMinHeap<>(true);
        heap.add(5);
        heap.add(8);
        heap.add(20);
        heap.add(21);
        heap.add(12);
        heap.add(29);
        System.out.println("size = " + heap.size() + " " + Arrays.toString(heap.toArray()));
        heap.add(50);
        heap.add(100);
        System.out.println("size = " + heap.size() + " " +  Arrays.toString(heap.toArray()));
        System.out.println("peek: " + heap.peek());
        int nums = 8;
        for (int i = 0; i < nums; i++) {
            System.out.println("poll: " + heap.poll());
        }
        System.out.println("size = " + heap.size() + " " +  Arrays.toString(heap.toArray()));
    }


}
