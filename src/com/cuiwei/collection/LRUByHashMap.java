package com.cuiwei.collection;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;

/**
 * 主要思路是两个函数：1.在链表尾添加节点；
 * 2.将节点移动到链表尾（先删除节点，然后将节点添加到链表尾）
 * put操作时，将节点添加到表尾或者将节点移动到表尾；
 * get操作时，将节点移动到表尾；
 * created by cuiwei on 2018/8/17
 */
public class LRUByHashMap<K,V> {

    //默认最大容量
    private static final int DEFAULT_CAPACITY = 1<<4;
    //hashMap，用来存储值
    private HashMap<K,Entry<K,V>> hashMap;
    //双向链表头，维护插入键的顺序
    private Entry<K,V> head;
    private int capacity;

    private class Entry<K,V>{
         K key;
         V value;
         Entry<K,V> pre;
         Entry<K,V> next;

        Entry(){}
        Entry(K key,V value){
            this.key = key;
            this.value =value;
        }
    }

    public LRUByHashMap(int capacity){
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
    }
    public LRUByHashMap(){//默认构造函数
        this.capacity = DEFAULT_CAPACITY;
        this.hashMap = new HashMap<>();
    }
    //put函数
    public void put(K key,V value){
        Entry<K,V> entry = getEntry(key);
        if (entry == null){//如果是添加节点
            if (hashMap.size() >=  capacity){
                removeOlderst();//如果大于最大容量，就删除链表最靠前的那个值
            }
            entry = new Entry<>(key,value);
        }else{//如果是set节点
            entry.value = value;
            removeEntry(entry);
        }
        hashMap.put(key,entry);
        addLast(entry);
    }

    //通过键，获取值
    public V get(K key){
        Entry<K,V> entry = hashMap.get(key);
        if (entry == null) return null;
        //将该节点移到最后，成为最新节点
        removeEntry(entry);
        addLast(entry);
        return entry.value;
    }

    public Entry<K,V> getEntry(K key){
        return hashMap.get(key);
    }

    private void removeOlderst(){
        Entry oldestEntry = head.next;
        if (oldestEntry != head){
            hashMap.remove(oldestEntry.key);
        }
        head.next = oldestEntry.next;
        oldestEntry.next.pre = head;
    }

    private void remove(K key){
        removeEntry(hashMap.get(key));
    }

    //删除节点
    private void removeEntry(Entry<K,V> entry){
        Entry before = entry.pre;
        Entry after = entry.next;
        before.next = after;
        after.pre = before;
    }

    //在链表末尾添加节点
    private void addLast(Entry<K,V> entry){
        if (head == null){
            head = new Entry<>();
            head.next = head;
            head.pre = head;
        }
        Entry lastEntry = head.pre;
        lastEntry.next = entry;
        entry.pre = lastEntry;
        head.pre = entry;
        entry.next = head;
    }

    private int size(){
        return hashMap.size();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        Entry<K,V> p = head.next;
        while(p != head){
            builder.append(p.key).append(":").append(p.value).append(" ");
            p = p.next;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LRUByHashMap<String,String> lru = new LRUByHashMap<>(5);
        for (int i = 0; i < 5 ; i++) {
            lru.put("key" + i,"value" + i);
        }
        System.out.println(lru);
        for (int i = 6; i < 8 ; i++) {
            lru.put("key" + i,"value" + i);
        }

        System.out.println(lru);
        System.out.println(lru.get("key5"));
        System.out.println(lru.get("key4"));
        System.out.println(lru);
    }
}
