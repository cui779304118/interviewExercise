package com.cuiwei.algorithm.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * created by cuiwei on 2018/7/30
 */
public class GetMedian {

    private int N = 0;//记录数据流中的个数
    //存储中位数左边的数
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    //存储中位数右边的数
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public void insert(Integer num) {
        if ((N & 1) == 0) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        N++;
    }

    public Double getMedian() {
        if ((N & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }


    public static void main(String[] args) {
        GetMedian median = new GetMedian();
        int[] arr = new int[]{5,2,3,4};
        for (int i = 0; i < arr.length ; i++) {
            median.insert(arr[i]);
            System.out.print(median.getMedian() + " ");
        }
    }


}
