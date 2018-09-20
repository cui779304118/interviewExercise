package com.cuiwei.algorithm.test;

import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/9
 */
public class Baicizhan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(fun(String.valueOf(num)));
    }

    public static String fun(String num){
        char[] chars = num.toCharArray();
        StringBuilder builder = new StringBuilder();
        int low = 0;
        if (chars[0] == '-' || chars[0] == '+'){
            builder.append(chars[0]);
            low = 1;
        }
        for (int i = chars.length - 1; i >= low ; i--) {
            if (chars[i] != '0' )
            builder.append(chars[i]);
        }
        return builder.toString();
    }

}
