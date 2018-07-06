package com.cuiwei.offer;

import java.util.Stack;

public class ReverseSentence {

	public static void main(String[] args) {
		String str = "student a am i";
		System.out.println(reverseSentence2(str));

	}
	
	//最简单方法
	public String reverseSentence(String str){
		if(str == null || str == "") return "";
		if(str.trim().equals("")) return str;
		String[] strArr = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = strArr.length - 1; i >= 0 ;i--){
			sb.append(strArr[i]);
			if(i != 0) sb.append(" ");
		}
		return sb.toString();
	}
	
	public static String reverseSentence2(String str){
		if(str == null || str == "") return "";
		if(str == " ") return " ";
		char[] charArray = str.toCharArray();
		Stack<String> result =new Stack<String>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i < charArray.length; i++){
			if(charArray[0] == ' ')continue;
			if(charArray[i] == ' '){
				result.push(sb.toString());
				sb = new StringBuilder();
				continue;
			}
			sb.append(charArray[i]);
		}
		result.push(sb.toString());
		StringBuilder resultSb = new StringBuilder();
		while(result.size() > 0){
			resultSb.append(result.pop());
			if(result.size() !=0 )
			resultSb.append(" ");
		}
		return resultSb.toString();
	}

}
