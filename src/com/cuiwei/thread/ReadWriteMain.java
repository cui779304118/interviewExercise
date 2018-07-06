package com.cuiwei.thread;

public class ReadWriteMain {
    public static void main(String[] args) {
        ReadWriteTest test = new ReadWriteTest();
        Runnable runnable = new ReadWriteRunnable(test);
        for(int i=0;i<10;i++){
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
