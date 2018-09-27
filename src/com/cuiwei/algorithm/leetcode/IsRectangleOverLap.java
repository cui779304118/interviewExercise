package com.cuiwei.algorithm.leetcode;

/**
 * created by cuiwei on 2018/9/27
 * 矩形重叠
 * 题目：https://leetcode-cn.com/problems/rectangle-overlap/description/
 */
public class IsRectangleOverLap {

    public static boolean fun(int[] rec1,int[] rec2){
        if ((rec1[0] <= rec2[0] && rec1[2] <= rec2[0])
                || (rec2[0] <= rec1[0] && rec2[2] <= rec1[0]))
            return false;
        if ((rec1[1] <= rec2[1] && rec1[3] <= rec2[1])
                || (rec2[1] <= rec1[1] && rec2[3] <= rec1[0]))
            return false;
        if ((rec1[0] >= rec2[2] && rec1[2] >= rec2[2])
                || (rec2[0] >= rec1[2] && rec2[2] >= rec1[2]))
            return false;
        if ((rec1[1] >= rec2[3] && rec1[3] >= rec2[3])
                || (rec2[1] >= rec1[3] && rec2[3] >= rec1[3]))
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[] rec1 = new int[]{0,0,1,1};
        int[] rec2 = new int[]{1,0,2,1};
        System.out.println(fun(rec1,rec2));
    }

}
