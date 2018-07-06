package com.cuiwei.thread;

public class RunB implements  Runnable {
    ConditionTestService service;

    public RunB(ConditionTestService service){
        this.service = service;
    }

    @Override
    public void run() {
        while(true){
            service.printB();
        }
    }
}
