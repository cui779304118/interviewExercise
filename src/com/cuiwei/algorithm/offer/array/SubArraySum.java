package com.cuiwei.algorithm.offer.array;

import java.util.HashMap;
import java.util.Map;

/**
 * created by cuiwei on 2018/9/1
 */
public class SubArraySum {
    //滑动窗口的形式
    public static int fun(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0;
        int temp = 0;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            while (left <= i && (temp > k || arr[left] < 0)) {
                temp -= arr[left];
                left++;
            }
            if (left <= i && temp == k) sum++;
        }
        return sum;
    }

    //哈希的形式
    public static int fun2(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            Integer sumk = map.get(sum - k);
            if (sumk != null) res += map.get(sum - k);
            Integer temp = map.get(sum);
            temp = (temp == null) ? 1 : temp + 1;
            map.put(sum, temp);
        }
        return res;
    }

    //遍历的方式
    public static int fun3(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int sum;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, 1};
        System.out.println(fun3(arr, 1));
    }

}
