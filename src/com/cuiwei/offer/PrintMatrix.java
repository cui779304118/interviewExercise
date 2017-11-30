package com.cuiwei.offer;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][] m={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	ArrayList<Integer> list=printMatrix(m);
	for(Integer i:list)
		System.out.print(i+" ");
	}
	
	public static ArrayList<Integer>  printMatrix(int [][] mt){
		ArrayList<Integer> list=new ArrayList<Integer>();
		int m=mt.length;
		int n=mt[0].length;
		int u=0;
		int j=1;
		
		while(m>2&&n>2){
			
			for(int i=u;i<n;i++)
				list.add(mt[0][i]);
			for(int i=j;i<m;i++)
				list.add(mt[i][n-1]);
			for(int i=n-2;i>=u;i--)
				list.add(mt[m-1][i]);
			for(int i=m-2;i>=j;i--)
				list.add(mt[i][0]);
			m--;
			n--;
			u++;
			j++;
		}
		
		if(m==2||n==2){
			for(int i=0;i<m;i++)
				for(int k=0;k<m;k++){
					list.add(mt[i][k]);
				}
		}
		
		return list;
		
		
		
	}

}
