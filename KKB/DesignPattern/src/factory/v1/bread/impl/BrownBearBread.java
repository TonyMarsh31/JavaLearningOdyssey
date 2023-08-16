package factory.v1.bread.impl;

import factory.v1.bread.Bread;

public class BrownBearBread implements Bread {
    @Override
    public void getColor() {
        System.out.println("烤的时间刚刚好的-----布朗熊面包！！！");
    }
}
