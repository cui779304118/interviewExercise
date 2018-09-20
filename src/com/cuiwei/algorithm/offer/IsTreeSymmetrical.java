package com.cuiwei.algorithm.offer;

import com.cuiwei.algorithm.offer.ReconBinaryTree;

public class IsTreeSymmetrical {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            this.val=x;
        }
    }
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * @param root
     * @return
     */
    public boolean isSymmetrical(TreeNode root) {
        if (root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetrical(left, right);
    }

    /**
     * 码很简单，关键还是知道怎么样才能判断一个
     * 二叉树是否对称，只要采用前序、中序、后序、层次遍历等任何一种遍历方法，分为先左后右和先
     * 右后左两种方法，只要两次结果相等就说明这棵树是一颗对称二叉树。
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
