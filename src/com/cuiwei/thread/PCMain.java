package com.cuiwei.thread;

public class PCMain {
    public static  void main(String [] args){
        Object lock = new Object();
        P p = new P(lock);
        C c = new C(lock);
        Thread producer1 = new Thread(p);
        Thread producer2 = new Thread(p);
        Thread producer3 = new Thread(p);

        Thread consumer1 = new Thread(c);
        Thread consumer2 = new Thread(c);
        Thread consumer3 = new Thread(c);

        producer1.start();
        producer2.start();
        producer3.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
