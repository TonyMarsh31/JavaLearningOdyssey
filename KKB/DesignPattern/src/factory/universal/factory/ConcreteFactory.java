package factory.universal.factory;

import factory.universal.product.Product;

/**
 * 具体工厂：具体如何生产一个产品的对象，是由具体的工厂类实现的
 */
public class ConcreteFactory extends AbstractFactory {
    @Override
    public <T extends Product> T createProduct(Class<T> tClass) {
        Product product = null;
        try {
            product = (T) Class.forName(tClass.getName()).newInstance();
        } catch (Exception e) {
            //异常处理
        }
        return (T) product;
    }
}
