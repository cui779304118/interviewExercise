package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/16
 * <p>
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
 * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。
 * 0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；
 * 6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 */
public class RotateDigits {

    public static boolean isGoodNum(int num) {
        String numStr = String.valueOf(num);
        char[] nums = numStr.toCharArray();
        boolean isOnlySelfNum = true;
        for (int i = 0; i < nums.length; i++) {
            if (isNotSelfNum(nums[i])) isOnlySelfNum = false;
            if (!isSelfNum(nums[i]) && !isNotSelfNum(nums[i])) return false;
        }
        return !isOnlySelfNum;
    }

    private static boolean isSelfNum(char numChar) {
        return numChar == '0' || numChar == '1' || numChar == '8';
    }

    private static boolean isNotSelfNum(char numChar) {
        return numChar == '2' || numChar == '5' || numChar == '6' || numChar == '9';
    }

    public static int rotatedDigits(int N) {
        int sum = 0;
        for (int i = 2; i <= N; i++) {
            if (isGoodNum(i)) sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }


}
