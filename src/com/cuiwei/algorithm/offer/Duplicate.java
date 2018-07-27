package com.cuiwei.algorithm.offer;


/**
 * created by cuiwei on 2018/7/20
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate {

    //时间复杂度O（n)，空间复杂度O(n)；
    public boolean duplicate(int numbers[],int length,int[] duplication){
        if (null == numbers || numbers.length ==0){
            duplication[0] = -1;
            return false;
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]=0;
        }
        for (int i = 0; i < length; i++) {
            int tmp = numbers[i];
            arr[tmp]++;
            if (arr[tmp]>1){
                duplication[0]=tmp;
                return true;
            }
        }
        duplication[0] = -1;
        return false;
    }

    /**
     * 时间复杂度为O(n),空间复杂度为O（1）
     * 此大法利用了哈希的特性，但不需要额外的存储空间。 因此时间复杂度为O(n)，不需要额外空间！
     * 把当前序列当成是一个下标和下标对应值是相同的数组；
     * 遍历数组，判断当前位的值和下标是否相等：
     * 2.1. 若相等，则遍历下一位；
     * 2.2. 若不等，则将当前位置i上的元素和a[i]位置上的元素比较：若它们相等，则成功！
     * 若不等，则将它们两交换。换完之后a[i]位置上的值和它的下标是对应的，但i位置上的元素和下标并不一定对应；
     * 重复2.2的操作，直到当前位置i的值也为i，将i向后移一位，再重复2.
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate2(int numbers[],int length,int[] duplication) {
        if (null == numbers || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        for (int i = 0; i < length ; i++) {
            while(numbers[i] != i){
                if (numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int s = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = s;
            }
        }
        duplication[0] = -1;
        return false;
    }

}