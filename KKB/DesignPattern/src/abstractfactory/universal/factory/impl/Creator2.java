package abstractfactory.universal.factory.impl;

import abstractfactory.universal.factory.AbstractCreator;
import abstractfactory.universal.product.AbstractProductA;
import abstractfactory.universal.product.AbstractProductB;
import abstractfactory.universal.product.AbstractProductC;
import abstractfactory.universal.product.impl.ProductA2;
import abstractfactory.universal.product.impl.ProductB2;
import abstractfactory.universal.product.impl.ProductC2;

public class Creator2 extends AbstractCreator {
    @Override//只生成产品等级为2的A产品
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override//只生成产品等级为2的B产品
    public AbstractProductB createProductB() {
        return new ProductB2();
    }

    @Override//只生成产品等级为2的C产品
    public AbstractProductC createProductC() {
        return new ProductC2();
    }
}
