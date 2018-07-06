package com.cuiwei.thread;

public class JoinTest {

    public static void main(String[] args) {
        try {
            JoinB b = new JoinB();
            JoinA a = new JoinA(b);

            Thread tb = new Thread(b);
            Thread ta = new Thread(a);

            ta.start();
            tb.start();
            tb.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end " + System.currentTimeMillis());

    }


}
