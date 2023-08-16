package factory.universal.factory;

import factory.universal.product.Product;

/**
 * 抽象工厂：负责定义产品对象的产生
 */
public abstract class AbstractFactory {
    //创建一个产品对象，输入的参数类型可以自定义
    public abstract <T extends Product> T createProduct(Class<T> tClass);
}
