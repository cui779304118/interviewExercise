package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/19
 */
public class Solution {

    public static int sum(int n) {
        boolean flag = n != 1 && (n = n + sum(n - 1)) > 0;
        return n;
    }

    public static double power(double a, int n) {
        if (n == 0) return 1;
        int e = n;
        if (n < 0) e = -1 * n;
        double temp = a;
        double re = 1;
        while (e != 0) {
            if ((e & 1) == 1) {
                re *= temp;
            }
            temp *= temp;
            e = e >> 1;
        }
        return n < 0 ? 1 / re : re;
    }

    public static int str2Int(String str) {
        if (str == null || str.equals("") || str.length() > 12) return 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+') continue;
            if ((c < '0' || c > '9')) {
                if (i == 0 && c == '-') {
                    sign = -1;
                    continue;
                } else return 0;
            }
            num = num * 10 + (c - '0');
        }
        return num * sign;
    }

    public static int add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public static boolean isNumeric(String str){
        if (str == null || str.length() == 0) return false;
        char[] chars = str.toCharArray();
        boolean isP=false,isE=false;
        for (int i = 0; i < str.length() ; i++) {
            char c = chars[i];
            if ('+' == c || '-' == c){
                if (i == 0 || chars[i -1]== 'e' ||chars[i -1]== 'E') continue;
                else return false;
            }
            if ('e' == c || 'E' ==c){
                if (i>0 && i <chars.length-1 && !isE){
                    isE = true;
                    continue;
                }
                else return false;
            }
            if ('.'==c){
                if (!isE && !isP){
                    isP = true;
                    continue;
                }
                else return false;
            }
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        boolean hasEOrP = false;
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (isSign(c) && !(i == 0 || (i < str.length-1) && isE(str[i-1]))) return false;
            if (isP(c) ){
                if((i == 0 || hasEOrP)){
                    return false;
                }else {
                    hasEOrP = true;
                }
            }
            if (isE(c)) {
                if (!((i < str.length - 1 && i > 0) && (isNum(str[i + 1]) || isSign(str[i + 1])))) {
                    return false;
                } else {
                    hasEOrP = true;
                }
            }
            if (!isNum(c)) return false;
        }
        return true;
    }

    private static boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private static boolean isE(char c) {
        return c == 'e' || c == 'E';
    }

    private static boolean isNum(char c) {
        return (c >= '0' && c <= '9') || isE(c) || isP(c) ||isSign(c);
    }

    private static boolean isP(char c) {
        return c == '.';
    }

    public static void main(String[] args) {
//        System.out.println(sum(3));
//        System.out.println(str2Int("-112"));
//        System.out.println(add(111, 899));
//        System.out.println(power(2, 3));
        System.out.println(isNumeric("1.2.3"));
    }

}
