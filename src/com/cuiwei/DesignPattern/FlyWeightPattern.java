package com.cuiwei.DesignPattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by cuiwei on 2018/9/21
 * 享元模式
 */
public class FlyWeightPattern {
    public static void main(String[] args) {
        CharatorFactory factory = new CharatorFactory();

        FlyWeight a = factory.getCharator("A");
        a.operator(16);
        a.displayCharator();

        FlyWeight b= factory.getCharator("B");
        b.operator(11);
        b.displayCharator();

    }
}

abstract class FlyWeight{
    protected String charStr = "";
    protected int fontSize;

    protected abstract void operator(int fontSize);
    protected abstract void displayCharator();
}

class FlyWeightAiml extends FlyWeight{

    public FlyWeightAiml(){
        this.charStr = "A";
        this.fontSize = 12;
    }

    @Override
    protected void operator(int fontSize) {
        this.fontSize =fontSize;
    }

    @Override
    protected void displayCharator() {
        System.out.println("字符： " + charStr + "，字体大小：" + fontSize);
    }
}

class FlyWeightBiml extends FlyWeight{

    public FlyWeightBiml(){
        this.charStr = "B";
        this.fontSize = 12;
    }

    @Override
    protected void operator(int fontSize) {
        this.fontSize =fontSize;
    }

    @Override
    protected void displayCharator() {
        System.out.println("字符： " + charStr + "，字体大小：" + fontSize);
    }
}

class CharatorFactory{
    private Map<String,FlyWeight> charactors = new ConcurrentHashMap<>();
    public CharatorFactory(){
        charactors.put("A",new FlyWeightAiml());
        charactors.put("B",new FlyWeightBiml());
    }

    public FlyWeight getCharator(String key){
        FlyWeight charactor = charactors.get(key);
        if (charactor == null){
            if ("A".equals(key)){
                charactor = new FlyWeightAiml();
            }else if ("B".equals(key)){
                charactor = new FlyWeightBiml();
            }
            charactors.put(key,charactor);
        }
        return charactor;
    }
}
