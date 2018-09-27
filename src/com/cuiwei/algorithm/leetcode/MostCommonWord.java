package com.cuiwei.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * created by cuiwei on 2018/9/20
 * 最常见的单词
 */
public class MostCommonWord {
    public String fun(String paragraph, String[] banned){
        if (paragraph == null || paragraph.equals("")) return null;
        Set<String> banSet = makeWordSet(banned);//创建禁用词set

        Map<String,Integer> wordMap = new HashMap<>();
        String[] words = paragraph.split(" ");
        String maxWord = "";
        int maxCount = 0;
        for (String word : words){
            String lowWord = word.toLowerCase();
            char lastChar = lowWord.charAt(lowWord.length()-1);
            if (!isLetter(lastChar)){
                lowWord = lowWord.substring(0,lowWord.length() -1);
            }
            if (banSet.contains(lowWord)) continue;//如果是禁用词
            Integer count = wordMap.get(lowWord);
            if (count == null){
                count = 1;
            }else {
                ++count;
            }
            wordMap.put(lowWord,count);
            if (count > maxCount){
                maxWord = lowWord;
                maxCount = count;
            }
        }
        return maxWord;
    }
    private boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private Set<String> makeWordSet(String[] banned){
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < banned.length ; i++) {
            wordSet.add(banned[i]);
        }
        return wordSet;
    }

}
