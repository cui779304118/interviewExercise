package com.cuiwei.algorithm.test;

import java.util.Scanner;

/**
 * created by cuiwei on 2018/8/27
 */
public class Test360_1 {
    public static   long minArea(int n,int[][] arr){
        int min1=Integer.MAX_VALUE,max1=Integer.MIN_VALUE,min2=Integer.MAX_VALUE,max2=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] < min1) min1 = arr[i][0];
            if (arr[i][0] > max1) max1 = arr[i][0];
            if (arr[i][1] < min2) min2 = arr[i][1];
            if (arr[i][1] > max2) max2 = arr[i][1];
        }
        int a1 = max1 - min1;
        int a2 = max2 - min2;
        long a = (long)Math.max(a1,a2);
        return a*a;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(minArea(n,arr));
    }

}
