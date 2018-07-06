package com.cuiwei.thread;

public class P implements  Runnable{
    Object lock;
    public P(Object lock){
        this.lock = lock;
    }
    public void run(){
        try{
            while(true){
                synchronized (lock){
                    while ((MyList.myList.size()) > 4){
                        lock.wait();
                    }
                    for (int i=0; i<5; i++){
                        MyList.myList.add(i+1);
                        System.out.println(Thread.currentThread().getName() + "【生产者】向MyList添加元素：" + (i+1));
                    }
//                    System.out.println("队列中存入值了，【生产者】发出通知！");
                    lock.notifyAll();
             }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
