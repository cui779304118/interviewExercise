package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/14
 * 宝石与石头
 * 字符串J="aA",S = "aAAAbbbb"
 * 判断S中包含J中字符的个数
 */
public class NumJewelsInStones {

    //思路：自己做一个hash表
    public int fun(String J,String S){
        if (J==null || S == null) return 0;
        int[] hash = new int[58];
        for (int i = 0; i < J.length(); i++) {
            int index = J.charAt(i) - 'A';
            hash[index]++;
        }

        int nums = 0;
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'A';
            if (hash[index] > 0) nums++;
        }
        return nums;
    }
}
