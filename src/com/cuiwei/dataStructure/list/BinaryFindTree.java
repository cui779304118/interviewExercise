package com.cuiwei.dataStructure.list;

import java.util.ArrayList;
import java.util.List;

public class BinaryFindTree {
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int element;
		
		public TreeNode(int e){
			this.element = e;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) {
		List<Integer> nodeList = new ArrayList<Integer>();
		int[] nodeArr = new int[]{4,5,2,3,1,9};
		for(int i=0;i<nodeArr.length;i++){
			nodeList.add(nodeArr[i]);
		}
		BinaryFindTree tree = new BinaryFindTree();
		tree.createTree(nodeList);
//		tree.preTravels(tree.root);
//		tree.midTravels(tree.root);
		tree.aftTravels(tree.root);
		for(int ele : tree.nodeList){
			System.out.print(ele + " ");
		}
		System.out.println("\n");
//		TreeNode findNode = tree.findKey(0);
//		System.out.println(findNode.element);
		TreeNode minNode = tree.getMinNode(tree.root);
		System.out.println(minNode.element);
	}
	
	TreeNode root;
	int size = 0;
	List<Integer> nodeList = new ArrayList<Integer>();
	
	public int createTree(List<Integer> nodeList){
		if(nodeList == null){
			return 0;
		}
		for(Integer element : nodeList){
			insert(element);
		}
		return size;
	}
	
	public boolean insert(int e){
		boolean flag = true;
		TreeNode newNode = new TreeNode(e);
		if(root == null){
			root = newNode;
		}else{
			TreeNode current = root;
			TreeNode parent = null;
			while(current!=null){
				if(e < current.element){
					parent = current;
					current = current.left;
					if(current == null){
						parent.left = newNode;
						size ++;
						break;
					}
				}else if(e > current.element){
					parent = current;
					current = current.right;
					if(current == null){
						parent.right = newNode;
						size ++;
						break;
					}
				}else{
					flag = false;
				}
			}
		}
		return flag;
	}
	
	public void preTravels(TreeNode root){
		if(root == null){
			return;
		}
		nodeList.add(root.element);
		if(root.left != null) preTravels(root.left);
		if(root.right != null) preTravels(root.right);
	}
	
	public void midTravels(TreeNode root){
		if(root == null){
			return;
		}
		if(root.left != null) midTravels(root.left);
		nodeList.add(root.element);
		if(root.right != null) midTravels(root.right);
	}
	public void aftTravels(TreeNode root){
		if(root == null){
			return;
		}
		if(root.left != null) aftTravels(root.left);
		if(root.right != null) aftTravels(root.right);
		nodeList.add(root.element);
	}
	
	public TreeNode findKey(int ele){
		TreeNode current = root;
		while(current !=null){
			if(ele < current.element){
				current = current.left;
			}else if(ele > current.element){
				current = current.right;
			}else{
				return current;
			}
		}
		return null;
	}

	public TreeNode getMinNode(TreeNode node){
		if(node == null){
			return null;
		}
		TreeNode current = node;
		TreeNode parent = null;
		while(current != null){
			parent = current;
			current = current.left;
		}
		return parent;
	}
}
