package com.cuiwei.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cuiwei on 2018/8/8
 */
public class Permutation {

    public ArrayList<String> permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.equals("")) return list;
        helper(str.toCharArray(),0,list);
        return list;
    }

    public void helper(char[] chars, int index, ArrayList<String> list){
        if (index == (chars.length-1)){
            list.add(String.valueOf(chars));
        }else{
            for (int i = index; i < chars.length ; i++) {
                swap(chars,index,i);
                helper(chars,index + 1,list);
                swap(chars,index,i);
            }
        }
    }

    private void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> list = new Permutation().permutation(str);
        System.out.println(Arrays.toString(list.toArray()));
    }

}
