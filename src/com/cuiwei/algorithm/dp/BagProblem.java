package com.cuiwei.algorithm.dp;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/7/27
 * 假设：
 * Knapsack Max weight : W = 10 (units)
 * Total items         : N = 4
 * Values of items     : v[] = {10, 40, 30, 50}
 * Weight of items     : w[] = {5, 4, 6, 3}
 * 递推公式为：（假设i为背包容量,p为最大总价值）
 * i = 0时，p(i) = 0;
 * i > 0时，p(i) = max{w(i - w[j]) + v[j]}
 */
public class BagProblem {

    public int knapsack(int val[], int wt[], int W) {
        //Get the total number of items.
        //Could be wt.length or val.length. Doesn't matter
        int N = wt.length;

        //Create a matrix.
        //Items are in rows and weight at in columns +1 on each side
        int[][] V = new int[N + 1][W + 1];

        //What if the knapsack's capacity is 0 - Set
        //all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }

        //What if there are no items at home.
        //Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }

        for (int item = 1; item <= N; item++) {
            //Let's fill the values row by row
            for (int weight = 1; weight <= W; weight++) {
                //Is the current items weight less
                //than or equal to running weight
                if (wt[item - 1] <= weight) {
                    //Given a weight, check if the value of the current
                    //item + value of the item that we could afford
                    //with the remaining weight is greater than the value
                    //without the current item itself
                    V[item][weight] = Math.max(val[item - 1] + V[item - 1][weight - wt[item - 1]], V[item - 1][weight]);
                } else {
                    //If the current item's weight is more than the
                    //running weight, just carry forward the value
                    //without the current item
                    V[item][weight] = V[item - 1][weight];
                }
            }

        }

        //Printing the matrix
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }

        return V[N][W];
    }

    //p为每个金矿需要人数，g为每个金矿的金子数，n为总人数
    public int max_gold(int[] p, int[] g, int n) {
        if (p == null || g == null || n < 0) return 0;
        int[] last = new int[n + 1];
        int[] cur = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            last[i] = i >= p[0] ? g[0] : 0;
        }

        System.out.println(Arrays.toString(last));
        for (int i = 1; i < p.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= p[i]) {
                    cur[j] = Math.max(last[j], last[j - p[i]] + g[i]);
                } else {
                    cur[j] = last[j];
                }
            }
            last = cur;
            System.out.println(Arrays.toString(cur));
        }
        return cur[n];
    }

    public static void main(String[] args) {
        BagProblem bag = new BagProblem();
        int[] p = {5, 5,3, 4, 3};
        int[] g = {400,500, 200, 300, 350 };
        bag.max_gold(p, g, 10);
    }

}
