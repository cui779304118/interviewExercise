package com.cuiwei.algorithm.offer.List;

/**
 * created by cuiwei on 2018/9/4
 */
public class ReorderList {

    public static ListNode fun(ListNode head) {
        if (head == null) return null;
        ListNode p1 = head;
        ListNode mid = findMid(p1);
        while (p1.next != mid) {
            p1 = p1.next;
        }
        p1.next = null;
        ListNode head2 = converse(mid);
        head = merge(head, head2);
        return head;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode newHead = new ListNode(-1);
        ListNode head = newHead;
        while (head1 != null && head2 != null) {
            if ((index & 1) == 0) {
                newHead.next = head1;
                head1 = head1.next;
            } else {
                newHead.next = head2;
                head2 = head2.next;
            }
            newHead = newHead.next;
            index++;
        }
        if (head1 != null) {
            newHead.next = head1;
        }else{
            newHead.next = head2;
        }
        return head.next;
    }

    private static ListNode findMid(ListNode head) {
        if (head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
    }

    private static ListNode converse(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode pre = null;
        ListNode next = null;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.createList(arr);
        ListNode mid = findMid(head);
        System.out.println(mid.val);
        ListNode oddHead = fun(head);
        ListNode.printList(oddHead);
    }

}
