package com.cuiwei.algorithm.offer;

import org.junit.Test;

public class PrintMinNumber {
	
	@Test
	public void test(){
		int [] numbers = new int[]{3,32,321};
		printMinNumber(numbers);
	}
	
	public void printMinNumber(int [] numbers){
		String [] numberStr = new String[numbers.length];
		for(int i=0;i<numbers.length;i++){
			numberStr[i] = String.valueOf(numbers[i]);
		}
//		StringBuffer result = new StringBuffer();
		String temp;
		for(int i=0;i<numberStr.length-1;i++){
			for(int j=i+1;j<numberStr.length;j++){
				if(compare(numberStr[i],numberStr[j])>0){
					temp = numberStr[i];
					numberStr[i] = numberStr[j];
					numberStr[j] = temp;
				}
			}
			System.out.print(numberStr[i]);
		}
		System.out.print(numberStr[numberStr.length-1]);
		
	}
	
	private int compare(String a, String b){
		String temp1=a+b;
		String temp2=b+a;
		return temp1.compareTo(temp2);
	}
	
	

}
