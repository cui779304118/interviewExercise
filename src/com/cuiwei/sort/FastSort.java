package com.cuiwei.sort;

public class FastSort {

	public static void main(String[] args) {
		int [] arr = new int[]{2,23,4,12,33,9,54,21};
		fastSort(arr,0,arr.length-1);
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
	
	public static int divide(int [] arr, int st, int en){
		int flag = arr[en];
		while(st < en){
			while(st < en && arr[st] <= flag)
				st++;
			if(st < en){
				int temp = arr[st];
				arr[st] = arr[en];
				arr[en] = temp;
				en -- ;
			}
			while(st < en && arr[en] > flag)
				en--;
			if(st < en){
				int temp = arr[st];
				arr[st] = arr[en];
				arr[en] = temp;
				st++;
			}
		}
		return en;
	}
	
	public static int partition(int [] arr, int st, int en){
		int flag = arr[st];
		while(st < en){
			for(;en>st;en --){
				if(arr[en] < flag){
					int temp = arr[en];
					arr[en] = arr[st];
					arr[st] = temp;
					st++;
					break;
				}
			}
			for(;st<en;st++){
				if(arr[st] > flag){
					int temp = arr[st];
					arr[st] = arr[en];
					arr[en] = temp;
					en--;
					break;
				}
			}
		}
		return st;
	}
	
	public static void fastSort(int[] arr, int st, int en){
		if(st > en){
			return;
		}else{
			int partition = partition(arr, st , en);
			fastSort(arr, st, partition -1);
			fastSort(arr, partition + 1, en);
		}
	}
	

}
