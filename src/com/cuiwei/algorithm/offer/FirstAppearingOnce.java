package com.cuiwei.algorithm.offer;

public class FirstAppearingOnce {

	public static void main(String[] args) {
		String str = "google";
		System.out.println(firstAppearingOnce(str));
	}
	
	public static char firstAppearingOnce(String str){
		char [] charArray = str.toCharArray();
		int[] hashTable = new int[256];
		for(char c : charArray){
			if(hashTable[c] == 0){
				hashTable[c] = 1;
			}else{
				hashTable[c]++;
			}
		}
		 for(char c : charArray){
	            if(hashTable[c] == 1) return c;
        }
		return '#';
	}

}
