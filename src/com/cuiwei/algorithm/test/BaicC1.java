package com.cuiwei.algorithm.test;

import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/11
 */
public class BaicC1 {

    public static boolean isSuShu(int num){
        int n = (int) Math.sqrt(num);
        for (int i = 2; i <= n ; i++) {
            if (num % i == 0) return false;
        }
        while(true){}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(isSuShu(num));
    }
}
