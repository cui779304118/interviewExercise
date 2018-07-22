package com.cuiwei.offer;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multipy {

    /**
     * 多利用了空间，多存储了，多遍历一次
     * @param A
     * @return
     */
    public static int[] multipy(int[] A) {
        if (A == null || A.length == 0) return null;
        int len = A.length;
        int [] B = new int[len];
        int [] part1 = new int[len];
        int [] part2= new int[len];
        part1[0] = 1;
        for (int i = 1; i <len ; i++) {
            part1[i] = part1[i-1]*A[i-1];
        }
        part2[len-1] = 1;
        for (int i = len-2; i >=0 ; i--) {
            part2[i] = part2[i+1]*A[i+1];
        }

        for (int i = 0; i < len; i++) {
            B[i]=part1[i]*part2[i];
        }
        return B;
    }

    /**
     * 节省空间和效率
     * B[i]的值可以看作下图的矩阵中每行的乘积。
     * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
     * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
     * @param A
     * @return
     */
    public static int [] multipy2(int [] A){
        if (A == null || A.length == 0) return null;
        int len = A.length;
        int [] B = new int[len];

        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i-1]*A[i-1];
        }
        int temp = 1;
        for (int i = len-2; i >=0 ; i--) {
            temp*=A[i+1];
            B[i]*=temp;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(multipy2(A)));
    }
}
