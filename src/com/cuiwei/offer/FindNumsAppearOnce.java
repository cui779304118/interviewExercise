package com.cuiwei.offer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author Lebron
 *
 */
public class FindNumsAppearOnce {

	public static void main(String[] args) {
		int[] array = new int[]{2,4,3,6,3,2};
		int[] num1 = new int[]{0};
		int[] num2 = new int[]{0};
		findNumsAppearOnce2(array, num1, num2);
		System.out.println("["+ num1[0] +"," + num2[0]+ "]");
	}
	//使用set的方法。（可以实现但是不是最优）
	public static void findNumsAppearOnce(int[] array, int num1[], int num2[]){
		if(array.length == 0){
			num1[0] = 0;
			num2[0] = 0;
			return;
		}
		Set<Integer> set = new HashSet<>();
		for(int i = 0;i<array.length;i++){
			if(!set.contains(array[i])){
				set.add(array[i]);
			}else{
				set.remove(array[i]);
			}
		}
		if(set.size()<2){
			num1[0] = 0;
			num2[0] = 0;
			return;
		}
		Iterator<Integer> it = set.iterator();
		if(it.hasNext()){
			num1[0] = it.next();
		}
		if(it.hasNext()){
			num2[0] = it.next();
		}
	}
	/*
	 * 使用异或实现
	 * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
	 * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
	 * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。
	 * 我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
	 * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
	 * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
	 * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
	 */
	public static void findNumsAppearOnce2(int[] array, int num1[], int num2[]){
		num1[0] = 0;
		num2[0] = 0;
		if(array.length == 0){
			return;
		}
		int num = 0;
		for(int i=0;i<array.length;i++){
			num^=array[i];
		}
		int firstDiff = findFirstDiff(num);
		for(int i=0;i<array.length;i++){
			if((array[i] & (1<<firstDiff)) != 0){
				num1[0]^=array[i];
			}else{
				num2[0]^=array[i];
			}
		}
	}
	private static int findFirstDiff(int num) {
		int count = 0;
		for(;count < 32;count ++){
			if((num & (1<<count)) != 0)break;
		}
		return count;
	}

}
