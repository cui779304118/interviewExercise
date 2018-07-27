package com.cuiwei.algorithm.sort;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/7/20
 * 选择排序，时间复杂度为O(n)
 * 不稳定
 */
public class SelectionSort {
    public static void sort(int[] arr){
        if (arr==null || arr.length ==0){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int t = arr[i];
                if (arr[j] < t){
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr= new int[]{5,3,1,2,9,1,10};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
