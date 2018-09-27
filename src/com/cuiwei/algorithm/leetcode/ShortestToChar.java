package com.cuiwei.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cuiwei on 2018/9/23
 * 字符的最短距离
 * 题目：https://leetcode-cn.com/problems/shortest-distance-to-a-character/description/
 */
public class ShortestToChar {

    public static int[] fun(String s, char c){
        char[] chars = s.toCharArray();
        int[] instances = new int[chars.length];
        List<Integer> indexOfC = new ArrayList<>();
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i] == c){
                indexOfC.add(i);
            }
        }
        for (int i = 0; i < chars.length ; i++) {
            char cTemp = chars[i];
            if (cTemp == c) {
                instances[i] = 0;
            }else {
                int min = Math.abs(i - indexOfC.get(0));
                for (int j = 1; j < indexOfC.size() ; j++) {
                    int diff = Math.abs(i - indexOfC.get(j));
                    if (diff < min){
                        min = diff;
                    }
                }
                instances[i] = min;
            }
        }
        return instances;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(fun(s,c)));
    }


}
