package com.cuiwei.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionOnebyOneService {
    private  boolean hasValue = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public  void get(){
        try{
            lock.lock();
            while(hasValue == false){
                System.out.println(Thread.currentThread().getName() + "正在等待中。。。");
                condition.await();
            }
            System.out.println("*****");
            hasValue = false;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        try{
            lock.lock();
            while(hasValue == true){
                System.out.println(Thread.currentThread().getName() + "正在等待中。。。");
                condition.await();
            }
            System.out.println("@@@@@");
            hasValue = true;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
