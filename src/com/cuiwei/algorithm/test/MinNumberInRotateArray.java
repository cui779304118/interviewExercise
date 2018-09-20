package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/3
 */
public class MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int flag = array[0];
        int i = array.length - 1;
        for (; i >= 0; i--) {
            if (flag < array[i]) break;
        }
        return array[i + 1];
    }

    //二分查找方式
    public static int min(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }

    public static int minHelp(int[] arr, int i, int j) {
        for (int k = i; k < j - 1; k++) {
            if (arr[k] > arr[k + 1]) {
                return arr[k + 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 1, 2, 2, 3};
        System.out.println(min(arr));
    }

}
