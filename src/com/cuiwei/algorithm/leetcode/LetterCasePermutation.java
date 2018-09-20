package com.cuiwei.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cuiwei on 2018/9/16
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，
 * 我们可以获得一个新的字符串。返回所有可能得到的字符串集合
 */
public class LetterCasePermutation {

    List<String> list = new ArrayList<>();
    public List<String> fun(String s){
        if (s == null)return list;
        permutation(s.toCharArray(),0);
        return list;
    }

    public void permutation(char[] chars, int index) {
        if (index >= chars.length) {
            list.add(String.valueOf(chars));
            return;
        }
        char letter = chars[index];
        if (isLetter(letter)) {
            chars[index] = convertLetter(letter);
            permutation(chars, index + 1);
            chars[index] = letter;
            permutation(chars, index + 1);
        }else{
            permutation(chars,index + 1);
        }
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private char convertLetter(char c){
        if (c >= 'a' && c <= 'z')
            return (char) (c - 32);
        else if (c >= 'A' && c <= 'Z')
            return (char) (c + 32);
        else throw new RuntimeException("字符不是字母类型");
    }

    public static void main(String[] args) {
        LetterCasePermutation permutation = new LetterCasePermutation();
        List<String> list = permutation.fun("1234");
        System.out.println(Arrays.toString(list.toArray()));
    }

}
