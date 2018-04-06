package com.cuiwei.sort;

public class InsertSortMain {

	public static void main(String[] args) {
		ProxyInsertSort proxyInsertSort = new ProxyInsertSort();
		InsertSort insertSort =(InsertSort) proxyInsertSort.createProxy(new InsertSort());
		int[] arr1 = new int[]{2,4,8,3,9,23,22,11,2,43,23123};
		int[] arr2 = new int[]{2,4,8,3,9,23,22,11,2,43,23123};
		insertSort.insertSort(arr1);
		insertSort.shellSort(arr2);
	}

}
