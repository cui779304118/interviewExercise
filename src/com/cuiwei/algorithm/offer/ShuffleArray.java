package com.cuiwei.algorithm.offer;

import com.cuiwei.algorithm.test.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * created by cuiwei on 2018/8/28
 * 打乱数组，并恢复
 */
public class ShuffleArray {

    private int[] oriArr;
    private int[] arr;
    private List<int[]> list = new ArrayList<>();
    public ShuffleArray(int[] arr){
        this.oriArr = arr;
        this.arr = new int[arr.length];
        System.arraycopy(oriArr,0,this.arr,0,arr.length);
        permutation(arr,0);
    }

    public int[] shuffe(){
        int total = list.size();
        int index = new Random().nextInt(total);
        return list.get(index);
    }
    private List<int[]> permutation(int[] arr, int index){
        if (index == arr.length){
            int[] arrCopy = new int[arr.length];
            System.arraycopy(arr,0,arrCopy,0,arr.length);
            list.add(arrCopy);
            return list;
        }
        for (int i = index; i < arr.length ; i++) {
            swap(arr,i,index);
            permutation(arr,index + 1);
            swap(arr,i,index);
        }
        return list;
    }

    private void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int[] reset(){
        System.arraycopy(oriArr,0,arr,0,oriArr.length);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ShuffleArray solution = new ShuffleArray(arr);
        System.out.println(Arrays.toString(solution.shuffe()));
        System.out.println(Arrays.toString(solution.reset()));
    }


}
