package com.cuiwei.algorithm.offer;

import java.util.Arrays;

import org.junit.Test;

public class ReconBinaryTree {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int x){
			this.val=x;
		}
	}

	@Test
	public void main() {
		// TODO Auto-generated method stub
		int [] pre={1,2,4,7,3,5,6,8};
		int [] in={4,7,2,1,5,3,8,6};
		TreeNode root=reConstructBinaryTree(pre,in);
		System.out.println("ǰ������Ľ���� ");
		prePrint(root);
		System.out.println("\n��������Ľ���� ");
		inPrint(root);

	}
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in){
		TreeNode root=re(pre,0,pre.length-1,in,0,in.length-1);
		return root;
	}
	
	private TreeNode re(int[] pre,int sp,int ep,int [] in,int si,int ei){
		if(sp>ep||si>ei){
			return null;
		}
		TreeNode root=new TreeNode(pre[sp]);
		for(int i=si;i<=ei;i++){
			if(in[i]==pre[sp]){
				root.left=re(pre,sp+1,sp+i-si,in,si,i-1);
				root.right=re(pre,sp+i-si+1,ep,in,i+1,ei);
				break;
			}
		}
		return root;
	}
	
	public void prePrint(TreeNode root){
		if(root==null){
			return;
		}else{
			System.out.print(root.val+" ");
			prePrint(root.left);
			prePrint(root.right);
		}
		
	}
	
	public void inPrint(TreeNode root){
		if(root==null){
			return;
		}else{
			inPrint(root.left);
			System.out.print(root.val+" ");
			inPrint(root.right);
		}
		
	}

}
