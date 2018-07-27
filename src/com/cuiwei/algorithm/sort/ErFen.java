package com.cuiwei.algorithm.sort;

public class ErFen {

	public static void main(String[] args) {
//		int [] arr = new int[]{1,2,3,4,5,6,7,45};
//		System.out.println(erfen(arr,45));
		System.out.println(fab2(8));
	}
	public static int erfen(int[] arr,int num){
		int st = 0;
		int en = arr.length - 1;
		while(st <= en){
			int mid = (st + en)>>1;
			if(num > arr[mid]){
				st = mid + 1;
			}else if(num < arr[mid]){
				en = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	public static int fab(int n){
		if(n==1){
			return 1;
		}
		if(n==2){
			return 1;
		}
		return fab(n-1) + fab(n-2);
	}
	
	public static int fab2(int n){
		int a = 1;
		int b = 1;
		int c = 0;
		if(n==1){
			return a;
		}
		if(n==2){
			return b;
		}
		for(int i=3;i<=n;i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	
}
