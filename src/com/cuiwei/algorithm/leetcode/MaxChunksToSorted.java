package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/17
 * 数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，
 * 并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 我们最多能将数组分成多少块？
 * 例如：arr = [4,3,2,1,0]，只能分成一块；
 * arr=[1,0,2,3,4],能分成四块；
 */
public class MaxChunksToSorted {

    //自己编，有问题
    public static int fun(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0;
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                sum++;
                break;
            }
            int flag = arr[i];
            int j = i + 1;
            for (; j < arr.length; j++) {
                if (arr[j] < flag) {
                    lastIndex = j;
                }
                flag = Math.max(arr[j],flag);
            }
            sum++;
            if (lastIndex == i - 1){
                lastIndex++;
                continue;
            }
            i = lastIndex;
        }
        return sum;
    }

    //正确答案
    public static int fun2(int[] arr){
        int len = arr.length;
        int count = 1;

        int leftMax = arr[0];
        int[] rightMin = new int[len];
        rightMin[len-1] = arr[len - 1];

        for (int i = len -2 ; i >=0 ; i--) {
            rightMin[i] = Math.min(arr[i],rightMin[i+1]);
        }

        for (int i = 1; i < len; i++) {
            if (rightMin[i] >= leftMax){
                count++;
                leftMax = arr[i];
            }else {
                leftMax = Math.max(leftMax,arr[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,0,2,3,5};
        System.out.println(fun2(arr));
    }

}
