package com.cuiwei.offer;

/**
 * 关于链表的算法题
 * @author Lebron
 *
 */
public class AboutList {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5};
//		ListNode head = createList(arr);
		ListNode head = createLoopList(arr, 2);
//		printList(head);
		System.out.println(isLoopList(head));
		System.out.println("the LoopList has [" + getTheLoopLenth(head) + "] nodes");
		System.out.println("the loop begin at " + findLoopStartNode(head).val);
//		head = reverseList(head);
//		ListNode kThNode = findKth2Tail(head, 2);
//		System.out.println(kThNode.val);
	}
	
	/**
	 *打印链表 
	 * @param head
	 */
	public static void printList(ListNode head){
		if(head == null){
			return;
		} 
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println("");
	}
	/**
	 * 新建一个有环的链表
	 * @param arr
	 * @param n
	 * @return
	 */
	public static ListNode createLoopList(int[] arr,int n){
		ListNode head = createList(arr);
		ListNode current = head;
		ListNode nThNode = getNode(current,n);
		while(current.next != null){
			current = current.next;
		}
		current.next = nThNode;
		return head;
	}
	
	public static ListNode getNode(ListNode head, int n){
		if(head == null){
			return null;
		}
		for(int i=0;i<n-1;i++){
			head = head.next;
		}
		return head;
	}
	
	/**
	 * 新建一个链表
	 * @param arr
	 * @return
	 */
	public static ListNode createList(int[] arr){
		ListNode current = null;
		ListNode head = null;
		for(int i=0;i<arr.length;i++){
			if(current == null){
				current = new ListNode(arr[i]);
				head = current;
			}else{
				current.next = new ListNode(arr[i]);
				current = current.next;
			}
		}
		return head;
	}
	/**
	 * 判断链表是否有环，用一快一慢两个指针。
	 * @param head
	 * @return
	 */
	public static boolean isLoopList(ListNode head){
		boolean flag = false;
		if(head == null){
			return flag;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(slow != null){
			if(fast == slow){
				flag = true;
				break;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return flag;
	}
	/**
	 * 寻找有环链表，环的入口节点。先得到环中节点数n，用两个指针p1,p2,先用p1走n,然后p2开始走 ，两个指针相遇的节点即是环入口
	 * @param head
	 * @return
	 */
	public static ListNode findLoopStartNode(ListNode head){
		if(head == null || !isLoopList(head)){
			return null;
		}
		int nodesInLoop = getTheLoopLenth(head);
		ListNode first = head;
		ListNode second = head;
		for(int i=0;i<nodesInLoop;i++){
			first = first.next;
		}
		while(first != second){
			first = first.next;
			second = second.next;
		}
		return first;
	}
	/**
	 * 获取有环的链表中环的长度
	 * @param head
	 * @return
	 */
	public static int getTheLoopLenth(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		int n = 0;
		int meetTimes = 0;
		while(slow != null){
			if(fast == slow){
				meetTimes ++;
				if(meetTimes == 1){
					n = 0;
				}
				if(meetTimes == 2){
					break;
				}
			}
			fast = fast.next.next;
			slow = slow.next;
			n++;
		}
		return n;
	}
	/**
	 * 链表反转
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head){
		if(head == null){
			return null;
		}
		ListNode pre = null;
		ListNode next = null;
		while(head !=null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	/**
	 * 寻找链表中倒数第k个节点
	 * 思路：两个指针，第一个指针向前遍历n-1次时，第二个指针开始遍历，当第一个指针到达终点时，第二个指针正好是倒数第k个节点
	 * @param head
	 * @return
	 */
	public static ListNode findKth2Tail(ListNode head, int n){
		if(head == null){
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		for(int i=0;i<n-1;i++){
			first = first.next;
		}
		while(first.next != null){
			second = second.next;
			first = first.next;
		}
		return second;
	}
	
//	public static ListNode reverseList2(ListNode head){
//		if(head==null)
//		    return null;
//        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
//        ListNode pre = null;
//        ListNode next = null;
//        /*//当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
//        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
//        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
//        //所以需要用到pre和next两个节点
//        //1->2->3->4->5
//        //1<-2<-3 4->5
//*/        while(head!=null){
//            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
//            //如此就可以做到反转链表的效果
//            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
//            next = head.next;
//            //保存完next，就可以让head从指向next变成指向pre了，代码如下
//            head.next = pre;
//            //head指向pre后，就继续依次反转下一个节点
//            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
//            pre = head;
//            head = next;
//        }
//        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
//        //直接输出pre就是我们想要得到的反转后的链表
//        return pre;
//	}
}

//class ListNode{
//	int val;
//	ListNode next = null;
//
//	ListNode(int val){
//		this.val = val;
//	}
//}
