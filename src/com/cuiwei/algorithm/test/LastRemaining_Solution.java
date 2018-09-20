package com.cuiwei.algorithm.test;

import java.util.ArrayList;
import java.util.List;

/**
 * created by cuiwei on 2018/8/19
 */
public class LastRemaining_Solution {

    public static int last(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        List<Integer> child = new ArrayList<>();
        for (int i = 0; i < n; i++) {//把孩子序号放进list
            child.add(i);
        }
        int index = 0;
        while (child.size() > 1) {
            index += m - 1;//数m-1个数
            child.remove(index %= child.size());
        }
        return child.get(0);
    }

    public static void main(String[] args) {
        System.out.println(last(3, 4));
    }


}
