package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 注意：不用判断乘积最小，第一个肯定乘积最小，因为距离最远。
 */
public class FindNumbersWithSum {

    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) return result;
        int len = array.length;
        int st = 0;
        int en = len - 1;
        int temp;
//        int pro = 0;
        while (st < en) {
            temp = array[st] + array[en];
            if (temp > sum) {
                en--;
            } else if (temp < sum) {
                st++;
            } else {
                if (result.size() == 0){
                   result.add(array[st]);
                   result.add(array[en]);
//                   pro = array[st]*array[en];
                   st++;
                   break;
                }
//                int proSE;
//                if ((proSE = array[st] * array[en]) < pro) {
//                    pro = proSE;
//                    result.set(0, array[st]);
//                    result.set(1, array[en]);
//                }
//                st++;
            }
        }
        return result;
    }

    public static int[] makeArr(int n,int max){
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i]= new Random().nextInt(max);
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] array = makeArr(20,100);
        int[] array = new int[]{1,2,3,4,5};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(findNumbersWithSum(array,5).toArray()));
    }
}
