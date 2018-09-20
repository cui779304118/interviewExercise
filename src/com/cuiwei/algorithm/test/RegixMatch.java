package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/19
 */
public class RegixMatch {


    public static boolean match2(char[] str, char[] pattern){
            if(str == null || pattern == null)
                return false;
            return match(str, 0, pattern, 0);

        }

    private  static boolean match(char[] str, int i, char[] pattern, int j) {
        if(j == pattern.length)//pattern遍历完了
            return str.length == i;//如果str也完了，返回true，不然false
        //注意数组越界问题，一下情况都保证数组不越界
        if(j < pattern.length - 1 && pattern[j + 1] == '*') {//下一个是*
            if(str.length != i && //当前匹配
                    (str[i] == pattern[j] || pattern[j] == '.')) //匹配
                return match(str,i,pattern,j + 2)
                        || match(str,i + 1,pattern,j);
            else//当前不匹配
                return match(str,i,pattern,j + 2);
        }
        //下一个不是“*”，当前匹配
        if(str.length != i && (str[i] == pattern[j] || pattern[j] == '.'))
            return match(str,i + 1,pattern,j + 1);
        return false;
    }



    public static void main(String[] args) {
        char[] str = "".toCharArray();
        char[] pattern = "b*a*".toCharArray();
        System.out.println(match2(str,pattern));
    }
}
