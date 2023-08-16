package factory.v1.bread.impl;

import factory.v1.bread.Bread;

public class BlackBearBread implements Bread {
    @Override
    public void getColor() {
        System.out.println("烤的时间有点长的-----黑熊面包！！！");
    }
}
