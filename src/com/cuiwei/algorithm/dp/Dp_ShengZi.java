package com.cuiwei.algorithm.dp;

/**
 * created by cuiwei on 2018/8/22
 */
public class Dp_ShengZi {

    public static int cutRope(int length){
        if (length < 0){
            throw new IllegalArgumentException("Illegal number");
        }
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        //创建数组存储子问题最优解
        // 数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        int[] temp = new int[length + 1];

        //这些情况下，不剪的时候长度比剪的时候长，所以作为初始条件
        //这些都是子问题最优解,因为是子问题，所以这些情况可以不剪，因为可以看成它是分割后的一部分
        temp[0]=0;
        temp[1]=1;
        temp[2] =2;
        temp[3] =3;
        for (int i = 4; i <=length ; i++) {
            int max = 0;
            for (int j = 1; j <=i/2 ; j++) {//j<=i/2是为了防止重复计算
//                max = Math.max(max,temp[j]*temp[i-j]);
                int tem = temp[j]*temp[i-j];
                if (tem > max) max = tem;
            }
            temp[i] = max;
        }
        return temp[length];
    }

    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }

}
