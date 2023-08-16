package abstractfactory.v1.bread.color;


import abstractfactory.v1.bread.Bread;

public abstract class AbstractBrownBearBread implements Bread {
    @Override
    public void getColor() {
        System.out.println("烤的时间刚刚好的--布朗熊面包");
    }
}
