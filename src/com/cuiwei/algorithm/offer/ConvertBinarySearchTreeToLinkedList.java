package com.cuiwei.algorithm.offer;

public class ConvertBinarySearchTreeToLinkedList {
	
	TreeNode head;
	TreeNode realHead;
	
	private static class TreeNode{
		int Val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int Val){
			this.Val=Val;
		}
	}
	
	
	public TreeNode Convert(TreeNode pRootOfTree){

		ConvertHelp(pRootOfTree);
		return pRootOfTree;
	}
	
	public void ConvertHelp(TreeNode root){
		if(root==null){
			return;
		}
		ConvertHelp(root.left);
		
		if(head==null){
			head=root;
			realHead=root;
		}else{
			head.right=root;
			root.left=head;
			head=root;
		}
		ConvertHelp(root.right);		
	}

}
