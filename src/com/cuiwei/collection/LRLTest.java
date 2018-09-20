package com.cuiwei.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by cuiwei on 2018/8/17
 */
public class LRLTest {

    public static class LRU extends LinkedHashMap<String,String> {
        public LRU(int cap,float factor){
            super(cap,factor,true);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            if (size() > 6){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(16,0.75f);
        for (int i = 0; i < 6 ; i++) {
            lru.put("key" + i,"value" + i);
        }
        System.out.println(lru.toString());
        lru.put("key","value");
        System.out.println(lru.toString());
        lru.get("key2");
        System.out.println(lru.toString());
    }

}
