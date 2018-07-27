package com.cuiwei.offer;

import java.util.Stack;

public class TreeSerialize {


    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        frontPrint(root,builder);
        return builder.toString();
    }

    private void frontPrint(TreeNode root,StringBuilder builder){
        if (root == null) {
            builder.append("#,");
            return;
        }
        builder.append(root.val).append(",");
        frontPrint(root.left,builder);
        frontPrint(root.right,builder);
    }

    public TreeNode deSerialize(String str) {
        if (str == null || str == "") return null;
        String[] nodeStrs = str.split(",");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodeStrs[0]));
        stack.push(root);
        TreeNode current = root;
        for (int i = 1; i < (nodeStrs.length-1) && !stack.isEmpty(); i++) {
            if (nodeStrs[i].equals("#")) {
                current = stack.pop();
                TreeNode newNodeRight = new TreeNode(Integer.valueOf(nodeStrs[++i]));
                current.right = newNodeRight;
                current = newNodeRight;
            } else {
                TreeNode newNode = new TreeNode(Integer.valueOf(nodeStrs[i]));
                current.left = newNode;
                current = newNode;
                stack.push(newNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String nodes = "1,2,4,#,5,#,3,6,#,7,#";
        TreeSerialize tool = new TreeSerialize();
        TreeNode root = tool.deSerialize(nodes);
        System.out.println(tool.serialize(root));
    }

}
