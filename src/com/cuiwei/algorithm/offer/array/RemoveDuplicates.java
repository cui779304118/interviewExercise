package com.cuiwei.algorithm.offer.array;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/8/29
 */
public class RemoveDuplicates {

    public static int fun(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int size = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                int k = i+1;
                while (k < arr.length && arr[k] == arr[i]) {
                    k++;
                }
                if (k == arr.length){
                    size = i;
                    break;
                }
                for (int j = i; j < k; j++) {
                    arr[j] = arr[k];
                }
            }else{
                size++;
            }
        }
        return size;
    }

    public static int fun2(int[] arr){
        if (arr == null || arr.length == 0) return 0;
        int index = 0;//用一个标记来记录不重复的数字，相当于维护了一个数组
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] != arr[index]){
                arr[++index] = arr[i];
            }
        }
        return ++index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(fun(arr));
    }
}
