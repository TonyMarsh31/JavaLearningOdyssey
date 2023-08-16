package factory.universal.product;

/**
 * 具体的产品可以有多个，都实现抽象产品接口
 */
public class ConcreteProduct2 implements Product {
    @Override
    public void method() {
        //具体业务逻辑处理，例如
        System.out.println("具体产品2显示……");
    }
}
