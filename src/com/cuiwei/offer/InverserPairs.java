package com.cuiwei.offer;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 考虑时间复杂度
 * 使用归并排序的改变法
 * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程。
还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
 * @author Lebron
 *
 */
public class InverserPairs {

	public static void main(String[] args) {
		int [] array = new int[]{1,2,3,4,5,6,7,0};
		int length = array.length;
		Integer times = 0;
		int timesCom = inversePairs(array, new int[length], 0,length -1 , times);
		System.out.println(Arrays.toString(array));
		System.out.println("times:" + timesCom);
	}
	
	public static int inversePairs(int[] array,int[] temp, int start, int end, int times){
		if(array.length == 0){
			return 0;
		}
		if(start == end){
			return times;
		}
		int center = (start + end)>>1;
		int timesLeft = inversePairs(array, temp, start, center, times)%1000000007;
		int timesRight = inversePairs(array, temp, center + 1, end, times)%1000000007;
		int timesCmp = merge(array,temp,start,center + 1,end,timesLeft+timesRight);
		return timesCmp;
	}
	
	public static int merge(int[] array, int[] temp, int start, int center, int end, int times){
		int lsta = start;
		int lend = center - 1;
		int rsta = center;
		int rend = end;
		int begin = start;
		int length = end - start + 1;
		while(lsta <= lend && rsta <= rend){
			if(array[lsta] > array[rsta]){
				times += rend - rsta + 1 ;
				temp[start++] = array[lsta++];
				if(times >= 1000000007){
					times%=1000000007;
				}
			}else{
				temp[start++] = array[rsta++];
			}
		}
		while(lsta <= lend){
			temp[start++] = array[lsta++];
		}
		while(rsta <= rend){
			temp[start++] = array[rsta++];
		}
 		System.arraycopy(temp, begin, array, begin, length);
 		return times;
	}

}
