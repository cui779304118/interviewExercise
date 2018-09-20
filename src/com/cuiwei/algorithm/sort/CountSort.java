package com.cuiwei.algorithm.sort;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/8/3
 */
public class CountSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int min = arr[0], max = arr[0];
        //找出最大和最小值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        //偏移值，为了兼容负数
        int bia = 0 - min;
        //新建辅助存储空间
        int[] buckets = new int[max - min + 1];
        //将原数组中值存入辅助空间并排序
        for (int i = 0; i < arr.length; i++) {
            buckets[arr[i] + bia]++;
        }
        //将辅助空间中统计好的数依次放回原数组中
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                arr[index++] = i - bia;
                buckets[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 6, 4, 5, 9, -1, -3, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
