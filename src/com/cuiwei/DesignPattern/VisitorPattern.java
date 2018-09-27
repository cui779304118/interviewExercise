package com.cuiwei.DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * created by cuiwei on 2018/9/25
 * 访问者模式
 */
public class VisitorPattern {

    public static void main(String[] args) {
        ConcreteElementA elementA = new ConcreteElementA("elementA");
        ConcreteElementB elementB = new ConcreteElementB("elementB");
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(elementA);
        objectStructure.attach(elementB);

        Visitor visitorA = new VisitorA();
        objectStructure.accept(visitorA);
        Visitor visitorB = new VisitorB();
        objectStructure.accept(visitorB);
    }

}

abstract class Element{
    protected String name;
    public Element(String name){
        this.name = name;
    }
    public abstract void accept(Visitor visitor);

    public String getName() {
        return name;
    }
}

class ConcreteElementA extends Element{
    public ConcreteElementA(String name) {
        super(name);
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }
}
class ConcreteElementB extends Element{
    public ConcreteElementB(String name) {
        super(name);
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementB(this);
    }
}

interface Visitor{
    void visitElementA(ConcreteElementA concreteElementA);
    void visitElementB(ConcreteElementB concreteElementB);
}

class VisitorA implements Visitor{
    @Override
    public void visitElementA(ConcreteElementA concreteElementA) {
        System.out.println("visitorA 访问" + concreteElementA.getName());
    }

    @Override
    public void visitElementB(ConcreteElementB concreteElementB) {
        System.out.println("visitorA 访问" + concreteElementB.getName());
    }
}
class VisitorB implements Visitor{
    @Override
    public void visitElementA(ConcreteElementA concreteElementA) {
        System.out.println("VisitorB 访问" + concreteElementA.getName());
    }

    @Override
    public void visitElementB(ConcreteElementB concreteElementB) {
        System.out.println("VisitorB 访问" + concreteElementB.getName());
    }
}

class ObjectStructure{
    private List<Element> elements = new ArrayList<>();

    public void attach(Element element){
        this.elements.add(element);
    }

    public void detach(Element element){
        this.elements.remove(element);
    }

    public void accept(Visitor visitor){
        for (Element element : elements){
            element.accept(visitor);
        }
    }
}



