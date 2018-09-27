package com.cuiwei.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cuiwei on 2018/9/25
 * 较大分组的位置
 * 题目：https://leetcode-cn.com/problems/positions-of-large-groups/description/
 */
public class LargeGroupPositions {
    public static List<List<Integer>> fun(String s){
        List<List<Integer>> lists = new ArrayList<>();
        if (s == null || s.equals("")) return lists;
        int len = s.length();
        int beginCount = 0;
        int endCount = 0;
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)){
                if (endCount - beginCount >= 2){
                    List<Integer> list = new ArrayList<>();
                    list.add(beginCount);
                    list.add(endCount);
                    lists.add(list);
                }
                    beginCount = i + 1;
                    endCount = i + 1;
            }else{
                endCount++;
            }
        }
        if (endCount == len - 1 && endCount - beginCount >=2){
            List<Integer> list = new ArrayList<>();
            list.add(beginCount);
            list.add(endCount);
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        String s = "aaa";
        List<List<Integer>> lists = fun(s);
        for (List<Integer> list : lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
