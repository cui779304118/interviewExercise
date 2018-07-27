package com.cuiwei.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * created by cuiwei on 2018/7/7
 * 测试CyclicBarrier,与CountDownLautch的区别是，CycliBarrier是加法，而且可以置零，循环使用
 * CountDownLautch是减法，不能置零，常用于关闭线程池。
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cy = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("都到了！");
            }
        });
        MyService service = new MyService(cy);

        for (int i = 0; i < 4 ; i++) {
            Thread thread = new ThreadT(service);
            thread.setName("PLAYER_" + i );
            thread.start();
        }

        Thread.sleep(5000);
        System.out.println("屏障对象的parties个数为：" +  cy.getParties());
        System.out.println("在屏障处等待的线程个数为：" + cy.getNumberWaiting());
        cy.reset();
    }
}

class MyService{
    private CyclicBarrier cy;

    public MyService(CyclicBarrier cy){
        this.cy = cy;
    }

    public void beginRun(){
        try {
            long sleepValue = (int)(Math.random()*1000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() +
            " begin 跑第1个阶段 " + (cy.getNumberWaiting() + 1));
            cy.await();
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() +
            " end 跑第1个阶段 " + (cy.getNumberWaiting()));
            sleepValue = (int)(Math.random()*1000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() +
                    " begin 跑第2个阶段 " + (cy.getNumberWaiting() + 1));
            cy.await();
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() +
                    " end 跑第2个阶段 " + (cy.getNumberWaiting()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void beginRun(int count){
        try {
            System.out.println(Thread.currentThread().getName() + " 到了 在等待其他人都到了开始起跑第 " + count + "赛段");
            if (Thread.currentThread().getName().equals("PLAYER_2")){
                System.out.println("PLAYER_2 进来了");
                Thread.sleep(Integer.MAX_VALUE);
//                Integer.parseInt("a");
//                Thread.currentThread().interrupt();
            }
            cy.await();
            System.out.println(" 都到了， 开始跑 ！");
            System.out.println(Thread.currentThread().getName() + " 到达终点，并结束第" + count + "赛段");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class ThreadT extends Thread{
    MyService myService;

    public ThreadT(MyService myService){
        this.myService = myService;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            myService.beginRun(i + 1);
        }
    }
}
