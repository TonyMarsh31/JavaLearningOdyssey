package abstractfactory.v1.bread;

public interface Bread {
    //每个面包都有不同的颜色
    void getColor();

    //每个面包都有不同的类型 （面包是什么馅儿的）
    void getType();
}
