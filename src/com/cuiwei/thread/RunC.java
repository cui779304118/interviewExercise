package com.cuiwei.thread;

public class RunC implements  Runnable {
    ConditionTestService service;

    public RunC(ConditionTestService service){
        this.service = service;
    }

    @Override
    public void run() {
        while(true){
            service.printC();
        }
    }
}
