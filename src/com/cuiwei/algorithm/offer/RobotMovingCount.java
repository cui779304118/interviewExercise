package com.cuiwei.algorithm.offer;

import java.util.Stack;

/**
 * created by cuiwei on 2018/7/28
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 思路：
 * 和前面的题目类似，这个方格也可以看出一个m*n的矩阵。同样在这个矩阵中，除边界上的格子之外其他格子都有四个相邻的格子。
 * 机器人从坐标(0,0)开始移动。
 * 当它准备进入坐标为(i,j)的格子时，通过检查坐标的数位和来判断机器人是否能够进入。
 * 如果机器人能够进入坐标为(i,j)的格子，我们接着再判断它能否进入四个相邻的格子(i,j-1)、(i-1,j),(i,j+1)和(i+1,j)。
 */
public class RobotMovingCount {

    public static int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1) {
            return 0;
        }
        //存储某个节点是否被访问过，防止重复统计
        boolean[] visited = new boolean[rows * cols];
        return countCore(threshold, rows, cols, 0, 0, visited);
    }

    private static int countCore(int threshold, int rows, int cols,
                                 int row, int col, boolean[] visited) {
        //如果超过边界，直接返回
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        //如果不满足条件
        if (!check(threshold, row, col)) {
            return 0;
        }
        int index = row * cols + col;
        //如果已经被访问过
        if (visited[index]) {
            return 0;
        }
        visited[index] = true;

        //访问下一个位置
        return countCore(threshold, rows, cols, row + 1, col, visited)
                + countCore(threshold, rows, cols, row - 1, col, visited)
                + countCore(threshold, rows, cols, row, col + 1, visited)
                + countCore(threshold, rows, cols, row, col - 1, visited) + 1;
    }

    private static boolean check(int threshold, int row, int col) {
        return !(getSumOfPos(row) + getSumOfPos(col) > threshold);
    }

    private static int getSumOfPos(int pos) {
        int sum = 0;
        while (pos != 0) {
            sum += pos % 10;
            pos /= 10;
        }
        return sum;
    }

    public static int movingCount2(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1 || threshold < 0) {
            return 0;
        }
        //存储某个节点是否被访问过，防止重复统计
        boolean[] visited = new boolean[rows * cols];
        Stack<Integer> stack = new Stack<>();
        int[][] nextStep = new int[][]{{0, 1, 0, -1}, {1, 0, -1, 0}};
        int count = 0;
        stack.add(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            count++;
            for (int i = 0; i < 4; i++) {
                int x = cur / cols + nextStep[1][i];
                int y = cur % cols + nextStep[0][i];

                int index = x * cols + y;
                if (x >= 0 && x < rows && y >= 0 && y < cols && check(threshold, x, y) && !visited[index]) {
                    stack.add(index);
                    visited[index] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(getSumOfPos(35) + getSumOfPos(37));
        System.out.println(movingCount2(2, 3, 3));
    }

}
