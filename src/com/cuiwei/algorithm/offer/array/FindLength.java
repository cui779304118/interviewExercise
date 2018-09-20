package com.cuiwei.algorithm.offer.array;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/8/30
 */
public class FindLength {

    public static int fun(int[] a, int[] b){
        if (a== null || b == null) return 0;
        int[] last = new int[b.length + 1];
        int max = 0;//最大值
        for (int i = 1; i <= a.length ; i++) {
            int[] cur = new int[b.length + 1];
            int tem = a[i-1];
            for (int j = 1; j <= b.length; j++) {
                if (tem == b[j-1]){
                    cur[j] = last[j-1] + 1;
                    max = Math.max(cur[j],max);
                }
            }
            System.arraycopy(cur,0,last,0,b.length + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,2};
        int[] b = new int[]{3,1,2};
        System.out.println(fun(a,b));
    }
}
