package com.cuiwei.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

/**
 * 思路1：分别遍历两个root，然后判断rootList2是否是rootList1的子序列
 */

/**
 * 思路2：参考剑指offer
 * 1、首先设置标志位result = false，因为一旦匹配成功result就设为true，
 * 剩下的代码不会执行，如果匹配不成功，默认返回false
 * 2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
 * 如果根节点不相同，则判断tree1的左子树和tree2是否相同，
 * 再判断右子树和tree2是否相同
 * 3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
 * DoesTree1HasTree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
 * tree1为空有两种情况（1）如果tree1为空&&tree2不为空说明不匹配，
 * （2）如果tree1为空，tree2为空，说明匹配。
 */

public class HasSubtree {

    private class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }

    //思路1：分别遍历两个root，然后判断rootList2是否是rootList1的子序列
    public boolean hasSubtree(TreeNode root1, TreeNode root2){
        if (null == root1 || null == root2){
            return false;
        }
        List<Integer> rootList1 = new ArrayList<>();
        List<Integer> rootList2 = new ArrayList<>();

        frontThrough(root1, rootList1);
        frontThrough(root2, rootList2);
        return rootList1.containsAll(rootList2);
    }

    public void frontThrough(TreeNode root, List<Integer> resultList){
        resultList.add(root.val);
        if(root.left !=null){
            frontThrough(root.left, resultList);
        }
        if(root.right !=null){
            frontThrough(root.right, resultList);
        }
    }

    //思路2：
    public boolean hasSubtree2(TreeNode root1, TreeNode root2){
        boolean result = false;
        if(root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = isTree2OfTree1(root1,root2);
            }
            if(!result){
                result = hasSubtree2(root1.left,root2);
            }
            if(!result){
                result = hasSubtree2(root1.right,root2);
            }
        }
            return result;
    }

    public boolean isTree2OfTree1(TreeNode root1, TreeNode root2){
        if (null == root2) return true;
        if (null == root1 && null != root2) return false;
        if (root1.val != root2.val) return false;
        return isTree2OfTree1(root1.left,root2.left) && isTree2OfTree1(root1.right,root2.right);
    }
}
