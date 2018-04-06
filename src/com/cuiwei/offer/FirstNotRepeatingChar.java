package com.cuiwei.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {

	public static void main(String[] args) {
		String str = "abaccdeff";
//		System.out.println(str + "FirstNotRepeatingChar:" + fun(str) + ":" + str.charAt(fun(str)));
		String str1 = "We are Students";
		String str2 = "aeiou";
		System.out.println(removeStr2InStr1(str1,str2));
	}
	
	public static int fun(String str){
		if(null == str || str.isEmpty()){
			return -1;
		}
		int index = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] charArr = str.toCharArray();
		for(int i =0; i<charArr.length; i++){
			Character c = charArr[i];
			if(map.containsKey(c)){
				Integer times = map.get(c);
				map.put(c, ++times);
			}else{
				map.put(c, 1);
			}
		}
		for(int i =0; i<charArr.length; i++){
			Character c = charArr[i];
			if(1 == map.get(c)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static String removeStr2InStr1(String str1, String str2){
		if(str1 == null || str2 == null){
			return null;
		}
		int[] hash = new int[256];
		Arrays.fill(hash, 0);
		char[] ca1= str1.toCharArray();
		char[] ca2= str2.toCharArray();
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<ca2.length;i++){
			int index = ca2[i];
			hash[index] = 1;
		}
		System.out.println(Arrays.toString(hash));
		int size = ca1.length;
		for(int i=0; i<ca1.length;i++){
			if(hash[ca1[i]] == 1){
				int length = ca1.length - i -1;
				System.arraycopy(ca1, i+1, ca1, i, length);
				ca1[--size] = '\0';
			}
//			if(hash[ca1[i]] != 1){
//				builder.append(ca1[i]);
//			}
		}
//		return builder.toString();
		return new String(ca1);
	}
	
}
