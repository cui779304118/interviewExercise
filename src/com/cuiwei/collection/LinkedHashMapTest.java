package com.cuiwei.collection;

import com.sun.javafx.image.IntPixelGetter;

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
        //测试自动装箱和自动拆箱
        Integer i = 100;
        Integer j = 100;
        System.out.println(i==j);
        Integer ii = 200;
        Integer jj = 200;
        System.out.println(ii==jj);
        Integer a = 2;
        Integer b = 3;
        Long c = 5L;
        System.out.println(c.equals(a+b));
    }
}
