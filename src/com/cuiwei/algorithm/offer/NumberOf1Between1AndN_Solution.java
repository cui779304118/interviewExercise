package com.cuiwei.algorithm.offer;

/**
 * 求出1~13的整数中1出现的次数,
 * 并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN_Solution {

    public static void main(String[] args) {
        System.out.println(numberOf_1(11));
    }

    public static int numberOf1(int num){
        String numStr = String.valueOf(num);
        int n = numStr.length();//取得数字位数
        if (n == 1){
            return num == 0 ? 0 : 1;
        }
        int tim1 = (int) Math.pow(10,n-1);//当1在最高位时出现的次数

        int firstNum = Integer.valueOf(numStr.substring(0,1));
        int pown = (int) Math.pow(10,n-1);
        int maxFlag = pown * 2 -1;
        if (num < maxFlag){
            tim1 = num - pown + 1;
        }
        //当1在后几位时出现的次数，排列组合，后几位，每一位都可能为1，当该位为1时，其余几位，每一位都可以是0-9
        //因此公式为firstNum*(n-1)*10^(n-2)
        int tim2 = firstNum*(n-1)* (int) Math.pow(10,n-2);

        int nextNum = Integer.valueOf(numStr.substring(1));
        return tim1 + tim2 + numberOf1(nextNum);
    }

    public static int numberOf_1(int num){
        String numStr = String.valueOf(num);
        int n = numStr.length();
        int sum = 0;
        while(n > 1){
            int pow1 = (int) Math.pow(10,n-1);
            int tim1= num < 2*pow1 -1 ? num - pow1 + 1 : pow1;
            sum += tim1 + num/pow1*(n-1)*(int) Math.pow(10,n-2);
            n-=1;
            num = num%pow1;
        }
        sum += num == 0 ? 0 : 1;
        return sum;
    }

}
