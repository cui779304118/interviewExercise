package com.cuiwei.algorithm.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * created by cuiwei on 2018/9/9
 */
public class Jd2 {

    private static class Item implements Comparable<Item>{
        int a;
        int b;
        int c;
        public Item(int a,int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Item o) {
            return this.a - o.a;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Item> items = new ArrayList<Item>();
        for (int i = 0; i <n ; i++) {
            int a= sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            items.add(new Item(a,b,c));
        }
        System.out.println(fun(items));
    }

    public static int fun(List<Item> items){
        Collections.sort(items);
        int sum = 0;
        for (int i = 0; i < items.size() - 1; i++) {
            Item bef = items.get(i);
            for (int j = i+1; j < items.size() ; j++) {
                Item aft = items.get(j);
                if (aft.a > bef.a && aft.b > bef.b && aft.c > bef.c){
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }
}
