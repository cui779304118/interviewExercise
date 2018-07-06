package com.cuiwei.thread;

public class ThreadLocalTest {

    public static ThreadLocal threadLocalExt = new ThreadLocalExt();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "第一次从threadLocal获取的值：" + threadLocalExt.get() );
                threadLocalExt.set("this is value that I set");
                System.out.println(Thread.currentThread().getName() + "第二次从threadLocal获取的值：" + threadLocalExt.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if(threadLocalExt.get() == null){
                   threadLocalExt.set("我设置的值！");
                }
                System.out.println(Thread.currentThread().getName() + "从threadLocal获取到的值：" + threadLocalExt.get());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "从threadLocal获取到的值：" + threadLocalExt.get());
            }
        });
        t1.start();
        t2.start();
    }


}
