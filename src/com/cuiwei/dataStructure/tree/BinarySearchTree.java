package com.cuiwei.dataStructure.tree;

import java.util.LinkedList;

/**
 * 二叉搜索树
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    private static class BinaryNode<E> {
        E e;
        BinaryNode<E> left;
        BinaryNode<E> right;

        BinaryNode(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        BinaryNode(E e, BinaryNode<E> left, BinaryNode<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<E> root;
    private int size;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(E[] arr){
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            insert(arr[i]);
        }
    }

    public void makeEmpty() {
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(E x) {
        return contains(x, root);
    }

    public E findMin() {
        if (isEmpty()) {
            System.out.println("����Ϊ�գ�");
            return null;
        } else {
            return findMin(root).e;
        }
    }

    public E findMax() {
        if (isEmpty()) {
            System.out.println("����Ϊ�գ�");
            return null;
        } else {
            return findMax(root).e;
        }
    }

    //最左边的节点，递归的方式
    private BinaryNode<E> findMin(BinaryNode<E> b) {
        if (b == null) {
            return null;
        } else if (b.left == null) {
            return b;
        } else {
            return findMin(b.left);
        }
    }

    //循环的方式
    private BinaryNode<E> findMax(BinaryNode<E> b) {
        if (b != null) {
            while (b.right != null)
                b = b.right;
        }
        return b;
    }

    public void insert(E e) {
        root = this.insert(e, root);
        size++;
    }

    //循环的方式实现
    private void insert2(E e){
        BinaryNode<E> newNode = new BinaryNode<E>(e);
        if (root == null){
            root = newNode;
            return;
        }
        BinaryNode<E> current = root;
        while(true){
            if (e.compareTo(current.e) < 0){
                if (current.left == null){
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (e.compareTo(current.e) > 0){
                if (current.right == null){
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }else {
                System.out.println("该元素重复了！！！");
                return;
            }
        }
    }

    public void remove(E e) {
        root = this.remove(e, root);
        size--;
    }

    private enum  Method{
        PRE_PRINT,POST_PRINT,MID_PRINT,LAYER_PRINT;
    }

    public void printTree(Method order) {
        switch (order){
            case PRE_PRINT:
                this.PreprintTree(root);
                break;
            case MID_PRINT:
                this.MidprintTree(root);
                break;
            case POST_PRINT:
                this.PostprintTree(root);
                break;
            case LAYER_PRINT:
                this.layerPrintTree(root);
                break;
            default:
                this.PreprintTree(root);
                break;
        }
    }

    private void layerPrintTree(BinaryNode<E> root){
        if (root == null) return;
        LinkedList<BinaryNode<E>> queue = new LinkedList<>();
        int lastCount = 1;
        queue.add(root);
        BinaryNode<E> current;
        while(!queue.isEmpty()){
            while(lastCount > 0){
                current = queue.poll();
                System.out.print(current.e + " ");
                if (current.left != null ) queue.add(current.left);
                if (current.right != null ) queue.add(current.right);
                lastCount--;
            }
            System.out.print("\n");
            lastCount = queue.size();
        }
    }

    private void PreprintTree(BinaryNode<E> root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.e + " ");
            PreprintTree(root.left);
            PreprintTree(root.right);
        }
    }

    private void MidprintTree(BinaryNode<E> root) {
        if (root == null) {
            return;
        } else {
            MidprintTree(root.left);
            System.out.print(root.e + " ");
            MidprintTree(root.right);
        }
    }

    private void PostprintTree(BinaryNode<E> root) {
        if (root == null) {
            return;
        } else {
            PostprintTree(root.left);
            PostprintTree(root.right);
            System.out.print(root.e + " ");
        }
    }

    private BinaryNode<E> remove(E e, BinaryNode<E> t) {
        if (t == null) {
            return null;
        }
        int compareResult = e.compareTo(t.e);
        if (compareResult < 0) {
            t.left = remove(e, t.left);
        } else if (compareResult > 0) {
            t.right = remove(e, t.right);
        } else if (t.left != null && t.right != null) {//如果被删除节点有两个子节点
            t.e = findMin(t.right).e;//其值为右子树的最小值
            t.right = remove(t.e, t.right);//将右子树的最小值删除
        } else {//如果被删除节点是一个叶子节点或者只有一个儿子
            //为叶子，直接赋值为null，只有一个儿子，直接删除该节点
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private boolean contains(E x, BinaryNode<E> root) {
        if (root == null) {
            return false;
        }
        int resultBoolean = x.compareTo(root.e);
        if (resultBoolean > 0) {
            return contains(x, root.right);
        } else if (resultBoolean < 0) {
            return contains(x, root.left);
        } else {
            return true;
        }
    }

    private BinaryNode<E> insert(E x, BinaryNode<E> root) {
        if (root == null)
            return new BinaryNode<E>(x, null, null);
        int compareResult = x.compareTo(root.e);

        if (compareResult > 0) {
            root.right = insert(x, root.right);
        } else if (compareResult < 0) {
            root.left = insert(x, root.left);
        } else {
        }
        return root;
    }

    public BinaryNode<E> findNode(BinaryNode<E> root, E e){
        if (root == null) return null;
        BinaryNode<E> node;
        int compareResult = e.compareTo(root.e);
        if ( compareResult < 0){
            node = findNode(root.left,e);
        }else if (compareResult > 0){
            node = findNode(root.right,e);
        }else {
            node = root;
        }
        return node;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,3,4,1,8,5};
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i <arr.length ; i++) {
            tree.insert2(arr[i]);
        }
        tree.printTree(Method.PRE_PRINT);
        tree.remove(1);
        System.out.println();
        tree.printTree(Method.PRE_PRINT);
    }


}
