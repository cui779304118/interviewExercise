package com.cuiwei.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int [] arr = new int[]{2,23,4,12,33,9,54,21};
		mergeSort(arr);
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 
	 * @param arr 
	 * @param temp
	 * @param le
	 * @param ce
	 * @param rig
	 */
	public static void  merge(int[] arr, int[] temp, int le, int ce, int rig){
		int leEnd = ce - 1;
		int tempSt = le;
		int num = rig - le + 1;
		int arrSt = le;
		while(le <= leEnd && ce <= rig){
			if(arr[le] < arr[ce]){
				temp[tempSt++] = arr[le++];
			}else{
				temp[tempSt++] = arr[ce++];
			}
		}
		while(le <= leEnd){
			temp[tempSt++] = arr[le++];
		}
		while(ce <= rig){
			temp[tempSt++] = arr[ce++];
		}
		System.arraycopy(temp, arrSt, arr, arrSt, num);
	}
	
	public static void mergeSort(int[] arr){
		mergeSort(arr,new int[arr.length], 0, arr.length -1);
	}
	
	public static void mergeSort(int[] arr, int[] temp, int left, int right){
		if(left < right){
			int center = (left + right)>>1;
			mergeSort(arr, temp, left, center);
			mergeSort(arr, temp, center +1, right);
			merge(arr, temp, left, center+1, right);
		}
	}
}
