package abstractfactory.v1.bread.color;


import abstractfactory.v1.bread.Bread;

public abstract class AbstractPolarBearBread implements Bread {
    @Override
    public void getColor() {
        System.out.println("烤的时间有点短的--北极熊面包");
    }
}
