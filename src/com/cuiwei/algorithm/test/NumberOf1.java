package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/15
 */
public class NumberOf1 {

    public int countOf1(int number) {
        if (number < 0) return 0;
        int ones = 0;
        for (int m = 1; m <= number; m *= 10) {
            int a = number / m, b = number % m;
            ones += (a + 8) / 10 * m + ((a % 10 == 1) ? b + 1 : 0);
        }
        return ones;
    }
}
