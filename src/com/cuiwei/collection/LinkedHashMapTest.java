package com.cuiwei.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("first","firstValue");
        linkedHashMap.put("second","secondValue");
        linkedHashMap.put("third","third");

        for(Iterator<Map.Entry<String,String>> it = linkedHashMap.entrySet().iterator();it.hasNext();){
            Map.Entry<String,String> entry = it.next();
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }
}
