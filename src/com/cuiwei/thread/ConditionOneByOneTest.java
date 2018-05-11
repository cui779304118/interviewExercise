package com.cuiwei.thread;

public class ConditionOneByOneTest {
    public static void main(String[] args) {
        ConditionOnebyOneService service = new ConditionOnebyOneService();
        for (int i = 0; i <5 ; i++) {
            ConditionOneThreadGet threadGet = new ConditionOneThreadGet(service);
            ConditionOneThreadSet threadSet = new ConditionOneThreadSet(service);
            threadSet.start();
            threadGet.start();
        }
    }
}
