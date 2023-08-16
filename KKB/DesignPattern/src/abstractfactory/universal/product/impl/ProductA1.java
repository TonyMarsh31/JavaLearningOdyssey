package abstractfactory.universal.product.impl;

import abstractfactory.universal.product.AbstractProductA;

public class ProductA1 extends AbstractProductA {
    @Override
    public void doSomething() {
        System.out.println("ProductA1's method");
    }
}
