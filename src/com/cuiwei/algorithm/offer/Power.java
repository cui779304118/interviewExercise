package com.cuiwei.algorithm.offer;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base = 3;
		int exponent = 5;
		System.out.println(Power(base,exponent));

	}
	
	/**
	 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	 * 注：1、考虑全面，base为0,指数为0和负数的情况。
	 * 2、多用位运算来代替除以2和乘以2
	 * 3、可以用位运算来判断是奇数还是偶数
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double Power(double base, int exponent){
		int n=Math.abs(exponent);
		if(base == 0){
			return 0;
		}
		if(n == 0){
			return 1;
		}
		if(n == 1){
			return base;
		}
		double result = Power(base,n >> 1);
		result*=result;
		if((n & 0x1) ==1){
			result *=base;
		}
		if(exponent < 0){
			result = 1/result;
		}
		return result;
	}

}
