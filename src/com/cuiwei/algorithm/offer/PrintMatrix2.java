package com.cuiwei.algorithm.offer;

import java.util.ArrayList;

public class PrintMatrix2 {

	public static void main(String[] args) {
		
		int[][] m={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		int[][] m={{1},{2},{3},{4},{5}};
		ArrayList<Integer> list=printMatrix(m);
		for(Integer i:list)
			System.out.print(i+" ");

	}
	public static ArrayList<Integer>  printMatrix(int [][] mt){
		ArrayList<Integer> list=new ArrayList<Integer>();
		int m=mt.length;
		int n=mt[0].length;
		int u=0;//up
		int l=0;//left
		int r=n-1;//right
		int d=m-1;//down
		
        while((r-l)>=1&&(d-u)>=1){
			
			for(int i=l;i<=r;i++)
				list.add(mt[u][i]);
			for(int i=u+1;i<=d;i++)
				list.add(mt[i][r]);
			for(int i=r-1;i>=l;i--)
				list.add(mt[d][i]);
			for(int i=d-1;i>=u+1;i--)
				list.add(mt[i][l]);
			r--;
			d--;
			u++;
			l++;
		}
		
//        if((r-l)==1&&(d-u)==1){
//        	list.add(mt[u][l]);
//        	list.add(mt[u][r]);
//        	list.add(mt[d][r]);
//        	list.add(mt[d][l]);	
//        }

        if((r-l)==0&&(d-u)>0){
        	for(int i=u;i<=d;i++)
					list.add(mt[i][r]);
        }
        if((r-l)>0&&(d-u)==0){
        	for(int i=l;i<=r;i++)
					list.add(mt[u][i]);
        }
        if((r-l)==0&&(d-u)==0){
        	list.add(mt[r][d]);
        }
		return list;
		
	}

}
