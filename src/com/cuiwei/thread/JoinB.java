package com.cuiwei.thread;

public class JoinB implements  Runnable {

    @Override
    public synchronized  void run() {
        System.out.println("ThreadB start at " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadB end at " + System.currentTimeMillis());
    }
}
