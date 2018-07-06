package com.cuiwei.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTestService {

    private int nextPrintThread = 1;
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void printA(){
        try{
            lock.lock();
            while (nextPrintThread != 1){
                conditionA.await();
            }
            for (int i = 0; i < 3 ; i++) {
                System.out.println(Thread.currentThread().getName() + " " + (i+1));
            }
            Thread.sleep(1000);
            nextPrintThread = 2;
            conditionB.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(){
        try{
            lock.lock();
            while (nextPrintThread != 2){
                conditionB.await();
            }
            for (int i = 0; i < 3 ; i++) {
                System.out.println(Thread.currentThread().getName() + " " + (i+1));
            }
            Thread.sleep(1000);
            nextPrintThread = 3;
            conditionC.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        try{
            lock.lock();
            while (nextPrintThread != 3){
                conditionC.await();
            }
            for (int i = 0; i < 3 ; i++) {
                System.out.println(Thread.currentThread().getName() + " " + (i+1));
            }
            Thread.sleep(1000);
            nextPrintThread = 1;
            conditionA.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
