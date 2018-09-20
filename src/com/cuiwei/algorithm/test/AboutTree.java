package com.cuiwei.algorithm.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * created by cuiwei on 2018/8/9
 */
public class AboutTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    //首先，找到与root2根节点相同的子节点，然后从该子节点开始与root2一起进行中序遍历，判断是否相等
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isSameTree(root1, root2);
            }
            if (!result) {
                result = hasSubTree(root1.left, root2);
            }
            if (!result) {
                result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    //判断两个树是否相等
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;//如果遍历到了root2的最后，说明两个树相等
        if (root1 == null) return false;//如果root2不为true，而root1遍历完了，则说明两个树不相等
        if (root1.val != root2.val) return false;//有一个节点不相等，则不相等
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    //二叉树中和为某一值的路径
    private ArrayList<Integer> list = new ArrayList<>();//用于存储每一条路径
    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();//存储所有满足条件的路径

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) return lists;
        list.add(root.val);//将这一层节点加入list
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            lists.add(new ArrayList<>(list));//一定要新建一个List,否则所有都是指向一个对象
        }
        findPath(root.left, target);//往左边搜索
        findPath(root.right, target);//往右边搜索
        list.remove(list.size() - 1);//移除这一层加入的节点，然后返回上一层
        return lists;
    }

    //二叉树的镜像
    public void Mirror(TreeNode root) {
        if (root == null) return;
        //交换左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);
    }

    //判断是否是二叉搜索树
    public boolean isSearchTree(TreeNode root) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        boolean isFirst = true;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (isFirst) {
                pre = cur;
                isFirst = false;
            } else {
                if (pre.val >= cur.val) return false;
                pre = cur;
            }
            cur = cur.right;
        }
        return true;
    }

    //判断是否是平衡树
    public boolean isBalanced(TreeNode root) {
        if (root == null) return false;
        return getDepth(root) != -1;
    }
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        //如果左子树深度与右子树之差大于1，则返回-1，如果左右子树有一个为-1，就直接返回，否则就继续求树的深度
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
    //把二叉树打印成多行
    public ArrayList<ArrayList<Integer>> print(TreeNode root){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int last = 1;//记录上一层的节点数
        TreeNode cur ;
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            while(last > 0){//当上一次节点数不为0
                cur = queue.removeFirst();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                last--;
            }
            lists.add(list);
            last = queue.size();
        }
        return lists;
    }



}
