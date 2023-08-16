package builder.universal;

/**
 * 指挥者 调用建造者中的方法完成复杂对象的创建。
 */
public class Decider {
    private Builder builder;

    public Decider(Builder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法:设置不同的零件，生成不同的产品
    public Product constructA() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.buildProduct();
    }

    public Product constructB() {
        builder.buildPartB();
        builder.buildPartA();
        builder.buildPartC();
        return builder.buildProduct();
    }
}
