package com.cuiwei.algorithm.offer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cuiwei on 2018/8/30
 * 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 */
public class FindDuplicates {

    public static List<Integer> fun(int[] arr){
        List<Integer> list = new ArrayList<>();
        if (arr == null || arr.length == 0) return list;
        for (int i = 0; i <arr.length ; i++) {
            int temp = arr[i] - 1;
            while(i != temp){
                if (arr[i] == arr[temp]){
                    if (!list.contains(arr[i]))
                    list.add(arr[i]);
                    break;
                }
                int t = arr[i];
                arr[i] = arr[temp];
                arr[temp] = t;
                temp = arr[i] - 1;
            }
        }
        return list;
    }

    public static List<Integer> fun2(int[] arr){
        List<Integer> list = new ArrayList<>();
        if (arr == null || arr.length == 0) return list;
        for (int i = 0; i <arr.length ; i++) {
            while(arr[i] != arr[arr[i] - 1]){
                int temp = arr[i];
                int t = arr[i];
                arr[i] = arr[temp -1];
                arr[temp-1] = t;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            if (i != arr[i] - 1){
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(fun2(arr).toArray()));
    }

}
