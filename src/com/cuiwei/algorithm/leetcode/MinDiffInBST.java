package com.cuiwei.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by cuiwei on 2018/9/14
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 */
public class MinDiffInBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int minDiff(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = getSortedVals(root);
        if (list == null || list.size() == 0) return 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1 ; i++) {
            int diff = list.get(i + 1) - list.get(i);
            minDiff = Math.min(minDiff,diff);
        }
        return minDiff;
    }

    private static List<Integer> getSortedVals(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }


}
