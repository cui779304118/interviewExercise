package com.cuiwei.algorithm.leetcode;

import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 * created by cuiwei on 2018/9/13
 * 重构字符串
 */
public class ReOrganizedString {
    public static String reOrg(String s){
        int len = s.length();
        if (len == 0) return "";
        if (len == 1) return s;
        PriorityQueue<CharPair> heap = new PriorityQueue<>();
        int[] charCount = new int[58];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int indexOfChar = chars[i] - 65;
            charCount[indexOfChar]++;
            if (charCount[indexOfChar] > (len + 1)/2) //如果某一个字母的数量大于字符串长度的一半
                return "";
        }
        for (int i = 0; i < 58; i++) {
            char c = (char)(65 + i);
            int count = charCount[i];
            if (count > 0){
                heap.offer(new CharPair(c,count));
            }
        }
        return heap2String(heap);
    }

    private static String heap2String(PriorityQueue<CharPair> heap){
        StringBuilder builder = new StringBuilder();
        while(heap.size() > 1){
            CharPair char1 = heap.poll();
            CharPair char2 = heap.poll();
            while(char1 != null && char2 != null
                    && char2.count > 0){
                builder.append(char1.c);
                builder.append(char2.c);
                char1.count--;
                char2.count--;
            }
            if (char1.count > 0) heap.offer(char1);
        }
        if (heap.size() == 1){
            CharPair lastChar = heap.poll();
            if (lastChar != null && lastChar.count == 1){
                builder.append(lastChar.c);
            }else {
                return "";
            }
        }

        String result = builder.toString();
        for (int i = result.length() - 1; i >0 ; i--) {
            if (result.charAt(i) == result.charAt(i - 1)){
                return "";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "xogbmcjjie";
        System.out.println(reOrg(s));
    }


}

class CharPair implements Comparable<CharPair>{
    Character c;
    int count;
    public CharPair(Character c,int count){
        this.c = c;
        this.count = count;
    }
    @Override
    public int compareTo(CharPair o) {
        return o.count - this.count;
    }
}
