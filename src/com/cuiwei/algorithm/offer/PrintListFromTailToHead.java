package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.Collections;

public class PrintListFromTailToHead {
	
	ArrayList<Integer> list2=new ArrayList<Integer>();
	public static class ListNode {
	       int val;
		  ListNode next = null;
		
	       ListNode(int val) {
		            this.val = val;
	        }
   }
   public ListNode creatList(int [] list){
	   ListNode begin=new ListNode(list[0]);
	   for(int i=1;i<list.length;i++){
		   begin.next=new ListNode(list[i]);
	   }
	   return begin;
   }
	
   public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> relist=new ArrayList<Integer>();
        while(listNode!=null){
        	list.add(listNode.val);
        	listNode=listNode.next;
        }
        for(int i=list.size()-1;i>=0;i--){
        	relist.add(list.get(i));
        }
        return  relist;
    }
   
   public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
	   if(listNode!=null){
		   printListFromTailToHead2(listNode.next);
		   list2.add(listNode.val);
	   }
	   return list2;
   }
   

}
