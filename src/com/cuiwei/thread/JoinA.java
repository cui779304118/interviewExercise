package com.cuiwei.thread;

public class JoinA implements  Runnable {
    private  JoinB b;
    public JoinA(JoinB b){
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (b){
            System.out.println("ThreadA start at " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA end at " + System.currentTimeMillis());
        }
    }
}
