package com.cuiwei.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * created by cuiwei on 2018/8/10
 */
public class AboutArray {

    //类似于快速排序
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length - 1; i++) {
            int flag = array[i + 1];
            if (!isOdd(flag)) continue;//如果是偶数直接返回
            int j = i;
            while (j >= 0 && (!isOdd(array[j]))) {//如果是奇数，就把它移动到偶数前面
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = flag;
        }
    }

    public boolean isOdd(int val) {
        return (val & 1) == 1;
    }

    //借助一个新数组
    public void reOrderArray2(int[] array) {
        if (array == null || array.length == 0) return;
        int[] temp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (isOdd(array[i])) {
                temp[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (!isOdd(array[i])) {
                temp[index++] = array[i];
            }
        }
        System.arraycopy(temp, 0, array, 0, array.length);
    }

    //把数组排成最小的数,不用jdk排序
    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (isBigger(numbers[j], numbers[j + 1])) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            builder.append(numbers[i]);
        }
        return builder.toString();
    }

    private boolean isBigger(int num1, int num2) {
        long numC1 = Long.valueOf("" + num1 + num2);
        long numC2 = Long.valueOf("" + num2 + num1);
        System.out.println(num1 + "" + num2);
        return numC1 > numC2;
    }

    public String printMinNumber2(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i] + "";
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Long num1 = Long.valueOf(o1 + o2);
                Long num2 = Long.valueOf(o2 + o1);
                return (int) (num1 - num2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
        }
        return builder.toString();

    }

    //数组中重复的数字,用一个辅助数组
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0) {
            duplication[0] = -1;
            return false;
        }
        int[] help = new int[length];//添加一个辅助数组
        for (int i = 0; i < length; i++) {
            int temp = ++help[numbers[i]];
            if (temp > 0) {
                duplication[0] = help[i];
                return true;
            }
        }
        duplication[0] = -1;
        return false;
    }

    //数组中重复的数字，不用辅助数组
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0) {
            duplication[0] = -1;
            return false;
        }
        for (int i = 0; i < length; i++) {//因为数组中的值范围时0-n-1，因此如果没有重复值，每个位置有一个值
            while (numbers[i] != i) {
                int index = numbers[i];//将当前值作为索引
                if (numbers[i] == numbers[index]) {//如果当前值和索引所在值相等，则返回
                    duplication[0] = numbers[i];
                    return true;
                }
                //如果当前值和索引不相等，则交换值，直到相等为止
                int t = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = t;
            }
        }
        duplication[0] = -1;
        return false;
    }


    //二维数组中的查找,从左下角开始查找
    public boolean find(int target, int[][] array) {
        if (array == null || array.length == 0) return false;
        int rows = array.length, cols = array[0].length;
        int stCol = 0, stRow = array.length - 1;
        while (stRow >= 0 && stCol < cols) {
            int flag = array[stRow][stCol];
            if (target > flag) {//如果大于flag，则向右移动
                stCol++;
            } else if (target < flag) {//如果小于flag，则向上移动
                stRow--;
            } else {
                return true;
            }
        }
        return false;
    }

    //二分查找
    public int erFenSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int st = 0;
        int en = arr.length - 1;
        int mid;
        while (st <= en) {
            mid = (st + en) >> 1;
            if (target > arr[mid]) {
                st = mid + 1;
            } else if (target < arr[mid]) {
                en = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //数组中出现次数超过一半的数
    public int MoreThanHalf(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int temp = arr[0];//记录重复数字
        int times = 1;//记录重复个数
        for (int i = 1; i < arr.length; i++) {
            if (temp == arr[i]) {//如果下一个数字与当前数字一样
                times++;//重复次数加1
            } else {//如果不一样，重复次数减1
                times--;
            }
            if (times == 0) {//如果重复次数为0，
                temp = arr[i];//则以当前数字为重复数字进行统计
                times = 1;//初始次数为1
            }
        }
        times = 0;//重新统计最终temp的个数
        for (int i = 0; i < arr.length; i++) {
            if (temp == arr[i]) {
                times++;
            }
        }
        if (times > arr.length >> 1) {//如果超过数组大小的一半，则满足要求
            return temp;
        }
        return 0;
    }

    //数组中只出现一次的数字
    public void findNumbersAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
            num1[0] = 0;
            num2[0] = 0;
            return;
        }
        int bitResult = 0;//数组异或后的结果
        for (int i = 0; i < array.length; i++) {
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], index)) {//如果该数二进制的index位为1
                num1[0] ^= array[i];
            } else {//如果该数二进制的index位不为1
                num2[0] ^= array[i];
            }
        }
    }

    //寻找一个数的二进制位，第一个1的位置
    private int findFirst1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num >>= 1;
            index++;
        }
        return index;
    }

    //判断一个数的二进制，第index位是否为1
    public boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }

    //数组中的逆序对数
    public int inversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        return inversePairs(array, new int[array.length], 0, array.length - 1, 0);
    }

    public int inversePairs(int[] array, int[] tmp, int st, int en, int times) {
        int mid, leftTimes, rightTimes, timesCmp = 0;
        if (st < en) {
            mid = (st + en) >> 1;
            leftTimes = inversePairs(array, tmp, st, mid, times);
            rightTimes = inversePairs(array, tmp, mid + 1, en, times);
            timesCmp = merge(array, tmp, st, mid + 1, en, leftTimes + rightTimes);
        }
        return timesCmp;
    }

    private int merge(int[] array, int[] tmp, int lst, int rst, int ren, int times) {
        int len = rst - 1;
        int tmpSt = lst;
        int arrSt = lst;
        int numers = ren - lst + 1;

        while (lst <= len && rst <= ren) {
            if (array[lst] > array[rst]) {
                times += ren - rst + 1;
                if (times >= 1000000007) {
                    times %= 1000000007;
                }
                tmp[tmpSt++] = array[lst++];
            } else {
                tmp[tmpSt++] = array[rst++];
            }
        }

        while (lst <= len) {
            tmp[tmpSt++] = array[lst++];
        }
        while (rst <= ren) {
            tmp[tmpSt++] = array[rst++];
        }

        System.arraycopy(tmp, arrSt, array, arrSt, numers);
        return times;
    }


    //构建乘积数组
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return null;
        int[] B = new int[A.length];

        //计算前半部分的乘积
        int part1 = 1;
        for (int i = 0; i < A.length; i++) {
            B[i] = part1;
            part1 *= A[i];
        }
        //计算后半部分的乘积
        int part2 = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            B[i] *= part2;
            part2 *= A[i];
        }
        return B;
    }

    //连续数组的最大和,不用动态规划
    public int findGreatSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    //连续数组的最大和，动态规划
    public int findGreatSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0) return 0;
        int preGreat = array[0];
        int nowGreat;
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            nowGreat = Math.max(preGreat + array[i], array[i]);
            max = Math.max(nowGreat, max);
            preGreat = nowGreat;
        }
        return max;
    }

    //数字在排序数组中出现的次数
    public int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int index = erFenSearch(array, k);
        int st, en;
        if (index == -1) return 0;
        else {
            for (st = index; st >= 0; st--) {
                if (array[st] != k) break;
            }
            st++;
            for (en = index; en < array.length; en++) {
                if (array[en] != k) break;
            }
            en--;
        }
        return en - st + 1;
    }

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) return list;
        int st = 0;
        int en = array.length - 1;
        while (st < en) {
            int temSum = array[st] + array[en];
            if (temSum > sum) {
                en--;
            } else if (temSum < sum) {
                st++;
            } else {
                list.add(array[st]);
                list.add(array[en]);
                return list;
            }
        }
        return list;
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0
                || numbers.length > 13) return false;
