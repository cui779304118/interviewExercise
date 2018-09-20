package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/18
 */
public class Dp_Gangtiao {

    //递归方法
    public static int fun1(int n, int[] p) {
        if (n == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int price = p[i-1] + fun1(n - i, p);
            max = Math.max(max, price);
        }
        return max;
    }

    public static int fun2(int n, int[] p) {
        if (n == 0) return 0;
        int[] r = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, p[j-1] + r[i - j]);
            }
            r[i] = max;
        }
        return r[n];
    }



    public static void main(String[] args) {
        int[] p = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(fun2(3, p));
    }


}
