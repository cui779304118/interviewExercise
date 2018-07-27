package com.cuiwei.algorithm.offer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationNode {

    /**
     * 判断较为复杂，没有递归和加入辅助节点
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplicationNode(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode p = pHead;
        ListNode lp = p;
        ListNode tmp = p;
        while (p.next != null) {
            if (p.val == p.next.val) {
                tmp = p;
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                //如果是第一个开始重复
                if (tmp == pHead) {
                    if (p.next == null) {
                        pHead = null;
                        break;
                    }
                    pHead = p.next;
                    p = pHead;
                    continue;
                }
                lp.next = p.next;
                p = p.next;
                continue;
            }
            lp = p;
            p = p.next;
        }
        return pHead;
    }

    /**
     * 增加一个辅助头节点
     * @param pHead
     * @return
     */
    public ListNode deleteDuplicationNode1(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        //新增加一个头结点作为辅助节点
        int firstVal = -1;
        if (firstVal == pHead.val) firstVal = -2;
        ListNode newNode = new ListNode(firstVal);
        newNode.next = pHead;

        ListNode p = pHead, lp = newNode, newHead = lp;
        while (p.next != null) {
            if (p.val == p.next.val) {
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                lp.next = p.next;
                p = p.next;
                continue;
            }
            lp = p;
            p = p.next;
        }
        pHead = newHead.next;
        newHead.next = null;
        return pHead;
    }
}
