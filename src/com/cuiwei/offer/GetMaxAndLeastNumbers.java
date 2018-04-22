package com.cuiwei.offer;

import java.util.Arrays;

/**
 * 寻找数组最大的或最小的n个数。
 * @author Lebron
 *
 */
public class GetMaxAndLeastNumbers {

	public static void main(String[] args) {
		int [] arr = new int[]{1,3,2,8,4,9,0,7};
		int [] result = getMaxNumbers(arr,5);
		System.out.println(Arrays.toString(result));

	}
	//寻找最大的n个数。
	public static int[] getMaxNumbers(int[] arr, int n){
		if(arr == null || arr.length < n || n <= 0){
			return null;
		}
		int[] result = new int[n];
		int st = 0;
		int en = arr.length -1;
		int m = arr.length - n-1;//标志点位于这个位置时，右边有n个数比它大。
		int k = partion(arr, st, en);//标志点的位置
		while(k != m){
			if(k > m ){
				k = partion(arr, st, k - 1);
			}else{
				k = partion(arr, k + 1, en);
			}
		}
		System.arraycopy(arr, k+1, result, 0, n);
		return result;
	}
	//分区：左边比该数小，右边都比该数大
	public static int partion(int[] arr, int st, int en){
		int flag = arr[st];
		while(st < en){
			while(st < en && arr[en] > flag) en--;
			if(st < en){
				swap(arr,st,en);
				st ++;
			}
			while(st < en && arr[st] < flag) st ++;
			if(st < en){
				swap(arr,st,en);
				en --;
			}
		}
		return en;
	}
	
	public static void swap(int[] arr, int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
