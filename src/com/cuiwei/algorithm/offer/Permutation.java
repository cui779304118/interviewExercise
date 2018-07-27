package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

	/**
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abc";
		List<String> list = permutation2(str);
		for(String s : list){
			System.out.println(s);
		}
	}
	public static ArrayList<String> permutation(String str){
		char [] charStr = str.toCharArray();
		int len = charStr.length;
		char [] tempChar = new char[len];
		ArrayList<String> list = new ArrayList<String>(len);
		recurision(list, tempChar, charStr, len, 0);
		return list;
	}
	
	public static void recurision(List<String> list, char[] tempChar, char[] charStr, int len, int index){
		if(index == len){
//			if(check(tempChar))
			list.add(new String(tempChar));
			return;
		}
		for(int i= 0; i < len; i++){
			tempChar[index] = charStr[i];
			recurision(list, tempChar, charStr, len, index + 1);
		}
	}
	
//	public static boolean check(char[] charArr){
//		HashSet<Character> set = new HashSet<>();
//		for(int i=0;i < charArr.length; i++){
//			set.add(charArr[i]);
//		}
//		if(set.size()==charArr.length){
//			return true;
//		}
//		return false;
//	}
	
	public static ArrayList<String> permutation2(String str){
		ArrayList<String> list = new ArrayList<String>();
		if(str == null || str.isEmpty()){
			return list;
		}
		char [] charStr = str.toCharArray();
		int len = charStr.length;
		permutationHelper(charStr, 0, len, list);
		Collections.sort(list);
		return list;
	}
	//排列算法
	public static void permutationHelper(char[] charArr, int index, int len, List<String> list){
		if(index == len){
			list.add(String.valueOf(charArr));
			return;
		}
		for(int i=index; i<len; i++){
			if(i!= index && charArr[i] == charArr[index])continue;
			swap(charArr,index,i);
			permutationHelper(charArr, index +1, len, list);
			swap(charArr,index,i);
		}
	}
	public static void swap(char[] charArr, int i, int j){
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
	}
}
