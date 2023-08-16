package abstractfactory.v1.factory;

import abstractfactory.v1.bread.Bread;

public interface BreadFactory {
    //创建北极熊面包
    Bread createPolarBearBread();

    //创建黑熊面包
    Bread createBlackBearBread();

    //创建布朗熊面包
    Bread createBrownBearBread();
}
