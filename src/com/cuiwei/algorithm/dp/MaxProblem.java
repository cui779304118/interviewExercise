package com.cuiwei.algorithm.dp;

public class MaxProblem {


    /**
     * 将一个由N行数字组成的三角形，如图所以，设计一个算法，
     * 计算出三角形的由顶至底的一条路径，使该路径经过的数字总和最大。
     *
     * 假设上图用map[][]数组保存。
     * 令f[i][j]表示从顶点(1, 1)到顶点(i, j)的最大值。
     * 则可以得到状态转移方程：
     *
     * f[i][j] = max(f[i+1][j], f[i+1][j+1]) + map[i][j]
     *
     * 此题既适合自顶而下的方法做，也适合自底而上的方法，
     * 当用自顶而下的方法做时，最后要在在最后一列数中找出最大值，
     * 而用自底而上的方法做时，f[1][1]即为最大值。
     * @param map
     * @return
     */
    public static int max(int[][] map) {
        int n = map.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                map[i-1][j] += Math.max(map[i][j],map[i][j+1]);
            }
        }
        return map[0][0];
    }

    public static void main(String[] args) {
        int m =3;
        int[][] map = new int[m][m];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < i+1; j++) {
                map[i][j] = (i+1)*(j+1);
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(max(map));
    }
}
