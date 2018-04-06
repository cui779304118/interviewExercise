package com.cuiwei.sort;

import java.util.Arrays;

public class InsertSort {

//	public static void main(String[] args) {
//		int[] arr1 = new int[]{2,4,8,3,9,23,22,11,2,43,23123};
//		int[] arr2 = new int[]{2,4,8,3,9,23,22,11,2,43,23123};
//		insertSort(arr1);
//		shellSort(arr2);
//	}
//	
	public void insertSort(int[] arr){
		for(int i=0; i< arr.length - 1; i++){
			int value = arr[i + 1];
			int j = i;
			while(j>=0 && value < arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = value;
			System.out.println("第【"+(i+1)+"】排序后的数组： " + Arrays.toString(arr));
		}
	}
	public void shellSort(int[] arr){
		Long st = System.currentTimeMillis();
		int length = arr.length;
		int gap = length/2;
		int num = 1;
		while(gap>0){
			for(int i=0; i<length-gap;i++){
				int value = arr[i + gap];
				int j = i;
				while(j>=0 && value < arr[j]){
					arr[j + gap] = arr[j];
					j-=gap;
				}
				arr[j+gap] = value;
			}
			System.out.println("第【"+(num++)+"】排序后的数组： " + Arrays.toString(arr));
			gap/=2;
		}
	}
}
