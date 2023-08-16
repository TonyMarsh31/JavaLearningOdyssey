package factory.universal;

import factory.universal.factory.AbstractFactory;
import factory.universal.factory.ConcreteFactory;
import factory.universal.product.ConcreteProduct1;
import factory.universal.product.Product;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        Product product = factory.createProduct(ConcreteProduct1.class);
        //继续处理其他业务……

    }
}
