package com.cuiwei.algorithm.test;

import com.sun.scenario.effect.impl.prism.PrImage;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/6
 */
public class Meituan1 {

    private static int WHITE = 1;
    private static int GRAY = 1;
    private static int BLACK = 1;
    private static int NIL = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int[][] pic = new int[n][n];

        System.out.println(fun(pic, 0, n));
    }

    public static int fun(int[][] pic, int s, int n) {
        int[] color = new int[n];
        int[] d = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = WHITE;
            d[i] = 100;
            p[i] = NIL;
        }
        color[s] = GRAY;
        d[s] = 0;
        p[s] = NIL;

        int len = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(s);
        while (!queue.isEmpty()) {
            int u = queue.getFirst();
            len++;
            queue.poll();
            for (int i = 0; i < n; i++) {
                if (pic[u][i] == 1) {
                    if (color[i] == WHITE) {
                        color[i] = GRAY;
                        d[i] = d[u] + 1;
                        p[i] = u;
                        queue.add(i);
                    }
                }
                color[u] = BLACK;
            }
        }

        return len;
    }

    public static void set(int[][] pic, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int row = arr[i][0];
            int col = arr[i][1];
            pic[row][col] = 1;
        }
    }

}
