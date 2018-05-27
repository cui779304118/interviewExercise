package com.cuiwei.offer;

import java.util.ArrayList;
import java.util.List;

/*
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
*/

/*
思路1：
用两个数字begin和end分别表示序列的最小值和最大值，
首先将begin初始化为1，end初始化为2.
如果从begin到end的和大于s，我们就从序列中去掉较小的值(即增大begin),
相反，只需要增大end。
终止条件为：一直增加begin到(1+sum)/2并且end小于sum为止
*/

/*
思路2：
1）由于我们要找的是和为S的连续正数序列，因此这个序列是个公差为1的等差数列，而这个序列的中间值代表了平均值的大小。
假设序列长度为n，那么这个序列的中间值可以通过（S / n）得到，知道序列的中间值和长度，也就不难求出这段序列了。
2）满足条件的n分两种情况：
n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n.
3）由题可知n >= 2，那么n的最大值是多少呢？我们完全可以将n从2到S全部遍历一次，但是大部分遍历是不必要的。为了让n尽可能大，我们让序列从1开始，
根据等差数列的求和公式：S = (1 + n) * n / 2，得到.n<sqrt(2*S)
*/

public class FindContinuousSequence {
    public static void main(String[] args) {
        List<List<Integer>> resultList1 = FindContinuousSequence(100000);
        printResult(resultList1);
        List<List<Integer>> resultList2 = FindContinuousSequence2(100000);
        printResult(resultList2);
    }

    public static void printResult(List<List<Integer>> resultList){
        System.out.println("总共有： " + resultList.size());
        for(List<Integer> list : resultList){
            System.out.print("[ ");
            for(Integer num : list){
                System.out.print(num+" ");
            }

            System.out.print("]\n");
        }
    }

    public static List<List<Integer>> FindContinuousSequence(int sum){
        long st = System.currentTimeMillis();
        int begin = 1;
        int end = 2;
        int mid = (sum + 1) >> 1;
        int cur = begin + end;
        List<List<Integer>> resultList = new ArrayList<>();
        while(begin < mid){
            while(cur > sum){
                cur -= begin;
                begin++;
            }
            if (cur == sum){
                insert2List(begin,end,resultList);
            }
            end ++;
            cur += end;
        }
        System.out.println("思路1，耗时：" +(System.currentTimeMillis() - st)+ "毫秒");
        return resultList;
    }

    public static void insert2List(int begin, int end, List<List<Integer>> resultList){
        List<Integer> tempList = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            tempList.add(i);
        }
        if(tempList.size() > 1)
        resultList.add(tempList);
    }

    //第二种思路：(效率高)
    public static List<List<Integer>> FindContinuousSequence2(int sum){
        long begin = System.currentTimeMillis();
        List<List<Integer>> resultList = new ArrayList<>();
        int off =(int) Math.sqrt((double) 2*sum);
        for(int n=2;n<off;n++){
            if(((n&1) ==1 && sum%n ==0) || (sum%n)*2 == n){
                List<Integer> tempList = new ArrayList<>();
                for(int i=0,k=(sum/n)-(n-1)/2;i<n;i++,k++){
                    tempList.add(k);
                }
                resultList.add(tempList);
            }
        }
        System.out.println("思路2，耗时：" +(System.currentTimeMillis() - begin)+ "毫秒");
        return resultList;
    }
}