//        int[] set = new int[13];
        int len = numbers.length;
        int min = 14;
        int max = 0;
        int flag = 0;//用bitmap的方式来去重
        for (int i = 0; i < len; i++) {
            int num = numbers[i];
            if (num == 0) continue;//0不参与判断
//            if (set[num] != 0) return false;//判断是否有重复
            if ((flag >> num & 1) == 1) return false;
            flag |= 1 << num;//第num位为1
            if (num < min) min = num;
            if (num > max) max = num;
            //如果最大值减去最小值大于等于数组长度，则肯定凑不了顺子
            if (max - min >= len) return false;
//            set[num]++;
        }
        return true;
    }

    public int findGreatest(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int temp = arr[0];
        int max = temp;
        for (int i = 1; i < arr.length; i++) {
            if (temp < 0) {
                temp = arr[i];
            } else {
                temp += arr[i];
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public int findGreatestDynamic(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    //找到数组中的数字，满足：该数字左边的数字都比它小，右边数字都比它大
    public static List<Integer> findMid(int[] arr) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        int n = arr.length;
        int[] rightMin = new int[n];
        int min = arr[n-1];
        int max = arr[0];
        for (int i = n-1; i >= 0; i--) {
            if (arr[i] < min) min = arr[i];
            rightMin[i] = min;
        }
        for (int i = 1; i < arr.length -1; i++) {
            if (arr[i] > max && arr[i] < rightMin[i+1]) {
                result.add(arr[i]);
            }
            if (arr[i] > max) max = arr[i];
        }
        return result;
    }


    public static void main(String[] args) {
//        int[][] arr = new int[][]{
//                {1, 2, 8, 9},
//                {2, 4, 9, 12},
//                {4, 7, 10, 13},
//                {6, 8, 11, 15}
//        };
//        System.out.println(new AboutArray().find(122, arr));
        int[] arr = new int[]{3, 2, 5, 1, 6, 7, 9, 8, 10};
//        int[] B = new AboutArray().multiply(arr);
//        System.out.println(Arrays.toString(B));
        System.out.println(Arrays.toString(findMid(arr).toArray()));
    }

}
