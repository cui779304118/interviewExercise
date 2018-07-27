package com.cuiwei.algorithm.offer;

import java.util.Arrays;

/**
 *LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,
 * 2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,
 * 看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
 * 为了方便起见,你可以认为大小王是0。
 *
 */
public class IsContinuous {
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        boolean flag = true;
        //对数组进行排序
        Arrays.sort(numbers);
        //统计0的数量
        int numOfZero = 0;
        //统计相邻数字之间大于1的差值
        int numOfDiff = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                numOfZero++;
                continue;
            }
            int diff = (numbers[i + 1] - numbers[i]);
            if (diff == 0) {
                flag = false;
                break;
            }
            numOfDiff += (diff - 1);
            //如果差值大于0的数量，差值即补不上
            if (numOfDiff > numOfZero) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //这种方法更效率，如果重复则为false，如果max-min<len即为真
    //max 记录 最大值
    //min 记录  最小值
    //min ,max 都不记0
    //满足条件 1 max - min <5
    //  2 除0外没有重复的数字(牌)
    //  3 数组长度 为5
    public static boolean isContinuous2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int len = numbers.length;
        int[] num = new int[14];
        int min = 0;
        for (int i = 0; i < len; i++) {
            if (numbers[i] != 0) {
                min = numbers[i];
                break;
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (numbers[i] == 0) continue;
            if (++num[numbers[i]] > 1) return false;
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
            if ((max - min) >= len) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 2, 5, 4};
        System.out.println("是否连续： " + isContinuous2(numbers));
    }
}
