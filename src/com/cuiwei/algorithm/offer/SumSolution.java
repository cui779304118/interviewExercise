package com.cuiwei.algorithm.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 实现思路：
 * 1、利用逻辑与的短路特性实现递归停止
 */
public class SumSolution {

    public static int sum(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }

    public static int sum2(int n) {
        if (n == 0) return 0;
        return sum2(n - 1) + n;
    }

    public static void main(String[] args) {
        System.out.println(sum(3));
    }
}
