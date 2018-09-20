package com.cuiwei.dataStructure.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree<E> {
    private E[] elements;
    private List<Node<E>> theTree;

    static class Node<E> {
        public E e;
        public Node<E> leftNode;
        public Node<E> rightNode;

        public Node(E e) {
            this.e = e;
        }
    }

    public BinaryTree(E[] elements) {
        this.elements = elements;
        this.createBinaryTree(elements);
    }

    public void clear() {
        theTree = new LinkedList<Node<E>>();
    }

    private void createBinaryTree(E[] elements) {
        this.clear();
        int len = elements.length;

        for (int i = 0; i < len; i++) {
            theTree.add(new Node<E>(elements[i]));
        }
        for (int i = 0; i < len / 2 - 1; i++) {
            theTree.get(i).leftNode = theTree.get(2 * i + 1);
            theTree.get(i).rightNode = theTree.get(2 * i + 2);
        }
        int theLast = len / 2 - 1;
        theTree.get(theLast).leftNode = theTree.get(2 * theLast + 1);
        if (len % 2 == 1) {
            theTree.get(theLast).rightNode = theTree.get(2 * theLast + 2);
        }
    }

    public int size() {
        return this.theTree.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void preOrderTraverse(Node<E> node) {
        if (node == null) return;
        System.out.print(node.e + " ");
        preOrderTraverse(node.leftNode);
        preOrderTraverse(node.rightNode);
    }

    public void inOrderTraverse(Node<E> node) {
        if (node == null) return;
        inOrderTraverse(node.leftNode);
        System.out.print(node.e + " ");
        inOrderTraverse(node.rightNode);
    }

    public void postOrderTraverse(Node<E> node) {
        if (node == null) return;
        postOrderTraverse(node.leftNode);
        postOrderTraverse(node.rightNode);
        System.out.print(node.e + " ");
    }

    public List<Node<E>> getTheTree() {
        return theTree;
    }

    public void setTheTree(List<Node<E>> theTree) {
        this.theTree = theTree;
    }

    public void printFromTopToBootom(Node<E> root) {
        List<Node<E>> queue = new LinkedList<Node<E>>();
        queue.add(root);
        while (queue.size() != 0) {
            Node<E> temp = queue.remove(0);
            if (temp.leftNode != null)
                queue.add(temp.leftNode);
            if (temp.rightNode != null)
                queue.add(temp.rightNode);
            System.out.print(temp.e + " ");
        }
    }


}
