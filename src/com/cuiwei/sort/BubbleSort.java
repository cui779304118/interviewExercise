package com.cuiwei.sort;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/7/20
 * 冒泡排序，时间复杂的度0(n2),稳定
 */
public class BubbleSort {
    public static void bubbleSort(int[ ] arr){
        if (arr == null || arr.length==0){
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,1,0,9,1};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
