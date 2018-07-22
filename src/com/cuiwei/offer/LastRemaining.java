package com.cuiwei.offer;

import java.util.LinkedList;

/**
 * created by cuiwei on 2018/7/12
 * n个数字（0,1,…,n-1）形成一个圆圈，
 * 从数字0开始，每次从这个圆圈中删除第m个数字（第一个为当前数字本身，
 * 第二个为当前数字的下一个数字）。当一个数字删除后，从被删除数字的下一个继续删除第m个数字。
 * 求出在这个圆圈中剩下的最后一个数字。
 */
public class LastRemaining {

    /**
     * 自己写的方法，时间复杂度高
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        if (n == 0 || m == 0) return -1;
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = i;
        }
        int length = nArr.length;
        int flag = -1;
        int sel = m - 1;
        int st;
        while (length > 1) {
            nArr[sel % n] = flag;
            length--;
            int num = 0;
            st = sel;
            while (num < m) {
                st++;
                st = st % n;
                if (nArr[st] == -1) continue;
                num++;
            }
            sel = st;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (nArr[i] != flag) {
                result = nArr[i];
            }
        }
        return result;
    }

    /**
     *
     * 找出规律：通项是：f(n,m)={f(n-1,m)+m}%n
     * http://zhedahht.blog.163.com/blog/static/2541117420072250322938/
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    /**
     * 用链表来模拟游戏过程
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining3(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int index = 0;
        int size = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        size = linkedList.size();
        while (size > 1) {
            linkedList.remove((index + m - 1) % size);
            index = (index + m - 1) % size;
            size--;
        }
        return linkedList.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining3(2, 3));
    }
}
