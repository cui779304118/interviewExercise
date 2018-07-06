package com.cuiwei.thread;

public class TaskA implements  Runnable{
    private  DBUtils dbUtils;
    public TaskA(DBUtils dbUtils){
        this.dbUtils = dbUtils;
    }
    public void run(){
            dbUtils.backupA();
    }
}
