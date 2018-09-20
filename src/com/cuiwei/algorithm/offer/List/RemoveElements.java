package com.cuiwei.algorithm.offer.List;

/**
 * created by cuiwei on 2018/9/5
 */
public class RemoveElements {

    public static ListNode fun(ListNode head,int val){
        if (head == null) return null;
        ListNode p = head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        while(p!=null){
            if (p.val == val){
                pre.next = p.next;
                p = p.next;
                continue;
            }
            pre = p;
            p = p.next;
        }
        return newHead.next;
    }
}
