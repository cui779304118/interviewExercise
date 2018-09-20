package com.cuiwei.algorithm.offer;


/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextLinkNode {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        //如果该节点存在右子树,则右子树最左边的节点是下一个节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        TreeLinkNode parent = pNode.next;
        if (parent == null) return parent;
        //如果该节点是某一节点的左节点，则下一节点即为父节点
        if ((parent.left) == pNode) {
            return parent;
        } else {//如果该节点是某一节点的右节点，则向上遍历，直到节点为某一节点的左节点
            while (parent != null && parent.left != pNode) {
                parent = parent.next;
                pNode = pNode.next;
            }
            return parent;
        }
    }
}
