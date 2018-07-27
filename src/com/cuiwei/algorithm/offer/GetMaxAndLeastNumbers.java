package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 寻找数组最大的或最小的n个数。
 * @author Lebron
 *
 */
public class GetMaxAndLeastNumbers {

	public static void main(String[] args) {
		int [] arr = new int[]{1,3,2,8,4,9,0,7};
//		int [] result = getMaxNumbers(arr,8);
//		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(GetLeastNumbers_Solution(arr,8).toArray()));

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
		List resultList = Arrays.asList(arr);
		System.out.println(resultList);
		return result;
	}

	public static  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		List<Integer> resultList = null;
		if(null == input || input.length == 0){
			return null;
		}
		int n = partion(input,0,input.length - 1);
		while(n!=(k-1)){
			if(n<k){
				n = partion(input,n+1,input.length - 1);
			}
			if(n>k){
				n = partion(input,0,n-1);
			}
		}
		resultList = new ArrayList<>();
		for(int i=0; i<k; i++){
			resultList.add(input[i]);
		}
		return (ArrayList<Integer>)resultList;

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
