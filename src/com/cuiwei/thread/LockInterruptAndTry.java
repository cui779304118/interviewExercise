package com.cuiwei.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptAndTry {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod(){
        try {
            lock.lockInterruptibly();
            System.out.println("lock begin " + Thread.currentThread().getName());
            for (int i = 0; i < Integer.MAX_VALUE/10 ; i++) {
                String newString = new String();
                Math.random();
            }
            System.out.println("lock end " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public void tryLockTest(){
        try {
            if (lock.tryLock()){
                System.out.println(Thread.currentThread().getName() + "获得锁！");
            }else{
                System.out.println(Thread.currentThread().getName() + "没有获得锁！");
            }
        }finally {
            lock.unlock();//必须手动释放锁
        }
    }
}
