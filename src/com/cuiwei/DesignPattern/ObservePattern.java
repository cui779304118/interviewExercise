package com.cuiwei.DesignPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * created by cuiwei on 2018/9/27
 * 观察者模式
 */
public class ObservePattern {

    public static void main(String[] args) {
        ProductList productList = ProductList.getInstance();
        Observer taobao = new TaobaoObserver();
        Observer jingdong = new JingDongObserver();

        productList.addObserver(taobao);
        productList.addObserver(jingdong);

        for (int i = 0; i <5 ; i++) {
            productList.addProduct("产品【" + (i+1) + "】");
        }
    }


}
class ProductList extends Observable{
    private List<String> productList = new ArrayList<>();//产品类
    private static volatile ProductList instance;

    private ProductList(){}

    public static ProductList getInstance(){
        if (instance == null){
            synchronized (ProductList.class){
                if (instance == null){
                    instance = new ProductList();
                }
            }
        }
        return instance;
    }

    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品列表新增加产品： " + newProduct);
        this.setChanged();//设置被观察者状态变化
        this.notifyObservers(newProduct);//通知观察者，并传递产品信息
    }
}

class TaobaoObserver implements Observer{
    @Override
    public void update(Observable o, Object newProduct) {
        String product = (String) newProduct;
        System.out.println("发送新产品【" + product + "】同步到淘宝商城！");
    }
}
class JingDongObserver implements Observer{
    @Override
    public void update(Observable o, Object newProduct) {
        String product = (String) newProduct;
        System.out.println("发送新产品【" + product + "】同步到京东商城！");
    }
}