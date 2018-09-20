package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 寻找数组最大的或最小的n个数。
 *
 * @author Lebron
 */
public class GetMaxAndLeastNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 3, 4, 9, 0, 7};
//		int [] result = getMaxNumbers(arr,8);
//		System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(getTopkByPartion(arr, 4).toArray()));

    }

    //寻找最大的n个数。
    public static int[] getMaxNumbers(int[] arr, int n) {
        if (arr == null || arr.length < n || n <= 0) {
            return null;
        }
        int[] result = new int[n];
        int st = 0;
        int en = arr.length - 1;
        int m = arr.length - n - 1;//标志点位于这个位置时，右边有n个数比它大。
        int k = partion(arr, st, en);//标志点的位置
        while (k != m) {
            if (k > m) {
                k = partion(arr, st, k - 1);
            } else {
                k = partion(arr, k + 1, en);
            }
        }
        System.arraycopy(arr, k + 1, result, 0, n);
        List resultList = Arrays.asList(arr);
        System.out.println(resultList);
        return result;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        List<Integer> resultList = null;
        if (null == input || input.length == 0) {
            return null;
        }
        int n = partion(input, 0, input.length - 1);
        while (n != (k - 1)) {
            if (n < k) {
                n = partion(input, n + 1, input.length - 1);
            }
            if (n > k) {
                n = partion(input, 0, n - 1);
            }
        }
        resultList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resultList.add(input[i]);
        }
        return (ArrayList<Integer>) resultList;

    }

    //分区：左边比该数小，右边都比该数大
    public static int partion(int[] arr, int st, int en) {
        int flag = arr[st];
        while (st < en) {
            while (st < en && arr[en] > flag) en--;
            if (st < en) {
                swap(arr, st, en);
                st++;
            }
            while (st < en && arr[st] < flag) st++;
            if (st < en) {
                swap(arr, st, en);
                en--;
            }
        }
        return en;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static ArrayList<Integer> getTopkByHeap(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) return null;
        ArrayList<Integer> results = new ArrayList<>(k);

        int[] minHeap = new int[k];
        System.arraycopy(array, 0, minHeap, 0, k);
        for (int i = k / 2 - 1; i >= 0; i--) {
            adjustHeap(minHeap, k, i);
        }
        System.out.println(Arrays.toString(minHeap));
        for (int i = k; i < array.length; i++) {
            if (array[i] > minHeap[0]) {
                minHeap[0] = array[i];
                adjustHeap(minHeap, k, 0);
            }
        }
        for (int i = 0; i < k; i++) {
            results.add(minHeap[i]);
        }
        return results;
    }

    private static void adjustHeap(int[] arr, int len, int i) {
        int temp = arr[i];
        int cur = i;
        for (int j = 2 * cur + 1; j < len; j = 2 * j + 1) {
            if ((j + 1) < len && arr[j + 1] < arr[j]) {
                j++;
            }
            if (arr[j] < temp) {
                arr[cur] = arr[j];//较小的子节点上滤
                cur = j;//指针指向子节点
            } else {
                break;
            }
        }
        arr[cur] = temp;
    }

    public static List<Integer> getTopkByPartion(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) return null;
        ArrayList<Integer> results = new ArrayList<>(k);
        int index = partion2(array, 0, array.length - 1);
        int kk = array.length - k - 1;
        while (index != kk) {
            if (index > kk) {
                index = partion2(array, 0, index - 1);
            } else if (index < kk) {
                index = partion2(array, index + 1, array.length - 1);
            }
        }
        for (int i = kk + 1; i < array.length; i++) {
            results.add(array[i]);
        }
        return results;
    }

    private static int partion2(int[] array, int st, int en) {
        int flag = array[st];
        while (st < en) {
            while (st < en && array[en] > flag) {
                en--;
            }
            if (st < en) {
                swap(array, st, en);
                st++;
            }
            while (st < en && array[st] < flag) {
                st++;
            }
            if (st < en) {
                swap(array, st, en);
                en--;
            }
        }
        return st;
    }


}
