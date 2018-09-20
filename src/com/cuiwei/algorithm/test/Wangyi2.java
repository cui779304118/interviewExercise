package com.cuiwei.algorithm.test;
import java.util.Scanner;

public class Wangyi2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }
        fun(arr1,arr2,n);

    }

    public static void fun(int[] arr1,int[] arr2,int n){
        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[i] || arr1[i] < 3 || arr2[i] < 2) {
                System.out.println("0" + " 0");
                continue;
            }

            if (arr2[i] <= Math.ceil(arr1[i] / 2)) {
                System.out.println("0 " + (arr2[i]-1));
            } else {
                System.out.println("0 " + (arr1[i] - arr2[i]));
            }
        }
    }

}