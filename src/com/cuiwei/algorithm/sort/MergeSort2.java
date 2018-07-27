package com.cuiwei.algorithm.sort;

import java.util.Arrays;

/**
 * created by cuiwei on 2018/7/22
 */
public class MergeSort2 {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        mergeSort(arr,new int[arr.length],0,arr.length -1 );
    }

    private void mergeSort(int[] arr,int [] tmp, int low, int hign) {
        if (hign > low){
            int mid = (low + hign) >>1;
            mergeSort(arr,tmp,low,mid);
            mergeSort(arr,tmp,mid+1,hign);
            merge(arr,tmp,low,mid+1,hign);
        }
    }

    private void merge(int[] arr,int[] tmp,int le,int ce,int ri){
        int leEnd = ce -1;
        int tmpP = le;
        int arrSt = tmpP;//数组起始索引
        int tmpNum = ri - le + 1;//本次merge的数量

        while(le <= leEnd && ce <= ri){
            if (arr[le] <= arr[ce]){
                tmp[tmpP++] = arr[le++];
            }else{
                tmp[tmpP++] = arr[ce++];
            }
        }

        while(le<=leEnd){
            tmp[tmpP++] = arr[le++];
        }
        while(ce<=ri){
            tmp[tmpP++] = arr[ce++];
        }

        System.arraycopy(tmp,arrSt,arr,arrSt,tmpNum);
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,23,4,12,33,9,54,21};
        System.out.println(Arrays.toString(arr));
        new MergeSort2().sort(arr);
        System.out.println(Arrays.toString(arr));
    }



}
