package com.cuiwei.algorithm.offer;

/**
 * created by cuiwei on 2018/7/7
 * 题目：判断二叉树是否是平衡二叉树
 * 最佳方法是：改造求树的高度，如果左子树大于右子树，返回-1，如果不大于则返回树高
 */
public class IsBalancedTree {

    public boolean isBalancedTree(BinaryFindTree.TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(BinaryFindTree.TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : (1 + Math.max(left, right));
    }
}
