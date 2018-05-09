package com.cuiwei.thread;

public class C implements  Runnable{
    Object lock;
    public C(Object lock){
        this.lock = lock;
    }
    public void run(){
        try{
            while (true){
                synchronized (lock){
                    while(MyList.myList.size() == 0){
//                        System.out.println("队列中无值了，【消费者】发出通知");
                        lock.wait();
                    }
                    int length = MyList.myList.size();
                    System.out.println("队列中的元素： " + length + "个");
                    System.out.println(Thread.currentThread().getName() + "【消费者】从MyList获取到值：" + MyList.myList.get(0));
                    MyList.myList.remove(0);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


}
