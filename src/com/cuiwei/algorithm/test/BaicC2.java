package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/9/11
 */
public class BaicC2 {
    private static boolean flag = false;
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-2,5,7};
        int k = 50;
        fun(arr,0,0,k);
        System.out.println(flag);

    }
    public static void fun(int[] arr,int i,int sum, int k){
        if (i >= arr.length || flag ){
            return;
        }
        if (sum == k){
            flag = true;
            return;
        }
        fun(arr,i+1,sum + arr[i],k);
        fun(arr,i+1,sum,k);
    }
}
