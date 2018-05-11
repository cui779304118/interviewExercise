package com.cuiwei.thread;

public class RunA implements  Runnable {
    ConditionTestService service;

    public  RunA(ConditionTestService service){
        this.service = service;
    }

    @Override
    public void run() {
        while(true){
            service.printA();
        }
    }
}
