package builder.universal;

/**
 * 产品类，包含多个组成部件的复杂对象
 */
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void doSomething() {
        //独立业务处理
    }
}
