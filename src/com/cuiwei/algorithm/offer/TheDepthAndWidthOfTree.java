package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TheDepthAndWidthOfTree {

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
    public TreeNode createRoot(List<Integer> list){
        TreeNode root = null;
        for (Integer val : list){
           root = addNode(root,new TreeNode(val));
        }
        return root;
    }

    public TreeNode addNode(TreeNode root,TreeNode node){
        if (root == null){
            root = node;
            return root;
        }else{
            TreeNode current = root;
            while(current != null){
                    if (node.val < current.val){
                        if (current.left == null){
                            current.left = node;
                            break;
                        }
                        current = current.left;
                    }
                    if (node.val > current.val){
                        if (current.right == null){
                            current.right = node;
                            break;
                        }
                        current = current.right;
                    }
                }
            }
        return root;
    }

    /**
     * 求树的深度，通过递归的方法
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left>right ? left : right) + 1;
    }

    /**
     * 求树的宽度，根据层序遍历
     * @param root
     * @return
     */
    public int treeWidth(TreeNode root){
        if (root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int width = 1;
        while(!queue.isEmpty()){
            int len = queue.size();
            width = (len > width) ? len : width;
            while(len > 0){
                TreeNode first = queue.poll();
                System.out.print(first.val + " ");
                if (first.left != null)queue.add(first.left);
                if (first.right != null)queue.add(first.right);
                len--;
            }
        }
        return width;
    }

    /**
     * 前序遍历，递归实现
     * @param root
     */
    public void frontPrint(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null)frontPrint(root.left);
        System.out.print(root.val + " ");
        if (root.right != null)frontPrint(root.right);
    }

    /**
     * 层序遍历，队列实现
     * @param root
     */
    public void layerPrint(TreeNode root){
        if (root == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            System.out.print(first.val + " ");
            if (first.left != null)queue.add(first.left);
            if (first.right != null)queue.add(first.right);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(20);add(15);add(25);add(13);add(14);add(22);add(30);
            }
        };
        TheDepthAndWidthOfTree tree = new TheDepthAndWidthOfTree();
        TreeNode root = tree.createRoot(list);
//        tree.frontPrint(root);
//        tree.layerPrint(root);
        System.out.println("树宽度： " + tree.treeWidth(root));
        System.out.println("树深度： " + tree.treeDepth(root));
    }
}
