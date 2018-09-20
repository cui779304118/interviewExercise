package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/6
 */
public class MergeListNode {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    //递归方式
    public static ListNode merge2(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = merge2(list1.next,list2);
            return list1;
        }else {
            list2.next = merge2(list1,list2.next);
            return list2;
        }
    }

    //直接方式
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        while (p1 != null) {
            p.next = p1;
            p = p.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            p.next = p2;
            p = p.next;
            p2 = p2.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,4,6,8};
        int[] arr2 = new int[]{1,3,5,7};
        ListNode head1 = createList(arr1);
        ListNode head2 = createList(arr2);
        printList(merge2(head1,head2));
    }

}
