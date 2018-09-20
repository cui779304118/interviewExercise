package com.cuiwei.algorithm.test;

import java.util.Scanner;

/**
 * created by cuiwei on 2018/8/18
 */
public class ShuiXianHua {
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            StringBuilder builder = new StringBuilder();
            for (int i = a; i <= b; i++) {
                if (isShuiXianHua(i)) {
                    builder.append(i).append(" ");
                }
            }
            String result = builder.toString();
            if (!result.equals("")) {
                System.out.println(result.trim());
            } else {
                System.out.println("no");
            }
        }
    }
    public static boolean isShuiXianHua(int num){
        int m = num;
        int sum = 0;
        while (num  != 0 ){
            int tem = (num % 10);
            sum += tem*tem*tem;
            num /= 10;
        }
        return m == sum;
    }



}




