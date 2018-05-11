package com.cuiwei.thread;

public class ReadWriteRunnable implements  Runnable {
    ReadWriteTest test;

    public ReadWriteRunnable(ReadWriteTest test){
        this.test = test;
    }

    @Override
    public void run() {
        String value = test.getValue("key");
        System.out.println(Thread.currentThread().getName() + "获取到value=" + value);
    }
}
