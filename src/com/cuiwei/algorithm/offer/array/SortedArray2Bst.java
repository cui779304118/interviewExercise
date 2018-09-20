package com.cuiwei.algorithm.offer.array;

/**
 * created by cuiwei on 2018/"8/30
 * 将有序数组转换为二叉搜索树
 */
public class SortedArray2Bst {

      public class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public  TreeNode sortedArrayToBst(int[] nums){
        if (nums == null || nums.length == 0) return null;
        return help(nums,0,nums.length - 1);
    }

    private  TreeNode help(int[] nums,int st,int en){
          if (st == en){
              return new TreeNode(nums[st]);
          }
          int mid = (st + en) >>1;
          TreeNode node = new TreeNode(nums[mid]);
          if (mid > st){
            node.left = help(nums,st,mid -1);
          }
          if (mid < en){
            node.right = help(nums,mid + 1,en);
          }
          return node;
    }
}
