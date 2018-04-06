package com.cuiwei.dataStructure.tree;

public class BinarySearchTree<E extends Comparable<?super E>> {

	private static class BinaryNode<E>{
		E e;
		BinaryNode<E> left;
		BinaryNode<E> right;
		
		BinaryNode(E e){
			this.e=e;
			this.left=null;
			this.right=null;
		}
		
		BinaryNode(E e,BinaryNode<E> left,BinaryNode<E> right){
			this.e=e;
			this.left=left;
			this.right=right;
		}
	}
	
	private BinaryNode<E> root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	public void makeEmpty(){
		root=null;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public boolean contains(E x){
		return contains(x,root);
	}
	public E findMin(){
		if(isEmpty()){
			System.out.println("����Ϊ�գ�");
			return null;
		}else{
			return findMin(root).e;
		}
	}
	
	public E findMax(){
		if(isEmpty()){
			System.out.println("����Ϊ�գ�");
			return null;
		}else{
			return findMax(root).e;
		}
	}
	
	private BinaryNode<E> findMin(BinaryNode<E> b){
		if(b==null){
			return null;
		}else if(b.left==null){
			return b;
		}else{
			return findMin(b.left);
		}
	}
	
	private BinaryNode<E> findMax(BinaryNode<E> b){
		if(b!=null){
			while(b.right!=null)
				b=b.right;			
			}
		return b;
	}
	
	public void insert(E e){
		root=this.insert(e,root);
	}
	
	public void remove(E e){
		root=this.remove(e,root);
	}
	

    public void printTree(String order){
    	if(order=="pre"){
    		this.PreprintTree(root);
    	}
        if(order=="post"){
    		this.PostprintTree(root);
        }
    	if(order=="mid"){
    		this.MidprintTree(root);
    	}
		
	}
    
    private void PreprintTree(BinaryNode<E> root){
    	if(root==null){
    		return;
    	}else{
    		System.out.print(root.e+" ");
    		PreprintTree(root.left);
    		PreprintTree(root.right);
    	}
    }
    
    private void MidprintTree(BinaryNode<E> root){
    	if(root==null){
    		return;
    	}else{
    		MidprintTree(root.left);
    		System.out.print(root.e+" ");
    		MidprintTree(root.right);
    	}
    }
    
    private void PostprintTree(BinaryNode<E> root){
    	if(root==null){
    		return;
    	}else{
    		
    		PostprintTree(root.left);
    		PostprintTree(root.right);
    		System.out.print(root.e+" ");
    	}
    }
    
	
	private BinaryNode<E> remove(E e,BinaryNode<E> t){
		if(t==null){
			return null;
		}
		int compareResult=e.compareTo(t.e);
		if(compareResult<0){
			t.left=remove(e,t.left);
		}else if(compareResult>0){
			t.right=remove(e,t.right);
		}else if(t.left!=null&&t.right!=null){
			t.e=findMin(t.right).e;
			t.right=remove(t.e,t.right);
		}else{
			t=(t.left!=null)?t.left:t.right;
		}
		return t;
	}
	
	private boolean contains(E x,BinaryNode<E> root){
		if(root==null){
			return false;
		}
		int resultBoolean=x.compareTo(root.e);
		if(resultBoolean>0){
			return contains(x,root.right);
		}else if(resultBoolean<0){
			return contains(x,root.left);
		}else{
			return true;
		}
	}
	
	private BinaryNode<E> insert(E x,BinaryNode<E> root){
		if(root==null)
			return new BinaryNode<E>(x,null,null);
		int compareResult=x.compareTo(root.e);
		
		if(compareResult>0){
			root.right=insert(x,root.right);
		}else if(compareResult<0){
			root.left=insert(x,root.left);
		}else{}
		return root;
	}
	
	
	

}
