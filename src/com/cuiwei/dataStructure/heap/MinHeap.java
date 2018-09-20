package com.cuiwei.dataStructure.heap;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/8/2
 */
public class MinHeap {
    int[] array;
    int size;

    public MinHeap(int[] items) {
        creatHeapByArr(items);
    }

    public void creatHeapByArr(int[] items) {
        if (items == null) return;
        size = items.length;
        array = new int[(size + 2) * 11 / 10];

        for (int i = 1; i <= size; i++) {
            array[i] = items[i - 1];
        }
        for (int i = size / 2; i > 0; i--) {
            percolateDown(array, size, i);
        }
    }

    public int deleteMin() {
        int min = array[1];
        array[1] = array[size];
        percolateDown(array, size, 1);
        array[size] = 0;
        size--;
        return min;
    }

    public void insert(int val) {
        int cur = ++size;
        for (array[0] = val; val < array[cur / 2]; cur /= 2) {
            array[cur] = array[cur / 2];
        }
        array[cur] = val;
    }

    public void sort(){
        for (int i = size; i > 1 ; i--) {
            swap(array,1,i);
            percolateDown(array,i,1);
        }
    }

    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //下滤
    private void percolateDown(int[] array, int currentSize, int i) {
        int temp = array[i];
        int cur = i;
        int child = cur * 2;
        while (child <= currentSize) {
            if (child != currentSize && array[child + 1] < array[child]) {
                child++;
            }
            if (array[child] < temp) {
                array[cur] = array[child];
            } else {
                break;
            }
            cur = child;
            child = 2 * cur;
        }
        array[cur] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 12, 23, 4, 8,};
        MinHeap heap = new MinHeap(arr);
        System.out.println(Arrays.toString(heap.array));
//        System.out.println(heap.deleteMin());
        heap.insert(6);
        System.out.println(Arrays.toString(heap.array));
        heap.sort();
        System.out.println(Arrays.toString(heap.array));
    }


}
