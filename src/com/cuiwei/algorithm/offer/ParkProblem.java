package com.cuiwei.algorithm.offer;

import java.util.HashSet;

/**
 * created by cuiwei on 2018/7/26
 */
/*
小明中午路过一家公共停车场，出于程序员的职业习惯，他很想知道这个停车场上午的最大化利用率有多少。
经与门卫大叔沟通，他获得了该停车场上午车辆入场时间与出场时间的记录表（数据格式参考样例输入），
你能通过拿到的数据写一个函数快速的帮小明算出这家停车场，上午最多的时候同时停放了多少辆车吗？
要求时间复杂度不高于：O(n)*lgN


注意事项：
1、为方便起见，简化计算，驶入时间和开出时间以整点记录，如9点，10点。
2、如停车记录中入场时间晚于出场时间，该停车记录视为无效，如7,3
3、假定如果有多辆车同时出入场，出场车辆优先。

样例输入：
8,9;4,6;3,7;6,8 （车辆以分号分隔，车辆入场和出场时间以逗号分隔）
样例输出：
2
*/
public class ParkProblem {
    public int[][] convert2Arr(String arrStr){
        if (arrStr == null){
            System.out.println("输入为空！");
            return null;
        }
        if (!arrStr.matches("(\\d{1,2},\\d{1,2};)*(\\d{1,2},\\d{1,2})")){
            System.out.println("输入格式错误");
            return null;
        }
        String [] strs = arrStr.split(";");
        HashSet<String> set = new HashSet<>();
        int[][] arrs = new int[strs.length][2];
        int start,end;
        for (int i = 0; i < strs.length; i++) {
            if (set.contains(strs[i])){
                continue;
            }
            set.add(strs[i]);
            String[] arr = strs[i].split(",");
            start = Integer.valueOf(arr[0]);
            end = Integer.valueOf(arr[1]);
            if (start > end) continue;
            arrs[i][0] = start;
            arrs[i][1] = end;
        }
        return arrs;
    }

    public int countCars(int[][] carArray){
        int ans = 0;
        int[] timeArr = new int[13];
        for (int i = 0; i < carArray.length ; i++) {
            int beginTime = carArray[i][0];
            int endTime = carArray[i][1];
            for (int j = beginTime; j < endTime ; j++) {
                timeArr[j]++;
            }
        }
        ans = timeArr[0];
        for (int i = 0; i < timeArr.length ; i++) {
            if (timeArr[i] > ans){
                ans = timeArr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String arrStr = "8,9;4,6;3,7;6,7;4,6";
        ParkProblem park = new ParkProblem();
        int[][] arrs = park.convert2Arr(arrStr);
        if (arrs == null)return;
        System.out.println(park.countCars(arrs));
    }
}
