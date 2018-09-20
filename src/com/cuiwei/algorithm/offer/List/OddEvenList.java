package com.cuiwei.algorithm.offer.List;

/**
 * created by cuiwei on 2018/9/4
 */
public class OddEvenList {
    public static ListNode fun(ListNode head){
        if (head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode headNext = head.next;
        while(p1.next != null && p2.next != null){
            p1.next = p1.next.next;
            p1 = p1.next;
            p2.next = p2.next.next;
            p2 = p2.next;
        }
        p1.next = headNext;
        return head;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7,8,9};
        ListNode head = ListNode.createList(arr);
        ListNode oddHead = fun(head);
        ListNode.printList(oddHead);

    }


}
