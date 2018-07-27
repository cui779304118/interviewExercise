package com.cuiwei.algorithm.sort;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/7/22
 * 快速排序
 * 算法分析：
 * 最佳情况：O(nlogn),最差情况：O(n2),平均情况O(nlogn)
 * 不是稳定的
 */
public class FastSort {

    public void sort(int[] arrs) {
        if (arrs == null || arrs.length == 0) return;
        fastSort(arrs, 0, arrs.length - 1);
    }

    private void fastSort(int[] arrs, int st, int en) {
        if (st >= en) return;
        int index = partion(arrs, st, en);
        fastSort(arrs, st, index - 1);
        fastSort(arrs, index + 1, en);
    }

    private int partion(int[] arrs,int st,int en){
        int flag = arrs[st];
        while(st<en){
            while (st < en && arrs[en] > flag) en--;
            if (st < en){
                swap(arrs,st,en);
                st++;
            }
            while(st<en && arrs[st] < flag) st++;
            if (st<en){
                swap(arrs,st,en);
                en--;
            }
        }
        return en;
    }

    private void swap(int[] arrs,int i,int j){
        int t = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = t;
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{2,4,1,34,23,22};
        FastSort tool = new FastSort();
        System.out.println(Arrays.toString(arrs));
        tool.sort(arrs);
        System.out.println(Arrays.toString(arrs));

    }
}
