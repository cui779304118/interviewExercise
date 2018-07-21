package com.cuiwei.offer;

/**
 *输入一个字符串,包括数字字母符号,可以为空
 * 主要是考虑各种边界条件：
 * 1、判断是否为空
 * 2、判断正负号
 * 3、判断是否是数字字符
 * 4、数据上下是否溢出
 */
public class Str2Int {

    public static int str2Int(String str) {
        if (str == null || str.equals("")) return 0;
        char[] chars = str.toCharArray();
        int intNum = 0;
        int symbol = (chars[0] == '-') ? -1 : 1;
        for (char numChar : chars) {
            if (numChar == '+' || numChar == '-') {
                continue;
            }
            int num = (numChar - '0');
            if (num > 9 || num < 0) return 0;
            intNum = intNum * 10 + num;
        }
        return symbol* intNum;
    }

    public static void main(String[] args) {
        String str = "123456789123456789";
        System.out.println(str2Int(str));
    }
}
