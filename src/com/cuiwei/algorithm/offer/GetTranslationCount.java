package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*把数字翻译成字符串
给定一个数字，按照如下规则翻译为字符串，0翻译为a，1翻译为b。。。25翻译为z
求一个数字总共有多少种翻译方法，并求出这些翻译方法。*/
public class GetTranslationCount {

    public static void main(String[] args) {
        String numStr = "12218";
        System.out.println(getTranslationCount(numStr));
        transDigit(numStr.toCharArray(),0,new ArrayList<Character>());
    }
    public  static  int getTranslationCount(String num){
        char[] numArray = num.toCharArray();
        int len = numArray.length;
        int[] counts = new int[len];
        int count = 0;
        for (int i = len - 1; i >=0 ; i--) {
            if (i == len-1){
                count = 1;
            }else {
                count = counts[i+1];
            }
            if(i < len-1){
                int num1 = numArray[i] - '0';
                int num2 = numArray[i+1] - '0';
                int converted = num1*10 + num2;
                if(converted >= 0 && converted <= 25){
                    if (i == len-2){
                        count++;
                    }else{
                        count +=counts[i+2];
                    }
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

    public static void transDigit(char[] numChar, int index, List<Character> trans){
        if (index ==(numChar.length)){
//            System.out.println(Arrays.toString(trans.toArray()));
            printList(trans);
            return;
        }
        if(index == (numChar.length+1)){
            trans.add(transDigit2Char(numChar[index-2] - '0'));
//            System.out.println(Arrays.toString(trans.toArray()));
            printList(trans);
            trans.remove(trans.size()-1);
            return;
        }
        int digit1 = numChar[index] - '0';
        char[] temp;
        if (index == (numChar.length -1)){
            temp = new char[1];
            temp[0] = transDigit2Char(digit1);
        }else{
            int digit2 = numChar[index + 1] - '0';
            int digitConv = digit1*10 + digit2;
            if(digitConv >= 0 && digitConv <= 25){
                temp = new char[2];
                temp[0] = transDigit2Char(digit1);
                temp[1] = transDigit2Char(digitConv);
            }else{
                temp = new char[1];
                temp[0] = transDigit2Char(digit1);
            }
        }
        for(int i=0;i<temp.length;i++){
            trans.add(temp[i]);
            if(i == 0){
                transDigit(numChar,index+1,trans);
                trans.remove(trans.size() -1);
            }else {
                transDigit(numChar,index+2,trans);
                trans.remove(trans.size() -1);
            }
        }

    }
    private static char transDigit2Char(int digit){
        return (char) ('a' + digit);
    }
    private static void printList(List<Character> list){
        for(Character c : list){
            System.out.print(c);
        }
        System.out.print(" ");
    }
}
