package com.cuiwei.dataStructure.tree;

import org.junit.Test;

public class TestBinaryTree {
	@Test
	public void test(){
		//String [] elements={"A","B","C","C","D","E","F","G","H","I","J","K"};
		Integer [] elements={1,2,3,4,5,6,7,8};
		BinaryTree<Integer> bt=new BinaryTree<>(elements);
		System.out.println("�����Ƿ�Ϊ�գ�"+bt.isEmpty());
		System.out.println("�����Ĵ�СΪ�� "+bt.size());
		System.out.println("ǰ������Ľ���� ");
		bt.preOrderTraverse(bt.getTheTree().get(0));
		System.out.println("\n��������Ľ���� ");
		bt.inOrderTraverse(bt.getTheTree().get(0));
		System.out.println("\n��������Ľ���� ");
		bt.postOrderTraverse(bt.getTheTree().get(0));
		System.out.println("\n���ϵ��´�ӡ�Ľ���� ");
		bt.printFromTopToBootom(bt.getTheTree().get(0));
	}

}
