package com.cuiwei.algorithm.offer;

/**
 * created by cuiwei on 2018/8/28
 * 给定一个正整数数组 nums。
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class NumSubArrayProductLessThanK {

    public static int fun(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int pro = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            pro *= nums[right];
            while (pro >= k) pro /= nums[left++];
            sum += right - left + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 2, 6};
        System.out.println(fun(arr, 100));
    }
}
