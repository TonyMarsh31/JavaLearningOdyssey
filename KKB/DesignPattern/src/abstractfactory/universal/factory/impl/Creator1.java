package abstractfactory.universal.factory.impl;

import abstractfactory.universal.factory.AbstractCreator;
import abstractfactory.universal.product.AbstractProductA;
import abstractfactory.universal.product.AbstractProductB;
import abstractfactory.universal.product.AbstractProductC;
import abstractfactory.universal.product.impl.ProductA1;
import abstractfactory.universal.product.impl.ProductB1;
import abstractfactory.universal.product.impl.ProductC1;

/**
 * 产品等级实现类：
 * 有M个产品等级就应该有M个工厂的实现类，在每个实现工厂中，实现不同产品族的生产业务。
 */
public class Creator1 extends AbstractCreator {
    @Override//只生成产品等级为1的A产品
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override//只生成产品等级为1的B产品
    public AbstractProductB createProductB() {
        return new ProductB1();
    }

    @Override//只生成产品等级为1的C产品
    public AbstractProductC createProductC() {
        return new ProductC1();
    }
}
