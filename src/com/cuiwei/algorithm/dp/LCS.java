package com.cuiwei.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 动态规划找最长公共序列和最长公共子串
 * 思路：https://blog.csdn.net/hrn1216/article/details/51534607
 * https://blog.csdn.net/qiximiao123/article/details/80637755
 * https://blog.csdn.net/xiaoyi357/article/details/70209164/
 */
public class LCS {

    //最长公共子序列
    public static List<Integer> lcs1(int[] arr1, int[] arr2) {
        int[][] matrix = getLcsMatrix(arr1, arr2);
        return getLcsResult(matrix, arr1, arr2);
    }

    //构造一个LCS长度矩阵
    private static int[][] getLcsMatrix(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[][] matrix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix;
    }

    //递推结果
    private static List<Integer> getLcsResult(int[][] martix, int[] arr1, int[] arr2) {
        int i = martix.length - 1;
        int j = martix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (i != 0 && j != 0) {
            if (arr1[i - 1] == arr2[j - 1]) {
                result.add(arr1[i - 1]);
                i--;
                j--;
            } else {
                if (martix[i - 1][j] > martix[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        Collections.reverse(result);
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("第【" + i + "】行： ");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    //最长公共子串
    public static int[] lcs2(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] tmp = new int[n];
        int[] curr = new int[n];
        int max = 0;
        int pos = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j]) {
                    if (j == 0){
                        curr[j] = 1;
                    } else{
                        curr[j] = tmp[j - 1] + 1;
                    }
                    if (curr[j] >= max){
                        max = curr[j];
                        pos = j;
                    }
                }
            }
            System.out.println(Arrays.toString(tmp));
            for (int j = 0; j < n; j++) {
                tmp[j] = curr[j];
                curr[j] = 0;
            }
        }
        System.out.println(max + "," + pos);
        int beginIndex = pos - max +1;
        int[] result = new int[max];
        System.arraycopy(arr2,beginIndex,result,0,max);
        return result;
    }

    public static void main(String[] args) {
        int[] arr2 = new int[]{1,3,4,5,6,7,7,8};
        int[] arr1 = new int[]{3,5,7,4,8,6,7,8,2};
//       System.out.println(Arrays.toString(lcs1(arr1, arr2).toArray()));
        System.out.println(Arrays.toString(lcs2(arr1,arr2)));
    }
}
