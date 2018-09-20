package com.cuiwei.algorithm.test;


import java.util.*;

public class BeiKeTest2 {
    public static void cancel(int n,int[][] arr){
        int[] times = new int[n];
        for (int i = 0; i <n ; i++) {
            int tempSt = arr[i][0];
            int tempEn = arr[i][1];
            for (int j = 0; j < i ; j++) {
                if (arr[j][0] < tempEn ||arr[j][1] > tempSt){
                    times[i]++;
                }
            }
            for (int j = i+1; j < n; j++) {
                if (arr[j][0] < tempEn ||arr[j][1] > tempSt){
                    times[i]++;
                }
            }
        }
        int n1 = 0;
        int n2 = 0;
        int max = times[0];
        int maxIndex = 0;
        for (int i = 0; i <n ; i++) {
            if (times[i] == 1){
                n1++;
            }
            if (times[i] > 1){
                n2++;
            }
            if (times[i] > max){
                max = times[i];
                maxIndex = i;
            }
        }
        if (n1 == n2 && n1 ==0) {
            System.out.println(n);
            for (int i = 0; i < n; i++) {
                System.out.print((i+1) + " ");
            }
            return;
        }
        if (n2 > 2) {
            System.out.println(0);
            return;
        }
        if ( max > 1){
            System.out.println(1);
            System.out.println(maxIndex);
            return;
        }
        for (int i = 0; i <n ; i++) {
            System.out.println(n1);
            if (times[i] == 1){
                System.out.print((i+1) + " ");
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] arr= new int[n][2];
//        for (int i = 0; i <n ; i++) {
//            arr[i][0] = sc.nextInt();
//            arr[i][1] = sc.nextInt();
//        }
//        cancel(n,arr);
//    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[][]times=new int[n][3];
        for(int i=0;i<n;i++){
            times[i][0]=scan.nextInt();
            times[i][1]=scan.nextInt();
            times[i][2]=i+1;
        }
        Arrays.sort(times,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return (a[1]==b[1])?a[0]-b[0]:a[1]-b[1];
            }
        });
        boolean tag=false;
        int[]count=new int[n];
        int index=0;
        int num=0;
        for(int i=1;i<n;i++)
            for(int j=i-1;j>=0;j--){
                if(times[i][0]<times[j][1]){
                    count[i]++;
                    count[j]++;
                    num+=2;
                    if(count[j]>1){
                        tag=true;
                        index=j;
                    }
                    if(count[i]>1){
                        tag=true;
                        index=i;
                    }
                }else
                    break;
            }
        if(tag){
            int k=0;
            for(int i=0;i<n;i++){
                if(count[i]>1){
                    k++;
                }
                if(k>1){
                    System.out.println(0);
                    break;
                }
            }
            if(k<=1){
                System.out.println(1);
                System.out.println(times[index][2]);
            }

        }else{
            if(num==0){
                System.out.println(n);
                for(int i=0;i<n-1;i++)
                    System.out.print(i+1+" ");
                System.out.println(n);
            }
            else{
                System.out.println(num);
                List<Integer> list=new ArrayList();

                for(int i=0;i<n;i++){
                    if(count[i]==1){
                        list.add(times[i][2]);
                    }
                    //System.out.print(times[i][2]+" ");
                }
                Collections.sort(list);
                for(int i:list)
                    System.out.print(i+" ");
            }
        }

    }



}
