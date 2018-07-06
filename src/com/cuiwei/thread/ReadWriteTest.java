package com.cuiwei.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest {

    private Map<String,String> cache = new HashMap<String, String>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public String getValue(String key){
        try{
            lock.readLock().lock();
            String value = cache.get(key);
            if(null == value){
                try{
                    lock.readLock().unlock();
                    lock.writeLock().lock();
                    if (null == value){
                        System.out.println("cache没有值，第一次放值");
//                        value = "***********";
                        cache.put(key, "***********");
                    }
                    value = cache.get(key);
                }finally {
                    lock.writeLock().unlock();
                    lock.readLock().lock();
                }
            }else {
                System.out.println("cache已经有值了！");
            }
            return value;
       }finally {
            lock.readLock().unlock();
        }
    }
}
