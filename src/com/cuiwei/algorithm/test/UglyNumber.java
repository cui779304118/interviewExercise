package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/10
 */
public class UglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        if (index == 1) return 1;
        int[] res = new int[index];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;//当前乘以2，3,5的指针

        for (int i = 1; i < index; i++) {
            res[i] = min(res[p2] * 2, res[p3] * 3, res[p5] * 5);
            if (res[i] == res[p2] * 2) p2++;
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
        }
        return res[index - 1];
    }

    private int min(int a, int b, int c) {
        if (a <= b) {
            if (a <= c) return a;
            else return c;
        } else {
            if (b <= c) return b;
            else return c;
        }
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().GetUglyNumber_Solution(5));
    }

}
