package com.cuiwei.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * created by cuiwei on 2018/9/18
 * 唯一摩尔斯密码词
 */
public class UniqueMorseRepresentations {

    String[] secretTable = new String[]{
            ".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-","..-",
            "...-",".--","-..-","-.--","--.."
    };

    public int fun(String[] words){
        Set<String> secrets = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
                String transSecret = trans(words[i]);
                secrets.add(transSecret);
        }
        return secrets.size();
    }

    private String trans(String word){
        StringBuilder builder = new StringBuilder();
        int index;
        for (int i = 0; i < word.length() ; i++) {
            index = word.charAt(i) - 'a';
            builder.append(secretTable[index]);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations ob = new UniqueMorseRepresentations();
        String[] words = new String[]{"gin","zen","gig","msg"};
        System.out.println(ob.fun(words));
    }

}
