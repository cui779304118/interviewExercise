package com.cuiwei.thread;

public class DBUitlMain {
    public static void main(String [] args){
        DBUtils dbUtils = new DBUtils();
        for(int i=0; i<10; i++){
            Thread ta = new Thread(new TaskA(dbUtils));
            Thread tb = new Thread(new TaskB(dbUtils));
            ta.start();
            tb.start();
        }
    }
}
