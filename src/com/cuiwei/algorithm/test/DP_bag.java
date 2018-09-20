package com.cuiwei.algorithm.test;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/8/21
 */
public class DP_bag {

    //01背包问题，递推公式f[i,j] = f[i-1,j] (w[i] > j),f[i,j] = max{f[i-1,j],f[i-1,j-w[i]] + p[i]} (w[i] <= j)
    //f[0,j] = 0(w[0] > j)
    public static int dp_bag(int n,int[] w,int[] p){
        if (n < 0) return 0;
        int[] last = new int[n + 1];
        //填充边界格子
        for (int i = 1; i <= n ; i++) {
            if (n < w[0]){
                last[i] = 0;
            }else {
                last[i] = p[0];
            }
        }
        System.out.println(Arrays.toString(last));

        for (int i = 1; i < w.length; i++) {
            int[] cur = new int[n+1];
            for (int j = 1; j <= n; j++) {
                if (j >= w[i]){
                    cur[j] = Math.max(last[j],last[j - w[i]] + p[i]);
                }else {
                    cur[j] = last[j];
                }
            }
            last = cur;
            System.out.println(Arrays.toString(last));
        }
        return last[n];
    }


    public static void main(String[] args) {
        int[] w = new int[]{2,2,6,5,4};
        int[] p = new int[]{6,3,5,4,6};
        System.out.println(dp_bag(10,w,p));
    }

}
