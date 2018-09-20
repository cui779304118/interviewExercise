package com.cuiwei.algorithm.test;

import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/9
 */
public class Baicizhan2 {


    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        //记录是否被访问
        boolean[] visited = new boolean[rows * cols];
        //路径的索引
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, pathLength, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                       int pathLength, char[] str, boolean[] visited) {
        if (pathLength == str.length) {
            return true;
        }
        int index = row * cols + col;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[index] == str[pathLength]
                && !visited[index]) {
            ++pathLength;
            visited[index] = true;
            //递归搜索上下左右的节点
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, pathLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, pathLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, pathLength, str, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, pathLength, str, visited);
            if (!hasPath){
                --pathLength;
                visited[index] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rows ; i++) {
            builder.append(sc.next());
        }
        String path = builder.toString();
        String word = sc.next();
        System.out.println(hasPath(path.toCharArray(),rows,cols,word.toCharArray()));
    }


}
