package com.cuiwei.algorithm.offer;

public class Triang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(triangle(100));

	}
	
	public static int triangle(int n){
		int temp=1;
		int sum=1;
		for(int i=2;i<=n;i++){
			temp+=i;
			sum+=temp;
		}
		return sum;
	}

}
