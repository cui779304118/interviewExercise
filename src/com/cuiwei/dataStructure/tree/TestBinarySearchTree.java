package com.cuiwei.dataStructure.tree;

import java.util.Random;

import org.junit.Test;

public class TestBinarySearchTree {
	@Test
	public void test(){
		BinarySearchTree<Integer> b=new BinarySearchTree<Integer>();
		for(int i=1;i<=20;i++){
			Random r=new Random();
			b.insert(r.nextInt(20));
			b.insert(i);
		}
		
		System.out.println("����Ϊ���� "+b.isEmpty());
		System.out.println("��������Сֵ:"+b.findMin());
		System.out.println("���������ֵ: "+b.findMax());
		System.out.println("�Ƿ���15��"+b.contains(15));
		System.out.println("�Ƿ���25��"+b.contains(25));
		System.out.println("\n���������\n");
		b.printTree("pre");
		System.out.println("\n���������\n");
		b.printTree("mid");
		System.out.println("\n���������\n");
		b.printTree("post");
	}

}
