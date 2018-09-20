package com.cuiwei.algorithm.offer;

/**
 * created by cuiwei on 2018/7/15
 */

/**
 *
 */
public class WaKuang {

    /**
     * @param n 金矿数
     * @param w 工人数
     * @param g 每个金矿大小
     * @param p 每个金矿需要人数
     * @return
     */
    public static int waKuang(int n, int w, int[] g, int[] p) {
        int[] preResults = new int[w];
        int[] results = new int[w];
        for (int i = 0; i <w; i++) {
            if (i < p[0]) {
                preResults[i ] = 0;
            } else {
                preResults[i] = g[0];
            }
        }

        for (int i = 0; i < n; i++) {//遍历金矿
            for (int j = 1; j <w; j++) {//遍历人数
                if (j < p[i]){//如果当前人数小于当前金矿需要的人数
                    results[j] = preResults[j];
                }else{
                    results[j] = Math.max(preResults[j],preResults[j-p[i]] + g[i]);
                }
                preResults = results;
            }
        }
        return results[w-1];
    }

    public static void main(String[] args) {
        int[] p = new int[]{5,5,3,4,3};
        int[] g = new int[]{400,500,200,300,350};
        int n = waKuang(5,10,g,p);
        System.out.println(n);
    }
}
