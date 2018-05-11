package com.cuiwei.thread;

public class ConditionOneThreadSet extends  Thread {
    ConditionOnebyOneService service;
    public ConditionOneThreadSet(ConditionOnebyOneService service){
        this.service = service;
    }

    public void run(){
        while (true){
            service.set();
        }
    }
}
