package com.cuiwei.DesignPattern;

/**
 * created by cuiwei on 2018/9/13
 * 状态模式：状态模式是策略模式的孪生兄弟，是因为它们的UML图是一样的，但意图却完全不一样，
 * 策略模式是让用户指定更换的策略算法，而状态模式是状态在满足一定条件下的自动更换，
 * 用户无法指定状态，最多只能设置初始状态。
 * 以水桶的状态作为例子，水桶有三个状态，FULL_SATE,NULL_STATE,FILL_STATIE;
 */
public class StatePattern {

    public static void main(String[] args) {
        WaterDispenser dispenser = new WaterDispenser(10,new FullState());
        for (int i = 0; i < 40; i++) {
            dispenser.press();
        }
    }
}

class WaterDispenser{
    private int capacity;
    private State state;

    public WaterDispenser(int capacity,State state){
        this.capacity = capacity;
        this.state = state;
    }

    public void setState(State state){
        this.state = state;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    //压水动作
    public void press(){
        state.press(this);
    }
}

interface State{
    void press(WaterDispenser dispenser);
}

class FullState implements State{
    @Override
    public void press(WaterDispenser dispenser) {
        int capacity = dispenser.getCapacity();
        capacity--;
        dispenser.setCapacity(capacity);
        if (capacity > 0)
            System.out.println("水桶不为空！当前容量为：" + capacity + "L");
        else {
            dispenser.setState(new NullState());
            dispenser.press();
        }
    }
}

class NullState implements State{
    @Override
    public void press(WaterDispenser dispenser) {
        int capacity = dispenser.getCapacity();
        if (capacity <= 0) {
            System.out.println("水桶为空！");
            dispenser.setState(new FILLState());
        } else {
            dispenser.setState(new FullState());
            dispenser.press();
        }
    }
}

class FILLState implements State{
    @Override
    public void press(WaterDispenser dispenser) {
        int capacity = dispenser.getCapacity();
        if (capacity < 10){
            capacity++;
            dispenser.setCapacity(capacity);
            System.out.println("装入水中,当前水容量为" + capacity + "L" );
        } else {
            dispenser.setState(new FullState());
            dispenser.press();
        }
    }
}
