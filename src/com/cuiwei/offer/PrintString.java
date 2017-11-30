package com.cuiwei.offer;

import org.junit.Test;

public class PrintString {
	@Test
	public void test(){
		String str="abc\bef\bcd";
		//StringBuffer bufStr=new StringBuffer(str);
		System.out.println(changStr(str));
		//System.out.println(bufStr.deleteCharAt(6));
	}
	

	public String changStr(String str){
		char [] charStr=str.toCharArray();
		StringBuffer bufStr=new StringBuffer();
		
		for(int i=0;i<charStr.length;i++){
			if(charStr[i]=='\b'){
				bufStr.deleteCharAt(bufStr.length()-1);
			}else{
				bufStr.append(charStr[i]);
			}
		}
		return bufStr.toString();
	}
}
