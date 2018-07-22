package com.cuiwei.offer;

public class FindGreatSumOfSubArray {
    public static void main(String[] args) {
        int [] arr = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println("最大子向量之和为：" + findGreatSumOfSubArrat(arr));
    }

    public static int findGreatSumOfSubArrat(int [] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int curSum = arr[0];
        int greatSum = curSum;
        for (int i = 1; i < arr.length; i++) {
            if (curSum > 0){
                curSum += arr[i];
            }else{
                curSum = arr[i];
            }
            if (curSum > greatSum){
                greatSum = curSum;
            }
        }
        return greatSum;
    }
}
