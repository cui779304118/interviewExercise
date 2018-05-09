package com.cuiwei.thread;

public class TaskB implements  Runnable {
    private  DBUtils dbUtils;
    public TaskB(DBUtils dbUtils){
        this.dbUtils = dbUtils;
    }
    public void run(){
            dbUtils.backupB();
    }
}
