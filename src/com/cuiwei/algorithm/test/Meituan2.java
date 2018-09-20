package com.cuiwei.algorithm.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/6
 */
public class Meituan2 {
    public static long fun(int[] arr, int k, int t) {
        long times = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        int[] hash = new int[max + 1];
        int maxTime = 0;
//        for (int i = 0; i <= arr.length - k; i++) {
//            if (isMatch(arr, i, i + k - 1, t)) {
//                times++;
//            }
//        }
        for (int i = 0; i <= k - 1; i++) {
            int temp = ++hash[arr[i]];
            maxTime = Math.max(maxTime, temp);
        }
        times = (maxTime >= t) ? 1 : 0;
        for (int i = 1; i <= arr.length - k; i++) {
            hash[arr[i-1]]--;
            hash[arr[i + k - 1]]++;
            for (int j = 0; j <= hash.length ; j++) {
                if (hash[i] >= t) {
                    times++;
                    break;
                }
            }
        }
        return times;
    }

    public static boolean isMatch(int[] arr, int i, int j, int t) {
        int max = 0;
        for (int k = i; k <= j; k++) {
            if (arr[k] > max) max = arr[k];
        }
        int[] hash = new int[max + 1];
        for (int k = i; k <= j; k++) {
            int time = ++hash[arr[k]];
            if (time >= t) return true;
        }
        return false;
    }

    public static boolean isMatch2(int[] arr, int i, int j, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = i; k <= j; k++) {
            Integer temp = map.get(arr[k]);
            if (temp == null) {
                map.put(arr[k], 1);
            } else {
                temp++;
                map.put(arr[k], temp);
                if (temp >= t) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(fun(arr, k, t));
    }


}
