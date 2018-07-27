package com.cuiwei.algorithm.offer;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 思路：
 * 1.用一个hashSet做标记
 * 2.让长的先走（长-短），短的后走，交点即为第一个公共节点
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {

    }
    public ListNode findFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2){
//            if (p1 != null) p1 = p1.next;
//            if (p2 != null) p2 = p2.next;
//            if(p1 != p2){
//                if (p1 == null) p1 = pHead1;
//                if (p2 == null) p2 = pHead2;
//            }
            p1 = (p1 != null) ? p1.next : pHead1;
            p2 = (p2 != null) ? p2.next : pHead2;
        }
        return p1;
    }

    public ListNode findFirstCommonNode1(ListNode pHead1,ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        HashSet<ListNode> set = new HashSet<>();
        while(p1 != null){
            set.add(p1);
            p1 = p1.next;
        }
        while(p2 != null){
            if (set.contains(p2)){
                break;
            }
            p2 = p2.next;
        }
        return p2;
    }
}
