package com.cuiwei.offer;

import java.util.Scanner;

public class DoublePrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入k: ");
	int k=sc.nextInt();	
	int n=0;
	for(int i=2;i<10000;i++){
		if(isDoublePrime(i)){
			n++;
			if(n==k){
				System.out.println("第"+k+"个双素数是： "+i);
				break;
			}
		}
	}

	}
	
	public static boolean isPrime(int n){
		int i;
		for(i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				break;
			}
		}
		if(i<=Math.sqrt(n)){
			return false; 
		}
		return true;
	}
	
	public static boolean isDoublePrime(int n){
		if(isPrime(n)){
			String num=String.valueOf(n);
			char[] cnum=num.toCharArray();
			char t;
			int len=cnum.length;
			for(int i=0;i<Math.floor(len/2);i++){
				t=cnum[i];
				cnum[i]=cnum[len-1-i];
				cnum[len-1-i]=t;
			}
			String vnum=new String(cnum);
			int vn=Integer.parseInt(vnum);
			if(isPrime(vn)&&(vn!=n)){
				return true;
			}else{
				return false;
			}		
		}else{
			return false;
		}
		
	}

}
