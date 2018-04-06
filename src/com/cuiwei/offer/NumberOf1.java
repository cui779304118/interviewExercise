package com.cuiwei.offer;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author Lebron
 *
 */
public class NumberOf1 {
	public static void main(String[] args) {
		int num = 33;
//		System.out.println("【" + num + "】的二进制表示有：" + specialSolution(num) + "个1。" );
//		System.out.println("【" + num + "】是2的次幂吗？" + isPowerOf2(num));
//		testLeftNum(num);
		System.out.println(powerOf2(num));
		
	}
	
	public static int normalSolution(int num){
		int result = 0;
		int flag = 1;
		while(flag != 0 ){
			if((num & flag) != 0){
				result ++;
			}
			flag = flag << 1;
		}
		return result;
	}
	
	public static int specialSolution(int num){
		int result = 0;
		while(num !=0){
			result++;
			num = (num - 1) & num;
		}
		return result;
	}
	
	public static boolean isPowerOf2(int num){
		return (num & (num-1)) == 0;
	}
	
	public static void testLeftNum(int num){
		int n = 1;
		while(n <= 5){
			System.out.println("左移：【" + n +"】，" + (num << n));
			System.out.println("右移：【" + n +"】，" + (num >> n));
			n++;
		}
	}
	
	/**
	 * 求一个数离它最近的大于等于2的幂次方的数
	 * @return
	 */
	public static int powerOf2(int num){
		int n = num - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
	}
	
}
