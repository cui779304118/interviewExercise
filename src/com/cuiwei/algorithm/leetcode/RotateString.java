package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/16
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。
 * 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 */
public class RotateString {
    public static boolean rotateString(String A,String B){
        if (A == null || B == null || A.length() != B.length()) return false;
        if (A.length() == 0)return true;
        int i=0;
        while(true){
            for (;i < A.length() ; i++) {
                if (A.charAt(i) == B.charAt(0))
                    break;
            }
            if (i == A.length()) return false;
            int j = 0;
            for (; j < B.length() ; j++) {
                if (A.charAt(i) != B.charAt(j)) break;
                i++;
                i %= A.length();
            }
            if (j == B.length()) break;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcdce","ceabcd"));
    }

}
