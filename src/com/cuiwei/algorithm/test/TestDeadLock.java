package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/9/11
 */
public class TestDeadLock {
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            Thread t1 = new Thread(new SynAndRunnable(1,2));
            Thread t2 = new Thread(new SynAndRunnable(2,1));
            t1.start();
            t2.start();
        }
    }


    static class SynAndRunnable implements Runnable{
        int a;
        int b;
        public SynAndRunnable(int a,int b){
            this.a = a;
            this.b = b;
        }

        public void run(){
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }


}
