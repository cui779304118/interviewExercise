package com.cuiwei.DesignPattern;

/**
 * created by cuiwei on 2018/9/16
 * 实现发送不同类型的消息
 *消息类型：普通消息（发送功能），加急消息（发送，监听），紧急消息（发送，监听，催促）
 *发送类型：sms发送，email发送，mobile发送
 *消息类型为抽象对象
 *发送类型为实现对象
 */
abstract class  Message{
    protected Sender send;

    public Message(Sender sender){
        this.send = sender;
    }
    public abstract boolean send(String sender,String reciver);
}

interface Sender{
    void sendMessage(String sender,String reciver);
}

class CommonMessage extends Message{
    public CommonMessage(Sender sender){
        super(sender);
    }

    @Override
    public boolean send(String sender, String reciver) {
        System.out.print("【普通消息】 ");
        send.sendMessage(sender, reciver);
        return true;
    }
}

class UrgentMessage extends Message{
    public UrgentMessage(Sender sender){
        super(sender);
    }

    @Override
    public boolean send(String sender, String reciver) {
        System.out.print("【加急消息】 ");
        send.sendMessage(sender, reciver);
        return true;
    }
    public void watcher(){
        System.out.println("监控发送进度");
    }
}

class EmergeMessage extends Message{
    public EmergeMessage(Sender sender){
        super(sender);
    }

    @Override
    public boolean send(String sender, String reciver) {
        System.out.print("【紧急消息】 ");
        send.sendMessage(sender, reciver);
        return true;
    }

    public void urge(){
        System.out.println("催促消息");
    }
}

class SMSSender implements Sender{
    @Override
    public void sendMessage(String sender, String reciver) {
        System.out.println("【sms方式】，【" + sender + "】给【" + reciver + "】发送一条消息" );
    }
}
class EmailSender implements Sender{
    @Override
    public void sendMessage(String sender, String reciver) {
        System.out.println("【email方式】，【" + sender + "】给【" + reciver + "】发送一条消息" );
    }
}
class MobileSender implements Sender{
    @Override
    public void sendMessage(String sender, String reciver) {
        System.out.println("【mobile方式】，【" + sender + "】给【" + reciver + "】发送一条消息" );
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        String sender = "崔伟";
        String reciver = "阿里";
        Message commonMessage = new CommonMessage(new SMSSender());
        commonMessage.send(sender,reciver);

        Message urgentMessage = new UrgentMessage(new EmailSender());
        urgentMessage.send(sender,reciver);
        ((UrgentMessage) urgentMessage).watcher();

        Message emergeMessage = new EmergeMessage(new MobileSender());
        emergeMessage.send(sender,reciver);
        ((EmergeMessage) emergeMessage).urge();
    }
}



