package com.cuiwei.algorithm.offer;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.cuiwei.algorithm.offer.PrintTree;

/**
 * created by cuiwei on 2018/7/29
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //方法一：
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 0) return null;
        List<TreeNode> nodes = new ArrayList<>();
        getKthNode(pRoot, k, nodes);
        //如果nodes大小等于k，说明找到了第k小的节点，否则说明没有
        return (nodes.size() == k) ? nodes.get(k - 1) : null;
    }

    public void getKthNode(TreeNode pRoot, int k, List<TreeNode> nodes) {
        if (pRoot == null) return;
        getKthNode(pRoot.left, k, nodes);
        if (nodes.size() == k) return;
        nodes.add(pRoot);
        getKthNode(pRoot.right, k, nodes);
    }

    //方法二
    int index = 0;

    public TreeNode kThNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = kThNode(pRoot.left, k);
            if (node != null) return node;
            if (++index == k) return pRoot;
            node = kThNode(pRoot.right, k);
            if (node != null) return node;
        }
        return null;
    }


    //非递归方式
    public TreeNode kThNode3(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode cur = pRoot;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (++index == k) return cur;
            cur = cur.right;
        }
        return null;
    }

    public static void main(String[] args) {

    }


}
