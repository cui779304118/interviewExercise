package com.cuiwei.algorithm.offer.array;

/**
 * created by cuiwei on 2018/9/2
 */
public class MinSubArrayLen {
    //暴力解法
    public static int fun(int s, int[] arr) {
        if (arr == null || arr.length == 0 || s <= 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int len = 0;
            int j = i;
            for (; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= s) {
                    len = j - i + 1;
                    break;
                }
            }
            if (j < arr.length) {
                min = Math.min(len, min);
            }
        }
        min = (min == Integer.MAX_VALUE) ? 0 : min;
        return min;
    }

    //效率较高的解法
    public static int fun2(int s,int[] arr){
        if (arr == null || arr.length == 0 || s <= 0) return 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i];
            while(sum >= s){
                min = Math.min(i - left + 1,min);
                sum -= arr[left];
                left++;
            }
        }
        min = (min == Integer.MAX_VALUE) ? 0 : min;
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        int s = 11;
        System.out.println(fun2(s, arr));
    }


}
