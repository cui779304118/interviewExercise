package com.cuiwei.algorithm.dp;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/7/27
 * 假设：
 *Knapsack Max weight : W = 10 (units)
 * Total items         : N = 4
 * Values of items     : v[] = {10, 40, 30, 50}
 * Weight of items     : w[] = {5, 4, 6, 3}
 * 递推公式为：（假设i为背包容量,p为最大总价值）
 * i = 0时，p(i) = 0;
 * i > 0时，p(i) = max{w(i - w[j]) + v[j]}
 */
public class BagProblem {
    public int maxPrice(int cap,int[] v,int[] w){
        int len = v.length;
        int[] tmpPrice = new int[cap+1];
        for (int i = 0; i <= cap ; i++) {
            if (i == 0){
                tmpPrice[i] = 0;
                continue;
            }
            int max = -1;
            for (int j = 0; j < len; j++) {
                int curPrice;
                if (i >= w[j] && (curPrice = tmpPrice[i - w[j]] + v[j]) > max ){
                    max = curPrice;
                }
            }
            tmpPrice[i] = max;
        }
        System.out.println(Arrays.toString(tmpPrice));
        return tmpPrice[cap];
    }

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

        for (int item=1;item<=N;item++){
            //Let's fill the values row by row
            for (int weight=1;weight<=W;weight++){
                //Is the current items weight less
                //than or equal to running weight
                if (wt[item-1]<=weight){
                    //Given a weight, check if the value of the current
                    //item + value of the item that we could afford
                    //with the remaining weight is greater than the value
                    //without the current item itself
                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                }
                else {
                    //If the current item's weight is more than the
                    //running weight, just carry forward the value
                    //without the current item
                    V[item][weight]=V[item-1][weight];
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

    public static void main(String[] args) {
        BagProblem bag = new BagProblem();
        int[] v = {10, 40, 30, 50};
        int[] w = {5, 4, 6, 3};
        System.out.println(bag.maxPrice(10,v,w));
        System.out.println(bag.knapsack(v,w,10));
    }

}
