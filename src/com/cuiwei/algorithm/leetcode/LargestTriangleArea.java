package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/19
 * 最大三角形面积
 * 题目：https://leetcode-cn.com/problems/largest-triangle-area/description/
 * 解答：https://blog.csdn.net/zhangzhetaojj/article/details/80724866
 *
 */
public class LargestTriangleArea {

    public static double fun(int[][] points){
        double area = 0;
        for(int[] a : points){
            for(int[] b : points){
                for (int[] c:points){
                    area = Math.max(area,0.5*Math.abs(a[0]*b[1] +b[0]*c[1] + c[0]*a[1]
                    - a[0]*c[1] -b[0]*a[1]-c[0]*b[1]));
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] area = new int[][]{
                {0,0},{0,1},{1,0},{0,2},{2,0}
        };
        System.out.println(fun(area));
    }

}
