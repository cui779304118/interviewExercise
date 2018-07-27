package com.cuiwei.algorithm.offer;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 举一反三：1.想出一种排序规则2.考虑大数问题
 * @author admin
 *
 */
public class PrintMinNumberFromArray {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int [] arr =  new int[]{3,32,321};
//		Integer [] arrI = new Integer[arr.length];
//		for(int i=0;i<arr.length; i++){
//			arrI[i] = arr[i];
//		}
//		Integer [] arrI2 =new Integer[]{3,32,321};
//		MethodTimeHandler handler = new MethodTimeHandler();
//		PrintMinNumberFromArray pmnfa = (PrintMinNumberFromArray)handler.getProxy(PrintMinNumberFromArray.class);
//		System.out.println(pmnfa.printMinNum2(arrI));
//		System.out.println(pmnfa.printMinNum(arrI2));
	}
	
	public String printMinNum(Integer[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		Comparator<Integer> comparator = new NumComparator();
		Arrays.sort(arr,comparator);
		System.out.println(Arrays.toString(arr));
		StringBuilder builder = new StringBuilder();
		for(Integer num : arr){
			builder.append(num);
		}
		return builder.toString();
	}
	
	public String printMinNum2(Integer[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		Comparator<Integer> comparator = new NumComparator();
		for(int i=0;i<arr.length - 1;i++){
			int j = i;
			int flag = arr[i+1];
			while(j>=0 && (comparator.compare(flag,arr[j])<0)){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = flag;
		}
		System.out.println(Arrays.toString(arr));
		StringBuilder builder = new StringBuilder();
		for(Integer num : arr){
			builder.append(num);
		}
		return builder.toString();
	}
}

/**
 * 自定义比较器
 * @author admin
 *
 */
class NumComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer num1, Integer num2) {
		String newNumStr1 = String.valueOf(num1) + String.valueOf(num2);
		String newNumStr2 = String.valueOf(num2) + String.valueOf(num1);
		if(newNumStr1.compareTo(newNumStr2) > 0 ){
			return 1;
		}else if(newNumStr1.compareTo(newNumStr2) < 0){
			return -1;
		}else{
			return 0;
		}
	}
	
}
