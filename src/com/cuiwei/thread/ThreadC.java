package com.cuiwei.thread;

public class ThreadC extends  Thread {
    private LockService service;

    public ThreadC(LockService service){
        super();
        this.service = service;
    }

    public void run(){
        service.signalA();
    }
}
