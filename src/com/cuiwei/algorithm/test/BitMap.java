package com.cuiwei.algorithm.test;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/8/20
 */
public class BitMap {

    public static final int _1MB = 1024 * 1024;
    //每个byte记录8bit信息,也就是8个数是否存在于数组中
    public static final byte[] flags = new byte[512 * _1MB];

    public static void filter(int[] arr){
        int index = 0;
        for (int num : arr){
            if (!getFlags(num)){
                arr[index++] = num;
                setFlags(num);
                System.out.println("不重复的数字：" + num);
            }else {
                System.out.println("重复数字： " + num);
            }
        }
        Arrays.fill(arr,index,arr.length,0);
    }

    public static void setFlags(int num){
        //使用每个数的低三位作为byte内的映射
        //例如: 255 = 0x11111111
        //低三位(也就是num & (0x07))为0x111 = 7, 则byte的第7位为1, 表示255已存在
        flags[num >> 3] |= 0x1 << (num & 0x7);
    }

    //num>>3是找到该数在byte[]中的位置，然后用低三位来确定num在这个byte中的第几位
    public static boolean getFlags(int num){
        return (flags[num >> 3] >> (num & (0x7)) & 0x1 )== 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{23123,432143214,23123,12323,2323,2322,2323,232,4341,111123,232};
        System.out.println(Arrays.toString(arr));
        filter(arr);
        System.out.println(Arrays.toString(arr));
    }


}
