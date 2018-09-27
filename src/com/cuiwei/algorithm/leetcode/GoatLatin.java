package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/23
 * 山羊拉丁文
 * 题目：https://leetcode-cn.com/problems/goat-latin/description/
 */
public class GoatLatin {
    public String fun(String s) {
        if (s == null || s.equals("")) return "";
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String transWord = "";
            char firstChar = word.charAt(0);
            if (isMajor(firstChar)) {
                transWord = transMajor(word);
            } else {
                transWord = transNonMajor(word);
            }
            result.append(transWord);
            for (int j = 0; j <= i; j++) {
                result.append("a");
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    private boolean isMajor(char c) {
        if (c >= 'A' && c <= 'Z') {
            c += 32;
        }
        return c == 'a' || c == 'e' ||
                c == 'i' || c == 'o' || c == 'u';
    }

    private String transMajor(String word) {
        return word + "ma";
    }

    private String transNonMajor(String word) {
        char[] chars = word.toCharArray();
        char temp = chars[0];
        for (int i = 0; i < chars.length - 1; i++) {
            chars[i] = chars[i + 1];
        }
        chars[chars.length - 1] = temp;
        return String.valueOf(chars) + "ma";
    }

    public static void main(String[] args) {
        GoatLatin goatLatin = new GoatLatin();
        String sentence = "I speak Goat Latin";
        System.out.println(goatLatin.fun(sentence));
    }

}
