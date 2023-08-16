package builder.universal;

/**
 * 具体建造者 实现了抽象建造者接口。
 */
public class ConcreteBuilder extends Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("建造PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建造PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建造PartC");
    }

    //组装一个完整的产品
    @Override
    public Product buildProduct() {
        return product;
    }
}
