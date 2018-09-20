package com.cuiwei.algorithm.test;

/**
 * created by cuiwei on 2018/8/8
 */
public class AboutList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //先找出两条链表的差n，让较长的链表先走n步，然后同时走，第一个相等节点就是第一个公共节点
    public ListNode find(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //找出谁更长
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        //如果p1更长，则让p1先走
        if (p1 != null) {
            while (p1 != null) {
                pHead1 = pHead1.next;
                p1 = p1.next;
            }
        }else if (p2 != null) {//如果p2更长，则让p2先走
            while (p2 != null) {
                pHead2 = pHead2.next;
                p2 = p2.next;
            }
        }
        //同时走，此时他们剩余节点一样长，第一个相等节点就是第一个公共节点
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val == pHead2.val) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public ListNode find2(ListNode pHead1, ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        //假设L1比L2长，第1次，p2先到达链表尾，此时让p2指向L1的头
        //当p1到达尾时，p2正好让L1走了（L1-L2）步，此时让p1指向L2的头，
        //此时，就相当于L1先走了（L1-L2）步，L2从头开始走
        //此时他们剩余节点一样长，第一个相等节点就是第一个公共节点
        while(p1 != p2){
           p1 = (p1 == null) ? pHead2 : p1.next;
           p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }

    //环的入口节点
    public ListNode entryOfLoop(ListNode pHead){
        ListNode p1 = pHead;//快指针
        ListNode p2 = pHead;//慢指针
        while(p1 != null && p1.next != null){
            p1 = p1.next.next;//快指针一次走两步
            p2 = p2.next;//慢指针一次走一步
            if (p1 == p2){//第一次相遇
                p2 = pHead;//使慢指针回到头节点
                while(p1 != null && p2 != null){
                    if (p1 == p2) return p1;//第二次相遇的节点
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
        }
        return null;
    }

    //删除重复节点,非递归方法
    public ListNode delete(ListNode pHead){
        if (pHead == null) return null;
        ListNode next = pHead.next;
        ListNode p = pHead;
        ListNode pre = null;
        while(p != null && next != null ){
            if (p.val == next.val){
                while(next != null && p.val == next.val){
                    next = next.next;
                }
                if (pre == null){
                    pHead = next;
                    if (next != null)
                    next = next.next;
                    p = pHead;
                    continue;
                }
                pre.next = next;
                p = next;
                if (next != null)
                next = next.next;
            }else{
                pre = p;
                p = p.next;
                next = next.next;
            }
        }
        return pHead;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.val < head2.val){
            head1.next = merge(head1.next,head2);
            return head1;
        }else {
            head2.next = merge(head1,head2.next);
            return head2;
        }
    }

}
