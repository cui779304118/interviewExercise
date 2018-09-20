package com.cuiwei.algorithm.offer;

import java.util.*;

/**
 * created by cuiwei on 2018/7/29
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTree {

     static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> layerPrint(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int start = 0, end = 1;
        ArrayList<Integer> line = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            start++;
            line.add(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            if (start == end){
                end = queue.size();
                start = 0;
                result.add(line);
                line = new ArrayList<>();
            }
        }
        return result;
    }

    //思路：利用两个栈，奇数层时，从左往右push，偶数层，从右往左push
    public static ArrayList<ArrayList<Integer>> zhiPrint(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(pRoot);
        boolean iOdd = true;//是否是奇数层
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> line = new ArrayList<>();
            TreeNode cur;
            if (iOdd) {
                while (!stack1.isEmpty()) {
                    cur = stack1.pop();
                    line.add(cur.val);
                    if (cur.left != null) stack2.add(cur.left);
                    if (cur.right != null) stack2.add(cur.right);
                }
                iOdd = false;
                result.add(line);
            } else {
                while (!stack2.isEmpty()) {
                    cur = stack2.pop();
                    line.add(cur.val);
                    if (cur.right != null) stack1.add(cur.right);
                    if (cur.left != null) stack1.add(cur.left);
                }
                iOdd = true;
                result.add(line);
            }
        }
        return result;
    }

    //思路：利用一个双端队列(有问题)TODO
    public static ArrayList<ArrayList<Integer>> zhiPrint2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(pRoot);
        boolean isOdd = true;//是否是奇数层
        int start = 0,end = 1;
        ArrayList<Integer> line = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode cur;
            if (isOdd){
                cur = deque.pollLast();
                line.add(cur.val);
                start++;

                if (cur.left != null) deque.add(cur.left);
                if (cur.right != null) deque.add(cur.right);
            }else {
                cur = deque.pollLast();
                line.add(cur.val);
                start++;

                if (cur.right != null) deque.add(cur.right);
                if (cur.left != null) deque.add(cur.left);
            }

            if (start == end){
                end = deque.size();
                start = 0;
                result.add(line);
                line = new ArrayList<>();
                isOdd = !isOdd;
            }
        }
        return result;
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
        int[] nodeArr = new int[]{4, 5, 2,8,3,10,6};
        List<Integer> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeArr.length; i++) {
            nodeList.add(nodeArr[i]);
        }
        TreeNode root = createTree(null, nodeList);
        ArrayList<ArrayList<Integer>> results = zhiPrint2(root);
        for (ArrayList<Integer> arrayList : results) {
            System.out.println(Arrays.toString(arrayList.toArray()));
        }
    }

}
