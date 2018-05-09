package com.cuiwei.thread;

public class DBUtils {
    volatile  private boolean isExecuteA = false;

    public synchronized void  backupA(){
        try{
            while (isExecuteA == false){
                this.wait();
            }
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName() + "*****");
            }
            isExecuteA = false;
            this.notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized  void backupB(){
        try{
            while (isExecuteA == true){
                this.wait();
            }
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName() + "!!!!!");
            }
            isExecuteA = true;
            this.notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
