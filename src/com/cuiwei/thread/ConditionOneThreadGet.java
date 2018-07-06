package com.cuiwei.thread;

public class ConditionOneThreadGet extends  Thread {
    ConditionOnebyOneService service;
    public ConditionOneThreadGet(ConditionOnebyOneService service){
        this.service = service;
    }

    public void run(){
        while (true){
            service.get();
        }
    }
}
