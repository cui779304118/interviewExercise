package com.cuiwei.algorithm.offer.array;

/**
 * created by cuiwei on 2018/8/29
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 */
public class FindUnsortedSubarray {

    public static int fun(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return 0;
        int st = 0, en = arr.length - 1;
        boolean isSt = false, isEn = false;
        while (st < en) {
            for (int i = st; i <= en; i++) {
                int ri = st + en - i;
                if (arr[ri] < arr[st] ||
                        (arr[ri] == arr[st] && (ri - st) > 1)) {
                    isSt = true;
                }
                if (arr[i] > arr[en] ||
                        (arr[i] == arr[en] && (en - i) > 1)) {
                    isEn = true;
                }
            }
            if (isSt && isEn) break;
            if (!isSt) st++;
            if (!isEn) en--;
        }
        if (st >= en) return 0;
        return en - st + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 3};
        System.out.println(fun(arr));
    }

}
