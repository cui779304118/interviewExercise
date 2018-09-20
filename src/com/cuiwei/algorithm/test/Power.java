package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/15
 */
public class Power {


    public static double power(double base, int n) {
        double res = 1, cur = base;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base < 0) {
                throw new RuntimeException("分母不能为0");
            }
            exponent = -n;
        } else {
            return 1;
        }

        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                res *= cur;
            }
            exponent >>= 1;
            cur *= cur;
        }
        return (n > 0) ? res : 1 / res;
    }


    public static double power2(double base,int n){
        if (n == 0) return 1.0;
        if (Math.abs(n) == 1){
            return base;
        }
        double temPow = power2(base,n/2);
        temPow *= temPow;
        if ((n & 1) == 1){
            temPow *= base;
        }
        if (n < 0){
            temPow = 1/temPow;
        }
        return temPow;
    }

    public static void main(String[] args) {
        System.out.println(power2(2.0, 3));
    }
}
