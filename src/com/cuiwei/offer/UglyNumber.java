package com.cuiwei.offer;

import java.util.Scanner;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int index=sc.nextInt();
		int result=new UglyNumber().GetUglyNumber_Solution(index);
		System.out.println("结果是： "+result);
		sc.close();

	}
	public int GetUglyNumber_Solution(int index) {
		  
		   if(index<=0)
		            return 0;
		        int[] result = new int[index];
		        int count = 0;
		        int i2 = 0;
		        int i3 = 0;
		        int i5 = 0;
		 
		        result[0] = 1;
		        int tmp = 0;
		        while (count < index-1) {
		            tmp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
		            if(tmp==result[i2] * 2) i2++;//三条if防止值是一样的，不要改成else的
		            if(tmp==result[i3] * 3) i3++;
		            if(tmp==result[i5]*5) i5++;
		            result[++count]=tmp;
		        }
		        return result[index - 1];
		    }
       private int min(int a, int b) {
         return (a > b) ? b : a;
    }
	

}
