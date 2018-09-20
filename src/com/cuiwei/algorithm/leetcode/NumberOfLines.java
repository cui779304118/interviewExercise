package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/18
 * 写字符串需要的行数
 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/description/
 */
public class NumberOfLines {

    public static int[] fun(int[] widths, String s){
        int temp_count = 0;
        int counts = 0;
        int index;
        for (int i = 0; i < s.length() ; i++) {
            index = s.charAt(i) - 'a';
            temp_count += widths[index];
            if (temp_count == 100){
                counts++;
                temp_count=0;
            }
            if (temp_count > 100){
                counts++;
                temp_count = widths[index];
            }
        }
        return new int[]{++counts,temp_count};
    }
}
