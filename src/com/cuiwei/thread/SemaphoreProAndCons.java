package com.cuiwei.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Semaphore实现多生产者、多消费者模式
 * 本实验的目的不光是实现生产者与消费者模式，还要限制生产者与消费者的数量（通过Semaphore来限制），
 * 这样代码的复杂性就提高一些
 */
public class SemaphoreProAndCons {
    public static void main(String[] args) throws InterruptedException {
        ProAndConService service = new ProAndConService(10,20,4);
        PThread[] arrP = new PThread[60];
        CThread[] arrC = new CThread[60];

        for (int i = 0; i < 60 ; i++) {
            arrP[i] = new PThread(service);
            arrC[i] = new CThread(service);
        }
        Thread.sleep(2000);
        for (int i = 0; i < 60 ; i++) {
            arrP[i].start();
            arrC[i].start();
        }
    }
}

class ProAndConService{
    private final int proNum;
    private final int conNum;
    private final int containerNum;

    private final Semaphore proSemaphore;
    private final Semaphore conSemaphore;

    private Object[] container;
    private Lock lock = new ReentrantLock();
    private Condition proCondition = lock.newCondition();
    private Condition conCondition = lock.newCondition();

    public ProAndConService(int proNum,int conNum,int containerNum){
        this.proNum = proNum;
        this.conNum = conNum;
        this.proSemaphore = new Semaphore(proNum);
        this.conSemaphore = new Semaphore(conNum);
        this.containerNum = containerNum;
        this.container = new Object[containerNum];
    }

    public boolean isEmpty(){
        boolean flag = true;
        for (Object o : container){
            if (o != null){
                flag = false;
            }
        }
        return flag;
    }

    public boolean isFull(){
        boolean flag = true;
        for (Object o : container){
            if (o == null){
                flag = false;
            }
        }
        return flag;
    }

    public void produce(Object data){
        try {
            proSemaphore.acquire();
            lock.lock();
            while (isFull()){
//                System.out.println("container is full...");
                proCondition.await();
            }
            for (int i = 0; i < container.length; i++) {
                if (container[i] == null){
                    container[i] = data;
                    System.out.println(Thread.currentThread().getName() + " produce = " + data.toString());
                    break;
                }
            }
            conCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            proSemaphore.release();
        }
    }

    public Object consume(){
        Object data = null;
        try {
            conSemaphore.acquire();
            lock.lock();
            while (isEmpty()){
//                System.out.println("container is empty...");
                conCondition.await();
            }
            for (int i = 0; i < container.length; i++) {

                if(container[i] != null){
                    data = container[i];
                    System.out.println(Thread.currentThread().getName() + " consume data = " + data.toString());
                    container[i] = null;
                    break;
                }
            }
            proCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            conSemaphore.release();
        }
        return data;
    }

}

class PThread extends Thread{
    ProAndConService service;
    public PThread(ProAndConService service){
        this.service = service;
    }

    @Override
    public void run() {
        Integer data = new Random().nextInt(20);
        service.produce(data);
    }
}

class CThread extends Thread{
    ProAndConService service;
    public CThread(ProAndConService service){
        this.service = service;
    }

    @Override
    public void run() {
        service.consume();
    }
}
