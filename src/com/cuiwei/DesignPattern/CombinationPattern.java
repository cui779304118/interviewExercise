package com.cuiwei.DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * created by cuiwei on 2018/9/17
 * 组合模式示例
 * 公司组织架构
 */
public class CombinationPattern {
    public static void main(String[] args) {
        Company totalCompany = new ConcretCompany("北京总公司");
        totalCompany.add(new Department("总公司研究中心"));
        totalCompany.add(new Department("总公司财务中心"));
        totalCompany.add(new Department("总公司人力资源中心"));

        Company shCompany = new ConcretCompany("上海分公司");
        shCompany.add(new Department("上海分公司研发中心"));
        shCompany.add(new Department("上海分公司财务中心"));
        shCompany.add(new Department("上海分公司人力资源中心"));
        totalCompany.add(shCompany);

        Company szCompany = new ConcretCompany("深圳分公司");
        szCompany.add(new Department("深圳分公司研发中心"));
        szCompany.add(new Department("深圳分公司财务中心"));
        szCompany.add(new Department("深圳分公司人力资源中心"));
        totalCompany.add(szCompany);

        totalCompany.display(1);
        totalCompany.duty();

    }

}

abstract class Company{
    protected  String name;
    public Company(String name){
        this.name = name;
    }

    public abstract void add(Company c);
    public abstract void remove(Company c);
    public abstract void display(int depth);
    public abstract void duty();
}

class ConcretCompany extends Company{

    private List<Company> subCompanys = new ArrayList<>();

    public ConcretCompany(String name){
        super(name);
    }

    @Override
    public void add(Company c) {
        subCompanys.add(c);
    }

    @Override
    public void remove(Company c) {
        subCompanys.remove(c);
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth ; i++) {
            System.out.print("-");
        }
        System.out.println(name);
        for (Company c : subCompanys){
            c.display(depth + 2);
        }
    }

    @Override
    public void duty() {
        for (Company c : subCompanys){
            c.duty();
        }
    }
}

class Department extends Company{
    public Department(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {
        System.out.println("该方法不存在！");
    }

    @Override
    public void remove(Company c) {
        System.out.println("该方法不存在！");
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth ; i++) {
            System.out.print("-");
        }
        System.out.println(name);
    }

    @Override
    public void duty() {
        System.out.println(name + "执行任务！");
    }
}
