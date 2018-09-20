package com.cuiwei.algorithm.offer.array;

/**
 * created by cuiwei on 2018/8/29
 *索引从0开始长度为N的数组A，包含0到N - 1的所有整数。
 * 找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]...
 * 以此类推，不断添加直到S出现重复的元素。
 *
 */

public class ArrayNesting {

    public static   int fun(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < nums.length ; i++) {
            int count = 0;
            int k = i;
            while(nums[k] >=0){
                count++;
                int temp = nums[k];
                nums[k]=-1;
                k = temp;
            }
            if (count > max) max = count;
        }
        return max;
    }

    public static void main(String[] args) {
       int [] arr = new int[]{5,4,0,3,1,6,2};
        System.out.println(fun(arr));
    }



}
