package com.cuiwei.DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * created by cuiwei on 2018/9/19
 * 命令模式
 */
public class CommandPattern {

    public static void main(String[] args) {
        DataDao dataDao = new DataDao();

        TransactionReceiver receiver = new TransactionReceiver();
        dataDao.setCommand(new TransactionCommand(receiver));
        dataDao.insert(0);
    }

}

class TransactionReceiver{
    public void commit(){
        System.out.println("提交事务成功！");
    }

    public void rollback(){
        System.out.println("回滚事务成功！");
    }
}

interface Command{
    void execute();
    void undo();
}

class TransactionCommand implements Command{

    TransactionReceiver receiver;

    public TransactionCommand(TransactionReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.commit();
    }

    @Override
    public void undo() {
        receiver.rollback();
    }
}

class DataDao{
    Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void insert(int num){
        try{
            int n = 10/num;
            System.out.println("插入成功！");

            command.execute();
        } catch (Exception e){
            e.printStackTrace();
            command.undo();
        }
    }

}