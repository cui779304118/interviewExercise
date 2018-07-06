package com.cuiwei.thread;

public class ThreadLocalExt extends  ThreadLocal {
    protected  Object initialValue(){
        return "first value";
    }
}
