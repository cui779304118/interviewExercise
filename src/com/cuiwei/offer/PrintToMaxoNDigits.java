package com.cuiwei.offer;

import java.util.Arrays;

public class PrintToMaxoNDigits {

	public static void main(String[] args) {
		printToMaxNDigits2(2);

	}
	/**
	 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1,2,3一直到最大的3位数999.
	 * 注意不能直接打印
	 * @param n
	 */
	public static void printToMaxNDigits(int n){
		if(n <= 0){
			System.out.println("n必须为正整数，参数错误！");
			return;
		}
		char[] numChar = new char[n];
		Arrays.fill(numChar, '0');
		int tem = 0;
		while(!strAdd(numChar)){
			if(tem%20 == 0){
				tem = 0;
				System.out.println("\n");
			}
			printNum(numChar);
			tem++;
		}
	}
	
	//字符串的加法
	public static boolean strAdd(char[] numChar){
		boolean isOverFlow = false;
		int nTakeOver = 0;
		int len = numChar.length;
		for(int i = len - 1; i>=0; i--){
			int charNum = numChar[i] - '0' + nTakeOver;
			if(i == len-1){
				charNum ++;
			}
			if(charNum >= 10){
				if(i == 0){
					isOverFlow = true;
				}else{
					charNum -= 10;
					nTakeOver = 1;
					numChar[i] =(char) (charNum + '0');
				}
			}else{
				numChar[i] = (char) (charNum + '0');
				break;
			}
		}
		return isOverFlow;
	}
	//打印数字字符数组，高位为0不打印
	public static void printNum(char[] numChar){
		String numStr = new String(numChar);
		int index = 0;
		int nLength = numChar.length;
		for(int i =0; i<nLength; i++){
			if(numChar[i] != '0'){
				index = i;
				break;
			}
		}
		System.out.print(numStr.substring(index) + " ");
	}
	
	public static void printToMaxNDigits2(int n){
		if(n <= 0){
			System.out.println("n必须为正整数，参数错误！");
			return;
		}
		char[] numChar = new char[n];
		Arrays.fill(numChar, '0');
		for(int i=0; i<10; i++){
			numChar[0] = (char)(i + '0');
			printToMaxNDigitsRecursively(numChar, numChar.length, 0);
		}
		
	}
	
	//方法二：数字全排列递归法
	public static void printToMaxNDigitsRecursively(char[] numChar, int len, int index){
		if(index == len-1){
			printNum(numChar);
//			System.out.println(new String(numChar));
			return;
		}
		for(int i=0; i<10; i++){
			numChar[index + 1] = (char) (i + '0');
			printToMaxNDigitsRecursively(numChar, len, index + 1);
		}
	}
}
