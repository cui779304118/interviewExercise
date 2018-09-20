package com.cuiwei.algorithm.test;

import java.util.Stack;

/**
 * created by cuiwei on 2018/8/6
 * 将二叉查找树转化为双向链表
 */
public class CovertTree2List {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    //递归实现
    static TreeNode leftLast = null;

    public static TreeNode convert(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            leftLast = root;
            return root;
        }

        TreeNode left = convert(root.left);
        if (left != null) {
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;
        TreeNode right = convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left != null ? left : root;
    }

    //非递归实现,保存上一个节点的位置
    //1.核心是中序遍历的非递归算法。
    //2.修改当前遍历节点与前一遍历节点的指针指向。
    public static TreeNode convert2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode head = null;
        boolean isFirst = true;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (isFirst) {
                head = cur;
                pre = cur;
                isFirst = false;
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return head;
    }

}
