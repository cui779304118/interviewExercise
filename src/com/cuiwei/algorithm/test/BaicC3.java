package com.cuiwei.algorithm.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/11
 */
public class BaicC3 {

    public static int[] fun(int[] arr1,int[] arr2){
        int idxTmp = 0,idx1 = 0,idx2 = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] temp = new int[len1 + len2];
        while(idx1 < len1 && idx2 < len2){
            if (arr1[idx1] <= arr2[idx2]){
                temp[idxTmp++] = arr1[idx1++];
            }else{
                temp[idxTmp++] = arr2[idx2++];
            }
        }

        while(idx1 < len1){
            temp[idxTmp++] = arr1[idx1++];
        }
        while(idx2 < len2){
            temp[idxTmp++] = arr2[idx2++];
        }
        return temp;
    }

    public static int[] fun2(List<int[]> arrs){
        int maxNum = 100000;
        int[] base = new int[maxNum];
        int indexs = 0;
        for (int i = 0; i <arrs.size() ; i++) {
            int[] temp = arrs.get(i);
            indexs += temp.length;
            for (int j = 0; j < temp.length ; j++) {
                base[temp[j]]++;
            }
        }
        int[] results = new int[indexs];
        int index = 0;
        for (int i = 0; i < maxNum; i++) {
            while (base[i] > 0){
                results[index++] = i;
                base[i]--;
            }
        }
        return results;
    }

    public static int[] funMain(List<int[]> arrs){
        int[] bef = arrs.get(0);
        for (int i = 1; i < arrs.size(); i++) {
            bef = fun(bef,arrs.get(i));
        }
        return bef;
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<int[]> arrs = new ArrayList<>();
//
//        for (int i = 0; i < n ; i++) {
//            int m = sc.nextInt();
//            int[] temp = new int[m];
//            for (int j = 0; j < m ; j++) {
//                temp[j] = sc.nextInt();
//            }
//            arrs.add(temp);
//        }
//        int[] result = funMain(arrs);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }
        int [] arr1 = new int[]{1,2,3};
        int [] arr2 = new int[]{1,1,2,3};
        int [] arr3 = new int[]{3,4};
        int [] arr4 = new int[]{5,6};
        List<int[]> arrs = new ArrayList<>();
        arrs.add(arr1);
        arrs.add(arr2);
        arrs.add(arr3);
        arrs.add(arr4);
        System.out.println(Arrays.toString(fun2(arrs)));
    }


}
