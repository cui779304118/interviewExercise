package com.cuiwei.algorithm.test;



/**
 * created by cuiwei on 2018/8/15
 */
public class AboutStack {
    //即用一个minStack栈来存储最小值，当push进去的值大于min时，
    // minStack就不入栈，当出栈元素等于min时，minStack就出栈；
    private static final int DEFAULT_CAPACITY = 16;
    private int [] table;
    private int top;
    private int minTop;
    private int [] minTable;
    private int min = Integer.MAX_VALUE;

    public boolean isEmpty(){
        return top == 0;
    }

    public int size(){
        return top;
    }

    public boolean push(int node){
         this.table = ensureCapacity(this.table);
         this.minTable = ensureCapacity(this.minTable);

         table[top++] = node;
         if (node <= min){
             minTable[minTop++] = node;
             min = node;
         }
         return true;
    }

    public int top() throws Exception{
        if (isEmpty()){
            throw new Exception("stack is empty!");
        }
        return table[top - 1];
    }

    public int pop() throws Exception{
        if (isEmpty()){
            throw new Exception("stack is empty!");
        }
        int topValue = table[top - 1];
        table[top--] = 0;
        if (topValue == min){//如果出栈值等于最小值
            minTable[minTop--]=0;//最小值栈出栈
            if (minTop != 0){
                min = minTable[minTop-1];//栈顶元素为最小元素
            }
        }
        return topValue;
    }

    public int min(){
        return min;
    }

    private int[] ensureCapacity(int[] table){//扩容函数
        if (table == null){
            table = new int[DEFAULT_CAPACITY];
            return table;
        }
        if (size() == table.length){
            int newCap = size() << 1;
            int[] newTable = new int[newCap];
            System.arraycopy(table,0,newTable,0,size());
            table = newTable;
        }
        return table;
    }

    public static void main(String[] args) throws Exception {
        AboutStack stack = new AboutStack();
        for (int i = 0; i < 20 ; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(stack.pop());
            System.out.println("min=" + stack.min());
        }
    }

}
