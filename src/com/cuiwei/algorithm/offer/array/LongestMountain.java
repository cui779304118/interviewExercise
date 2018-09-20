package com.cuiwei.algorithm.offer.array;

/**
 * created by cuiwei on 2018/9/2
 */
public class LongestMountain {
    public static int fun(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int max = 0;
        int left, right;
        for (int i = 1; i < arr.length - 1; i++) {
            int flag = arr[i];
            left = i - 1;
            right = i + 1;
            while (left > 0) {
                if (arr[left] > flag && arr[left] <= arr[left - 1]) {
                    break;
                }
                left--;
            }
            left++;
            while (right < arr.length - 1) {
                if (arr[right] > flag && arr[right] <= arr[right + 1]) {
                    break;
                }
                right++;
            }
            right--;
            if (i > left && i < right)
                max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static boolean isMountain(int[] arr, int st, int en) {
        int maxL = arr[st];
        int[] maxRs = new int[arr.length];
        int maxR = arr[en];
        for (int i = en; i >= st; i--) {
            if (arr[i] > maxR) {
                maxR = arr[i];
            }
            maxRs[i] = maxR;
        }
        for (int i = st; i <= en; i++) {
            if (arr[i] > maxL && (i <= en - 1 && arr[i] > maxRs[i + 1])) {
                return true;
            }
            if (arr[i] > maxL) maxL = arr[i];
        }
        return false;
    }

    //
    public static int fun3(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int st = 0, en = 0;
        int max = 0;
        //如果是升序排列，就往后遍历，否则记下top值
        for (int r1 = 0; r1 < arr.length - 1; ) {
            if (arr[r1] >= arr[r1 + 1]) {
                int top = arr[r1];
                int r2 = r1 + 1;
                //如果是降序排列，并且所有值小于top，则往后遍历，否则记下最后一个索引
                while (r2 < arr.length - 1 && arr[r2] < top
                        && arr[r2] > arr[r2 + 1]) r2++;
                en = r2;
                if (arr[st] < top && arr[en] < top)//防止重复的
                    max = Math.max(max, en - st + 1);
                st = r2;
                r1 = r2;
                continue;
            }
            r1++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 2, 0, 2};
        System.out.println(fun3(arr));
    }
}
