package com.cuiwei.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {

    //将滑动窗看做一个队列，每次队首出列，然后数组下一个数进队
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> results = new ArrayList<>();
        if (num == null || num.length == 0
                || size <= 0 || size > num.length) return results;
        int[] queue = new int[size];
        int max = num[0];
        for (int i = 0; i < num.length; i++) {
            if (i < size) {
                queue[i] = num[i];
                if (queue[i] > max) {
                    max = queue[i];
                }
            } else {
                results.add(max);
                max = num[i];
                //队首出队，下一个元素入队
                for (int j = 0; j < size - 1; j++) {
                    if (queue[j+1] > max ) max = queue[j+1];
                    queue[j] = queue[j + 1];
                }
                queue[size - 1] = num[i];
            }
        }
        results.add(max);
        return results;
    }

    /*时间复杂度o（n），空间复杂度为o（n）
          思路就是采用双端队列，队列中的头节点保存的数据比后面的要大。
      比如当前假如的数据比队尾的数字大，说明当前这个数字最起码在从现在起到后面的过程中可能是最大值
      ，而之前队尾的数字不可能最大了，所以要删除队尾元素。
      此外，还要判断队头的元素是否超过size长度，由于存储的是下标，所以可以计算得到；
      特别说明，我们在双端队列中保存的数字是传入的向量的下标；*/
    public static ArrayList<Integer> maxInWindows2(int[] num,int size){
        ArrayList<Integer> results = new ArrayList<>();
        if (num == null || num.length == 0
                || size <= 0 || size > num.length) return results;
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while(!deque.isEmpty() && num[i] > num[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }

        for (int i = size ; i < num.length ; i++) {
            results.add(deque.peekFirst());
            while(!deque.isEmpty() && num[i] > num[deque.peekLast()]){
                deque.pollLast();
            }
            while(!deque.isEmpty() && deque.peekFirst() < (i - size - 1)){
                deque.pollFirst();
            }
            deque.addLast(i);
        }
        results.add(deque.peekFirst());
        return results;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        List<Integer> list = maxInWindows2(arr, 3);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
