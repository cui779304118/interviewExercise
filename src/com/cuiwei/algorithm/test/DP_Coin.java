package com.cuiwei.algorithm.test;

import java.util.Scanner;

/**
 * created by cuiwei on 2018/8/21
 */
public class DP_Coin {
    public static long countOfCoins(int n){
        if (n <= 0) return 0;
        int[] coins = new int[]{1,5,10,20,50,100};
        long[] temp = new long[n+1];
        long[] cur = new long[n+1];
        for (int i = 1; i <= n ; i++) {
            temp[i] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= n ; j++) {
                if (j < coins[i]){
                    cur[j] = temp[j];
                }else if (j == coins[i]){
                    cur[j] =temp[j] + 1;
                }else {
                    cur[j] = temp[j] + cur[j-coins[i]];
                }
            }
            temp = cur;
        }
        return temp[n];
    }

    public static long count(int n){
        if (n <= 0) return 0;
        int[] coins = new int[]{1,5,10,20,50,100};
        long[] temp = new long[n+1];

        for (int i = 0; i <= n ; i++) {
            temp[i] = 1;
        }

        for (int i = 1; i <= 5 ; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]){
                    temp[j] += temp[j - coins[i]];
                }
            }
        }
        return temp[n];
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        System.out.println(countOfCoins(n));
    }


}
