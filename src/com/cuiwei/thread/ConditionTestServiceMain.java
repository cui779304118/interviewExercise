package com.cuiwei.thread;

public class ConditionTestServiceMain {

    public static void main(String[] args) {
        ConditionTestService service = new ConditionTestService();
        Thread ta = new Thread(new RunA(service));
        Thread tb = new Thread(new RunB(service));
        Thread tc = new Thread(new RunC(service));

        ta.start();
        tb.start();
        tc.start();
    }
}
