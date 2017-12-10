package com.cuiwei.offer;

public class ReorderArray {

	public static void main(String[] args) {
		int [] array = new int []{1,2,3,4,5,6,7};
		new ReorderArray().reOrderArray1(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i] + " ");
		}
	}
	
	public void reOrderArray(int [] array){
		int len = array.length;
		for(int i=0;i<len-1;i++){
			if(array[i]%2!=0){
				continue;
			}
			for(int j=i+1;j<len;j++){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					if(array[i]%2!=0){
						break;
					}
			}
		}
	}
	
	public void reOrderArray1(int [] array){
		if(array == null || array.length == 0){
			return;
		}
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1;j++){
				if(array[j]%2==0&&array[j+1]%2!=0){
					int t = array[j];
					array[j] = array[j+1];
					array[j+1] = t;
				}
			}
		}
	}

}
