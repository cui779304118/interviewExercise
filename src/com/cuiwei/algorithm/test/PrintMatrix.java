package com.cuiwei.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cuiwei on 2018/8/15
 */
public class PrintMatrix {

    //思路：定位四个角，colSt,colEn,rowSt,rowEn
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int colSt = 0, colEn = matrix[0].length - 1;
        int rowSt = 0, rowEn = matrix.length - 1;
        while (colSt <= colEn && rowSt <= rowEn) {
            for (int j = colSt; j <= colEn; j++) {
                list.add(matrix[rowSt][j]);
            }
            for (int i = rowSt + 1; i <= rowEn; i++) {
                list.add(matrix[i][colEn]);
            }

            for (int j = colEn -1 ; j > colSt && rowSt < rowEn; j--) {
                list.add(matrix[rowEn][j]);
            }

            for (int i = rowEn; i > rowSt && colSt < colEn; i--) {
                list.add(matrix[i][colSt]);
            }
            rowSt++;
            rowEn--;
            colSt++;
            colEn--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3}};
        List<Integer> list = printMatrix(matrix);
        System.out.println(Arrays.toString(list.toArray()));
    }


}
