package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/27
 * 山脉数组的峰顶索引
 * 题目：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/description/
 */
public class PeakIndexInMountainArray {
    public static int fun(int[] arr){
        if (arr == null || arr.length == 0) return 0;
        int low = 0,high = arr.length - 1;
        int mid;
        while(low < high){
            mid = (low + high) >> 1;
            int be = mid - 1;
            int af = mid + 1;
            if (arr[mid] > arr[be] && arr[mid] < arr[af]){
                low = mid;
            }else if ( arr[mid] > arr[af] && arr[mid] < arr[be]){
                high = mid;
            }else if (arr[mid] > arr[af] && arr[mid] > arr[be]){
                return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,3,2,0};
        System.out.println(fun(arr));
    }


}
