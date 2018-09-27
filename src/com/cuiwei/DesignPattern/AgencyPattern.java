package com.cuiwei.DesignPattern;

/**
 * created by cuiwei on 2018/9/20
 * 中介者模式
 */
public class AgencyPattern {

    public static void main(String[] args) {
        WulinAlliance wulinMediator = new WulinAlliance();
        Shaolin shaolin = new Shaolin(wulinMediator);
        Emei emei = new Emei(wulinMediator);
        Wudang wudang = new Wudang(wulinMediator);

        wulinMediator.setEmei(emei);
        wulinMediator.setShaolin(shaolin);
        wulinMediator.setWudang(wudang);

        wudang.sendAlliance("武当 向你挑战！！");
        emei.sendAlliance("峨眉 想你挑战！！");
        shaolin.sendAlliance("接受你的挑战！！");
    }

}

//武林盟主，抽象中介者角色
abstract class WulinMediator{
    public abstract void notice(String message,United united);
}
//门派类，抽象同事类
abstract class United{
    protected WulinMediator wulinMediator;
    public United(WulinMediator wulinMediator){
        this.wulinMediator = wulinMediator;
    }
    public abstract void sendAlliance(String message);
    public abstract void getNotice(String message);
}

class Wudang extends United{
    public Wudang(WulinMediator wulinMediator) {
        super(wulinMediator);
    }

    @Override
    public void sendAlliance(String message) {
        wulinMediator.notice(message,this);
    }

    @Override
    public void getNotice(String message) {
        System.out.println("武当派收到消息：" + message);
    }
}

class Emei extends United{
    public Emei(WulinMediator wulinMediator) {
        super(wulinMediator);
    }

    @Override
    public void sendAlliance(String message) {
        wulinMediator.notice(message,this);
    }

    @Override
    public void getNotice(String message) {
        System.out.println("峨眉派收到消息：" + message);
    }
}

class Shaolin extends United{
    public Shaolin(WulinMediator wulinMediator) {
        super(wulinMediator);
    }

    @Override
    public void sendAlliance(String message) {
        wulinMediator.notice(message,this);
    }

    @Override
    public void getNotice(String message) {
        System.out.println("少林派收到消息：" + message);
    }
}

class WulinAlliance extends WulinMediator{

    Wudang wudang;
    Emei emei;
    Shaolin shaolin;

    public void setWudang(Wudang wudang) {
        this.wudang = wudang;
    }

    public void setEmei(Emei emei) {
        this.emei = emei;
    }

    public void setShaolin(Shaolin shaolin) {
        this.shaolin = shaolin;
    }

    @Override
    public void notice(String message, United united) {
        if (united == wudang){
            shaolin.getNotice(message);
        }else if (united == emei){
            shaolin.getNotice(message);
        }else {
            wudang.getNotice(message);
            emei.getNotice(message);
        }
    }
}





