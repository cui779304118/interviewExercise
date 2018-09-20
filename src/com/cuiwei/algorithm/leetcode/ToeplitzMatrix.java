package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/13
 * 判断是否是拓普利兹矩阵，即对角线元素相同
 */
public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix){
        if (matrix == null) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n ; i++) {
            if (!isTrue(matrix,0,i)) return false;
        }
        for (int i = 1; i < m ; i++) {
            if (!isTrue(matrix,i,0)) return false;
        }
        return true;
    }

    private static boolean isTrue(int[][] matrix,int row,int col){
        int m = matrix.length;
        int n = matrix[0].length;
        while(row < m - 1 && col < n - 1){
            if (matrix[row][col] != matrix[++row][++col]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,0,2,3},
                {9,5,1,2}
        };
        System.out.println(isToeplitzMatrix(matrix));
    }

}
