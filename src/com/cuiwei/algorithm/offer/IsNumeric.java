package com.cuiwei.algorithm.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        //第一位必须为数字或者'+','-'
        if (!isNumber(str[0]) && !isAC(str[0])){
            return false;
        }
        //最后一位只能为数字
        if (!isNumber(str[str.length - 1])){
            return false;
        }
        boolean flag = true;
        boolean isPointBeforeE = true;
        int numOfPoint = 0;
        for (int i = 1; i < str.length - 1; i++) {
            //如果不是数字，'+','-','.','e','E'中的一种，就不是数字
            if (!isNumber(str[i]) && !isAC(str[i]) &&
                    !isP(str[i]) && !isE(str[i])){
                flag = false;
                break;
            }
            //如果是'+',前一位必须为'e'或者'E'，后一位必须为数字
            if (isAC(str[i]) && (!isNumber(str[i+1]) || !isE(str[i-1]))){
                flag = false;
                break;
            }
            //如果是'e'或者'E'
            if (isE(str[i])) {
                //前一位必须为数字，后一位为数字或者'+''-'
                if (!isNumber(str[i - 1]) || (!isNumber(str[i + 1]) && !isAC(str[i + 1]))) {
                    flag = false;
                    break;
                } else {//e后面不能再有'.'
                    if (numOfPoint == 0) isPointBeforeE = false;
                }
            }
            //如果为'.',小数点个数不能超过1，并且小数点不能在'e'或者'E'后面
            if (isP(str[i]) && ((++numOfPoint > 1) || !isPointBeforeE)){
               flag = false;
               break;
            }
        }
        return flag;
    }

    /*
        以下对正则进行解释:
        [\\+\\-]?            -> 正或负符号出现与否
        \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
        (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                                否则一起不出现
        ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                                紧接着必须跟着整数；或者整个部分都不出现
     */
    public boolean isNumericRegex(char[] chars){
        if (chars == null || chars.length == 0) return false;
        String str= new String(chars);
        String regex = "^[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?$";
        return str.matches(regex);
    }

    private boolean isE(char c) {
        return c == 'e' || c == 'E';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAC(char c) {
        return c == '+' || c == '-';
    }

    private boolean isP(char c) {
        return '.' == c;
    }

    public static void main(String[] args) {
        char[] str = "2e+5.4".toCharArray();
        IsNumeric tool = new IsNumeric();
        System.out.println(tool.isE(str[0]));
        System.out.println(tool.isNumeric(str));
    }
}
