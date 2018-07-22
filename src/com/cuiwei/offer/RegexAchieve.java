package com.cuiwei.offer;

/**
 * created by cuiwei on 2018/7/7
 */
public class RegexAchieve {

    public static boolean match(char[] str, char[] pattern) {
//        if(String.valueOf(pattern).equals(".*")) return true;
//        if (str.length == 0) return false;
//        if (pattern.length == 0)return false;
//        if (str.length == 0 && pattern.length==0) return true;
        if (str == null || pattern == null) return false;
        boolean flag = true;
        int i = 0;
        int j = 0;
        while (i < str.length && j < pattern.length) {
            if (str[i] == pattern[j] || pattern[j] != '.') {
                i++;
                j++;
                continue;
            }
            if (pattern[j] == '*') {
                if (str[i] != pattern[j - 1] && pattern[j - 1] != '.') {
                    j++;
                    continue;
                }
                i++;
                continue;
            }
            if (j + 1 >= pattern.length) {
                flag = false;
                break;
            }
            if (pattern[j + 1] == '*') {
                if (j + 2 >= pattern.length) {
                    flag = false;
                    break;
                }
                j += 2;
                continue;
            }
            flag = false;
            break;
        }
        return flag;
    }

    /**
     * 递归方法
     * @param str
     * @param pattern
     * @return
     * 链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
     * 来源：牛客网
     *
     * 版本1：这里是剑指offer的解题思路
     *     /* 讨论2种：先看 * 再看 匹配
     *      * 前提：当pattern遍历完，return取决于str是否遍历完，str恰好遍历完才返回true，再接下来讨论
     *      *  1.若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况
     *      *      一：当前匹配
     *      *      1.1match(str,i + 1,pattern,j)//跳过str
     *      *      1.2match(str,i,pattern,j + 2)//跳过pattern
     *      *      1.3match(str,i + 1,pattern,j + 2)//这一种可以省略，相当于 1.1 + 1.2
     *      *      二：当前不匹配
     *      *      match(str,i,pattern,j + 2)//跳过pattern
     *      * 2.下一个不是 *
     *      *     当前匹配 return match(str,i + 1,pattern,j + 1)
     *      
     */
    public boolean match2(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return match(str, 0, pattern, 0);
    }

    private boolean match(char[] str, int i, char[] pattern, int j) {
        if (j == pattern.length)//pattern遍历完了
            return str.length == i;//如果str也完了，返回true，不然false
        //注意数组越界问题，一下情况都保证数组不越界
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {//下一个是*
            if (str.length != i && //当前匹配
                    (str[i] == pattern[j] || pattern[j] == '.')) //匹配
                return match(str, i, pattern, j + 2)
                        || match(str, i + 1, pattern, j);
            else//当前不匹配
                return match(str, i, pattern, j + 2);
        }
        //下一个不是“*”，当前匹配
        if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.'))
            return match(str, i + 1, pattern, j + 1);
        return false;
    }

    public static void main(String[] args) {
        char[] str = "fdsaf".toCharArray();
        char[] pattern = ".".toCharArray();
        System.out.println(match(str, pattern));
    }
}
