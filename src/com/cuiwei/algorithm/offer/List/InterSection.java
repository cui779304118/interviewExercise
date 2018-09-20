package com.cuiwei.algorithm.offer.List;

/**
 * created by cuiwei on 2018/9/4
 */
public class InterSection {

    public static ListNode fun(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (!(pa == null && pb == null) && pa.val != pb.val) {
            pa = (pa == null) ? headB : pa.next;
            pb = (pb == null) ? headA : pb.next;
        }
        if (pa == null && pb == null) return null;
        return pa;
    }


}
