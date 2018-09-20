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
        int index = partion2(arrs, st, en);
        fastSort(arrs, st, index - 1);
        fastSort(arrs, index + 1, en);
    }

    //直接选择第一个元素为枢纽元，当数组是有序时，分割会不均，时间复杂度为O(n2)
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

    private int partion2(int[] arrs,int st,int en){
        int flag = median3(arrs,st,en);//三数值分割法获取枢纽，然后将枢纽与最后一个元素交换
        int last = en;
        en--;//en指向倒数第二个元素
        while(st < en){
            while(st < en && arrs[st] < flag){//如果st指向的元素小于flag则直接右移
                st++;
            }
            while(st < en && arrs[en] > flag){//如果st指向的元素小于flag则直接左移
                en--;
            }
            if (st < en) {
                swap(arrs,st,en);//交换st和en指向的元素
            }
        }
        swap(arrs,st,last);//交换flag和st的值
        return st;
    }

    private int median3(int[] arrs,int st,int en){
        int median = (st + en) >> 1;
        if (arrs[st] < arrs[median]){
            swap(arrs,st,median);
        }
        if (arrs[st] > arrs[en]){
            swap(arrs,st,en);
        }
        if (arrs[median] > arrs[en] ){
            swap(arrs,en,median);
        }
        swap(arrs,median,en);//将median指向的元素与最后一个元素交换
        System.out.println("中序：" + Arrays.toString(arrs));
        return arrs[en];
    }

    private void swap(int[] arrs,int i,int j){
        int t = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = t;
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{8,1,4,9,6,3,5,2,7,0};
        FastSort tool = new FastSort();
        System.out.println(Arrays.toString(arrs));
        tool.sort(arrs);
        System.out.println(Arrays.toString(arrs));

    }
}
