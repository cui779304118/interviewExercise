package com.cuiwei.offer;

public class JumpFloor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=jumpFloor2(4);
		System.out.println("�ܹ���  "+n+" ��������");

	}
	/*���ڱ���,ǰ��ֻ�� һ�� 1�׻���2�׵�������
	a.�������������1�׻���2�ף���ô�ٶ���һ��������һ�ף���ôʣ�µ���n-1��̨�ף�������f(n-1);
	b.�ٶ���һ��������2�ף���ôʣ�µ���n-2��̨�ף�������f(n-2)
	c.��a\b������Եó�������Ϊ: f(n) = f(n-1) + f(n-2) 
	d.Ȼ��ͨ��ʵ�ʵ�������Եó���ֻ��һ�׵�ʱ�� f(1) = 1 ,ֻ�����׵�ʱ������� f(2) = 2
	e.���Է������յó�����һ��쳲��������У�
	        
	              | 1, (n=1)
	f(n) =     | 2, (n=2)
	              | f(n-1)+f(n-2) ,(n>2,nΪ����)*/
	
	public static int jumpFloor(int n){
		int one=1;
		int two=2;
		int three=0;
		if(n<=0)return 0; 
		if(n==1)return one;
		if(n==2)return two;
		for(int i=3;i<=n;i++){
			three=one+two;
			one=two;
			two=three;
		}
		return three;
	}
	
	public static int jumpFloor2(int n){
		if(n<=0)return 0; 
		if(n==1)return 1;
		if(n==2)return 2;
		return jumpFloor2(n-1)+jumpFloor2(n-2);
	}

}
