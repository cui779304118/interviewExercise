package com.cuiwei.thread;

public class LockConditionTest {
    public static void main(String[] args) {
        LockService service = new LockService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        ThreadC threadC = new ThreadC(service);

        threadA.start();
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadC.start();
    }

}
