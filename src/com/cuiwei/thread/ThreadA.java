package com.cuiwei.thread;

public class ThreadA extends Thread {
    private LockService service;

    public ThreadA(LockService service){
        super();
        this.service = service;
    }

    public void run(){
        service.awaitA();
    }
}
