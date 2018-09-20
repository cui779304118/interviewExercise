package com.cuiwei.algorithm.offer.List;

/**
 * created by cuiwei on 2018/9/4
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1.next != null && p2 != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                p2 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    public boolean hasCycle(ListNode head){
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }


}
