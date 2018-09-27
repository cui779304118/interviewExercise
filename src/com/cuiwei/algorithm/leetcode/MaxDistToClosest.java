package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/25
 * 到最近的人的最大距离
 * 题目：https://leetcode-cn.com/problems/maximize-distance-to-closest-person/description/
 */
public class MaxDistToClosest {
    public static int fun(int[] arr){
        if (arr == null || arr.length == 0) return 0;
        int maxDist = 0;
        int count = 0;
        boolean beginZero = true;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == 0){
                count++;
                continue;
            }
            if (arr[i] == 1){
                if (!beginZero){
                    count = (count + 1)/2;
                }
                maxDist = Math.max(maxDist,count);
                count=0;
                beginZero = false;
            }
        }
        maxDist = Math.max(maxDist,count);
        return maxDist;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,0};
        System.out.println(fun(arr));
    }


}
