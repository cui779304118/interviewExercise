package com.cuiwei.algorithm.offer.List;

/**
 * created by cuiwei on 2018/9/3
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }

    public static ListNode createList(int[] arr) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head.next;
    }

    public static void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.print(head.val);
    }
}
