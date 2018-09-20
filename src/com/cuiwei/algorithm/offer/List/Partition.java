package com.cuiwei.algorithm.offer.List;

import java.util.List;

/**
 * created by cuiwei on 2018/9/3
 */
public class Partition {

    public static ListNode fun(ListNode head, int x) {
        if (head == null) return null;
        ListNode bigHead = new ListNode(-1);
        ListNode bigCur = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallCur = smallHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val >= x) {
                bigCur.next = cur;
                bigCur = bigCur.next;
            } else {
                smallCur.next = cur;
                smallCur = smallCur.next;
            }
            cur = cur.next;
        }
        bigCur.next = null;
        smallCur.next = bigHead.next;
        return smallHead.next;
    }

    public static ListNode fun2(ListNode head, int x) {
        if (head == null) return null;
        ListNode bigHead = new ListNode(-1);
        ListNode bigCur = bigHead;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val >= x) {
                bigCur.next = cur;
                bigCur = bigCur.next;
                cur = cur.next;
                continue;
            }
            if (pre != null) {
                pre.next = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        bigCur.next = null;
        if (pre != null)
        pre.next = bigHead.next;
        if (head.val >= x && pre !=null) return pre;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2};
        ListNode head = ListNode.createList(arr);
        ListNode.printList(head);
        System.out.println();
        ListNode.printList(fun(head, 0));
    }
}
