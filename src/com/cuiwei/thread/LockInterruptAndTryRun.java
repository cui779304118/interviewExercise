package com.cuiwei.thread;

public class LockInterruptAndTryRun {
    public static void main(String[] args) {
        LockInterruptAndTry service = new LockInterruptAndTry();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.tryLockTest();
            }
        };
        Thread ta = new Thread(runnable);
        ta.setName("A");
        Thread tb = new Thread(runnable);
        tb.setName("B");

        ta.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tb.start();
        System.out.println("main end");
    }
}
