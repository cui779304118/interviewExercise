package com.cuiwei.offer;

import org.junit.Test;

public class MergeTwoList {
	
	    private static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	    
	    @Test
	    public void test(){
	    	ListNode list1=new ListNode(0);
	    	ListNode list2=new ListNode(1);
	    	ListNode p1=list1;
	    	ListNode p2=list2;
	    	for(int i=2;i<=8;i+=2){
	    		
	    		ListNode temp=new ListNode(i);
	    		p1.next=temp;
	    		p1=p1.next;
	    	}
	    	for(int i=3;i<=9;i+=2){
	    		
	    		ListNode temp=new ListNode(i);
	    		p2.next=temp;
	    		p2=p2.next;
	    	}
	    	
	    	ListNode newList=Merge(list1,list2);
	    	ListNode p=newList;
	    	while(p!=null){
	    		System.out.print(p.val+" ");
	    		p=p.next;
	    	}
	    }
	
	public ListNode Merge(ListNode list1,ListNode list2) {
		ListNode p1=list1;
		ListNode p2=list2;
		
		while(p1!=null){
			p1=p1.next;
			if(p2.val>=p1.val&&p2.val<=p1.next.val){
				p1.next=p2;
				while(p2!=null||p2.next.val<p1.next.val||p2.next!=null){
					p2=p2.next;
				}
				p2.next=p1.next;
				p2=p2.next;
			}
		}
		return list1;

        
    }

}
