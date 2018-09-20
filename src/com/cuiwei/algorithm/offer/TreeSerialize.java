package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeSerialize {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            this.val=x;
        }
    }

    public static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        frontPrint(root,builder);
        return builder.toString();
    }

    private static void frontPrint(TreeNode root, StringBuilder builder){
        if (root == null) {
            builder.append("#,");
            return;
        }
        builder.append(root.val).append(",");
        frontPrint(root.left,builder);
        frontPrint(root.right,builder);
    }

    public static TreeNode deSerialize(String str) {
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

    static int index = -1;
    public static TreeNode deSerialize2(String str){
        index++;
        String[] strs = str.split(",");
        if (index >= strs.length){
            return null;
        }
        TreeNode node = null;
        if (!strs[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = deSerialize2(str);
            node.right = deSerialize2(str);
        }
        return node;
    }

    public static String serialize2(TreeNode root){
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                builder.append(cur.val).append(",");
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            if (!builder.toString().endsWith("#,")){
                builder.append("#").append(",");
            }
            cur =stack.pop();
            cur = cur.right;
        }
        return builder.toString();
    }

    public static TreeNode createTree(TreeNode root, List<Integer> nodeList) {
        if (nodeList == null) {
            return root;
        }
        for (Integer element : nodeList) {
            root = insert(root, element);
        }
        return root;
    }

    //排序树中插入元素
    public static TreeNode insert(TreeNode root, int e) {
        TreeNode newNode = new TreeNode(e);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (current != null) {
                if (e < current.val) {
                    parent = current;
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        break;
                    }
                } else if (e > current.val) {
                    parent = current;
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        break;
                    }
                } else {
                    return root;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        String nodes = "1,2,4,#,5,#,3,6,#,7,#";
//        TreeSerialize tool = new TreeSerialize();
//        TreeNode root = tool.deSerialize(nodes);
//        System.out.println(tool.serialize(root));
        int[] nodeArr = new int[]{8,6,10,5,7,9,11};
        List<Integer> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeArr.length; i++) {
            nodeList.add(nodeArr[i]);
        }
        TreeNode root = createTree(null, nodeList);
        System.out.println(serialize(root));
        TreeNode deRoot = deSerialize2(serialize(root));
        System.out.println(serialize(deRoot));
    }

}
