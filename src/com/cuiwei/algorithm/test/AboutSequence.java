package com.cuiwei.algorithm.test;

import java.util.ArrayList;

/**
 * created by cuiwei on 2018/8/16
 */
public class AboutSequence {

    public static ArrayList<ArrayList<Integer>> findContinusSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 0) return result;
        int n = (int) Math.sqrt((double) sum * 2);//序列个数的上限
        for (int i = n; i >=2; i--) {//从小到大尝试序列个数
            if ((i & 1) == 1 && sum % i == 0//如果序列个数为奇数，并且能够整除
                    || (sum % i) * 2 == i) {//如果为偶数，平均数的小数点为0.5
                insertList(result, sum / i, i);
            }
        }
        return result;
    }

    private static void insertList(ArrayList<ArrayList<Integer>> result, int mid, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int st = mid - n / 2;//找到起始点
        st = (n & 1) == 1 ? st : st + 1;
        int en = st + n;
        for (; st < en; st++) {
            list.add(st);
        }
        result.add(list);
    }

    public static void main(String[] args) {
        findContinusSequence(3);
    }


}
