package com.cuiwei.offer;

public class LeftRotateString {

    /**
     * 普通做法
     * @param str
     * @param n
     * @return
     */
    public static String leftRotateString(String str, int n){
        if (str == null || "".equals(str)) return "";
        char[] chars = str.toCharArray();
        int len = chars.length;
        char[] temp = new char[n];
        for (int i = 0; i < len ; i++) {
            if (i < n){
                temp[i] = chars[i];
                continue;
            }
            chars[i-n] = chars[i];
        }
        for (int i = 0; i < temp.length; i++) {
            chars[len - n + i] = temp[i];
        }
        return String.valueOf(chars);
    }

    /**
     * 最优解法，利用字符串翻转，假设字符串为abcdef，n=3，令X=abc,Y=def,
     * 先翻转X`= cba,Y`=fed,然后整体对X`Y`=cbafed翻转记得defabc
     * @param
     */
    public static String leftRotateString2(String str,int n){
        if (str == null || "".equals(str)) return "";
        char[] chars1 = str.substring(0,n).toCharArray();
        char[] chars2 = str.substring(n).toCharArray();
        rotate(chars1);
        rotate(chars2);
        char[] chars = (String.valueOf(chars1) + String.valueOf(chars2)).toCharArray();
        rotate(chars);
        return String.valueOf(chars);
    }
    private static void rotate(char[] chars){
        int len = chars.length;
        for (int i = 0; i < len/2; i++) {
            char temp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(leftRotateString2(str,2));
    }
}
