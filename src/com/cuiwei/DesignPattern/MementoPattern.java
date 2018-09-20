package com.cuiwei.DesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by cuiwei on 2018/9/18
 * 备忘录模式
 */
public class MementoPattern {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretake caretake = new Caretake(originator);

        originator.setStates("state0");//设置状态
        caretake.createMemento();//备份
        originator.setStates("state1");//添加状态
        caretake.createMemento();//备份
        originator.setStates("state2");//添加状态
        caretake.createMemento();//备份
        originator.setStates("state3");//添加状态
        caretake.createMemento();//备份
        originator.setStates("state4");//添加状态
        caretake.createMemento();//备份

        //打印当前所有状态
        originator.printStates();

        System.out.println("恢复状态到: 3");
        caretake.restoreMemento(3);
        originator.printStates();

        System.out.println("恢复状态到: 2");
        caretake.restoreMemento(2);
        originator.printStates();

        System.out.println("恢复状态到: 4");
        caretake.restoreMemento(4);
        originator.printStates();

    }

}

//标志接口（窄接口），提供给Caretake，防止Caretake对其直接进行操作
interface MementoIF{}
class Originator{
    private ArrayList<Object> states;//需要保存的状态
    private int index;//当前状态对应的序号

    public Originator(){
        states = new ArrayList<>();
        index = 0;
    }

    //当前状态创建快照备份
    public MementoIF createMemento(){
        return new Memento(this.states,index);
    }
    //用memento恢复当前状态和序号
    public void restoreMemento(MementoIF memento){
        this.states = ((Memento) memento).getStates();
        this.index = ((Memento) memento).getIndex();
    }
    //添加状态
    public void setStates(Object state){
        this.states.add(state);
        index++;
    }
    //打印当前状态
    public void printStates(){
        System.out.println("Total number of states:" + index);
        System.out.println(Arrays.toString(states.toArray()));
    }

    //备忘录，用于保存当前的状态
    protected class Memento implements  MementoIF{
        private ArrayList<Object> saveStates;
        private int saveIndex;

        private Memento(ArrayList<Object> states, int index){
            this.saveStates = (ArrayList<Object>) states.clone();
            this.saveIndex = index;
        }

        private ArrayList<Object> getStates(){
            return this.saveStates;
        }

        private int getIndex(){
            return saveIndex;
        }
    }
}
//备忘录管理类，用于备份和恢复，并且保存备忘录
class Caretake{
    private Originator o;
    private List<MementoIF> mementos = new ArrayList<>();//保存备忘录
    private int currentIndex;//当前有多少个状态

    public Caretake(Originator o){
        this.o = o;
        currentIndex = 0;
    }

    //创建备忘录
    public void createMemento(){
        mementos.add(o.createMemento());
        currentIndex++;
    }

    //恢复到某个备忘录的状态
    public void restoreMemento(int index){
        o.restoreMemento(mementos.get(index));
    }
    //删除某个状态的备忘录
    public void removeMemento(int index){
        mementos.remove(index);
    }
}
