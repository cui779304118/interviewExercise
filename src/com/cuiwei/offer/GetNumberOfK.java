package com.cuiwei.offer;

public class GetNumberOfK {

    public static void main(String[] args) {
        int[] array = new int[]{3,3,3,3,4};
        GetNumberOfK getNumberOfK = new GetNumberOfK();
//        System.out.println(getNumberOfK.findIndexOfK(array,23));
        System.out.println(getNumberOfK.getNumberOfK2(array,3));
    }

    /**
     * 思路一：先找出该数，然后上下遍历
     * @param array
     * @param K
     * @return
     */
    public int getNumberOfK(int[] array, int K){
        if (null == array || array.length == 0 ){
            return 0;
        }
        int index = findIndexOfK(array,K);
        int number = 0;
        int flag = array[index];
        for (int i = index;i >= 0 && array[i] == flag;i--){
            number++;
        }
        for (int i = (index + 1);i < array.length && array[i] == flag; i++) {
            number++;
        }
        return number;
    }

    public int findIndexOfK(int[] array, double K){
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) >> 1;
        while(low <= high){
            if (array[mid] > K){
                high = mid - 1;
            }else if (array[mid] < K){
                low = mid + 1;
            }else{
                return mid;
            }
            mid = (low + high) >> 1;
        }
        return mid;
    }

    /**
     * 思路二：
     * //因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
     * //这两个数应该插入的位置，然后相减即可。
     * @param array
     * @param K
     * @return
     */
    public int getNumberOfK2(int[] array, int K){
        return findIndexOfK(array,K + 0.5) - findIndexOfK(array,K-0.5);
    }
}
