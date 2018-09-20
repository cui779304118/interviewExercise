package com.cuiwei.algorithm.test;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/8/16
 */
public class AboutChar {

    //用字母的ACII码值来做hash
    public static int firstNotRepeatingChar(String str) {
        if (null == str || str.equals("")) return -1;
        char[] chars = str.toCharArray();
        //字母ACII码：A-Z：65-90，a-z:97-122;
        //因此字母的ACII范围为65-122，总共58个字符
        int[] charTable = new int[58];

        for (int i = 0; i < chars.length; i++) {
            charTable[chars[i] - 65]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (charTable[chars[i] - 65] == 1) {
                return i;
            }
        }
        return -1;
    }


    public static String leftRotateString(String str, int n) {
        if (str == null || str.equals("") || n < 0) return str;
        String front = str.substring(0, n);
        String behind = str.substring(n, str.length());
        return behind + front;
    }

    public static String leftRotateString2(String str, int n) {
        if (str == null || str.equals("") || n <= 0) return str;
        char[] chars = str.toCharArray();
        reserve(chars, 0, n - 1);
        reserve(chars, n, chars.length - 1);
        reserve(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private static void reserve(char[] chars, int st, int en) {
        int sum = st + en;
        for (int i = st; i <= sum / 2; i++) {
            char t = chars[i];
            chars[i] = chars[sum - i];
            chars[sum - i] = t;
        }
    }

    public static String reverseSentence(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        str = str.trim();
        String[] strs = str.split(" ");
        int n = strs.length;
        for (int i = 0; i < n / 2; i++) {
            String temp = strs[i];
            strs[i] = strs[n - 1 - i];
            strs[n - 1 - i] = temp;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            builder.append(strs[i]).append(" ");
        }
        builder.append(strs[n - 1]);
        return builder.toString();
    }

    public static String reverseSentence2(String str) {
        if (str == null || str.equals("") || str.equals(" ")) {
            return str;
        }
        char[] chars = str.toCharArray();
        int st = 0, en = 0;
        int len = chars.length;
        while (en < len) {
            while (en < len && chars[en] != ' ') {
                en++;
            }
            if (en < 1) break;
            reserve(chars, st, en - 1);
            en++;
            st = en;
        }
        reserve(chars, 0, len - 1);
        return String.valueOf(chars);
    }
    public static String replace(String str){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i) == ' '){
                builder.append("%20");
            }else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replace("We Are Happy"));
//        System.out.println(reverseSentence2(" "));
    }

}
