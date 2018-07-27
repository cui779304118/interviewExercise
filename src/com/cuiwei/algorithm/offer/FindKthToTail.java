package com.cuiwei.algorithm.offer;

public class FindKthToTail {
	
	private static class Node{
		private int val;
		private Node next = null;
		
		Node(int val){
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(0);
		Node temp = head;
		for(int i=1;i<=8;i++){
			Node newNode = new Node(i);
			temp.next = newNode;
			temp = newNode;
		}
		int k = 5;
		Node kNode =new FindKthToTail().findKthToTail2(head, k);
		System.out.println(kNode.val);

	}
	
	public Node findKthToTail(Node head,int k){
		
		if(head == null || k ==0){
			return null;
		}
			
		Node nodeFirst = head;
		Node nodeSec = head;
		
		for(int i=1;i<=k-1;i++){
			if(nodeFirst.next==null){
				return null;
			}
			nodeFirst = nodeFirst.next;
		}
		
		while(nodeFirst.next!=null){
			nodeFirst = nodeFirst.next;
			nodeSec = nodeSec.next;
		}
		
		return nodeSec;
	}
	
	public Node findKthToTail2(Node head,int k){
		if(head == null){
			return null;
		}
		Node pre,aft;
		pre = aft = head;
		int count=0;
		while(pre!=null){
			pre = pre.next;
			count++;
			if(count>=k){
				aft=aft.next;
			}
		}
		return count<k?null:aft;
	}

}
