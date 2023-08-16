package abstractfactory.v1.bread.color;


import abstractfactory.v1.bread.Bread;

public abstract class AbstractBlackBearBread implements Bread {
    @Override
    public void getColor() {
        System.out.println("烤的时间有点长的--黑熊面包");
    }
}
