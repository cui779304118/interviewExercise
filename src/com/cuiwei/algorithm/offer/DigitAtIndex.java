package com.cuiwei.algorithm.offer;

public class DigitAtIndex {

	/**
	 * 数字以0123456789101112131415。。。的格式序列化到一个字符序列中，在这个序列中，地5位是5，第13位是1，19位是4，请写一个函数，
	 * 求任意第n位对应的数字。
	 * 思路：归纳法0-9：10个数字，10-99：90个数字（90*2=180位），100-999（900*3=2700位）。。。
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(digitAtIndex(1001));

	}
	public static int digitAtIndex(int num){
		int i=1;
		int counts = numOfInt(i);
		while(true){
			if(num < counts*i)break;
			num -= i*counts; 
			counts = numOfInt(++i);
		}
		if(i==1) return num;
		int temp = num/i;
		int index = num%i;
		int number = (int)Math.pow(10, i-1) + temp;
		String numStr = String.valueOf(number);
		char c = numStr.charAt(index);
		return (int) (c - '0');
	}
	//n位数字的个数
	public static int numOfInt(int n){
		if(n == 1){
			return 10;
		}
		int count = (int) Math.pow(10, n-1);
		return 9*count;
	}

}
