package com.cuiwei.thread;

public class ThreadB extends  Thread{
    private LockService service;

    public ThreadB(LockService service){
        super();
        this.service = service;
    }

    public void run(){
        service.awaitB();
    }

}
