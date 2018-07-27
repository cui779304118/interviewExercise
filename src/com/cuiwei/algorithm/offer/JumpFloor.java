package com.cuiwei.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

public class JumpFloor {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = jumpFloor3(10,new HashMap<>());
        System.out.println(n);

    }

    /**
     * 时间复杂度低，效率高
     *
     * @param n
     * @return
     */
    public static int jumpFloor(int n) {
        int one = 1;
        int two = 2;
        int three = 0;
        if (n <= 0) return 0;
        if (n == 1) return one;
        if (n == 2) return two;
        for (int i = 3; i <= n; i++) {
            three = one + two;
            one = two;
            two = three;
        }
        return three;
    }

    /**
     * 时间复杂度高
     *
     * @param n
     * @return
     */
    public static int jumpFloor2(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return jumpFloor2(n - 1) + jumpFloor2(n - 2);
    }

    public static int jumpFloor3(int n, Map<Integer, Integer> map) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = jumpFloor3(n - 1, map) + jumpFloor3(n - 2, map);
            map.put(n, value);
            return value;
        }
    }

}
