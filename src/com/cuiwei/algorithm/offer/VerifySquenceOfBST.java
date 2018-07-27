package com.cuiwei.algorithm.offer;

import org.junit.Test;

public class VerifySquenceOfBST {
	
	public boolean fun(int[] sequence){
		if(sequence.length==0)return false;
		return funHelp(sequence,0,sequence.length-1);
	}
	
	public boolean funHelp(int [] arr,int st,int en){

		int i;
		
		if(en<st){
			return true;
		}
		
		
		for(i=st;i<en;i++){
			if(arr[i]>arr[en]){
				break;
			}		
		}
		for(int j=i;j<en;j++){
			if(arr[j]<arr[en]){
				return false;
			}
		}
		return funHelp(arr,st,i-1)&&funHelp(arr,i,en-1);

	}
	@Test
	public void test(){
		int [] arr={7,4,3,9,8,6};
		System.out.println("�����Ƿ�Ϊĳ�����������ĺ�����������"+fun(arr));
	}

}
