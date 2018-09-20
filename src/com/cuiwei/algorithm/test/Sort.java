package com.cuiwei.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cuiwei on 2018/8/22
 */
public class Sort {

    public static void heapSort(int[] arr){
        if (arr == null || arr.length ==0) return;
        int len = arr.length;
        for (int i = len/2 - 1; i >=0 ; i--) {
            adjustHeap(arr,i,len);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = len -1; i >0 ; i--) {
            swap(arr,i,0);
            adjustHeap(arr,0,i);
        }
    }

    private static void adjustHeap(int[] arr,int i,int len){
        int flag = arr[i];
        int cur = i;
        for (int j = 2*cur + 1; j < len ; j = 2*j+1) {
            if (j + 1 < len && arr[j] > arr[j+1]){
                j++;
            }
            if (flag > arr[j]){
                arr[cur] = arr[j];//交换较小元素和flag
                cur = j;//flag指向较小元素位置
            }else{
                break;
            }
        }
        arr[cur] = flag;
    }

    public static ArrayList<Integer> getKth(int[] arr, int k){
        ArrayList<Integer> result = new ArrayList<>(k);
        if (arr == null || arr.length ==0) return result;
        int[] temp = new int[k];
        System.arraycopy(arr,0,temp,0,k);
        for (int i = k/2 - 1; i >=0 ; i--) {
            adjustHeap(temp,i,k);
        }
        System.out.println(Arrays.toString(temp));
        for (int i = k; i < arr.length ; i++) {
            if (arr[i] > temp[0]){
                temp[0] = arr[i];
                adjustHeap(temp,0,k);
            }
        }
        for (int i = 0; i < k ; i++) {
            result.add(temp[i]);
        }
        return result;
    }

    public static ArrayList<Integer> getKth2(int[] arr,int k){
        ArrayList<Integer> result = new ArrayList<>(k);
        if (arr == null || arr.length ==0) return result;
        k = arr.length - k;
        int index = partion(arr,0,arr.length - 1);
        while(index != k){
            if (index < k){
                index = partion(arr,index + 1,arr.length - 1);
            }else{
                index = partion(arr,0,index - 1);
            }
        }
        for (int i = k; i < arr.length ; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    private static int partion(int[] arr,int st,int en){
        int flag = arr[st];
        while(st < en){
            while(st < en && arr[en] >= flag){
                en--;
            }
            if (st < en){
                swap(arr,st,en);
                st++;
            }
            while (st < en && arr[st] <= flag ){
                st++;
            }
            if (st < en){
                swap(arr,st,en);
                en--;
            }
        }
        return st;
    }



    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
        List<Integer> list = getKth2(arr,3);
        System.out.println(Arrays.toString(list.toArray()));
    }

}
