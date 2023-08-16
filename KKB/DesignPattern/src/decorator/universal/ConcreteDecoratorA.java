package decorator.universal;

/**
 * 具体装饰者A
 */
public class ConcreteDecoratorA extends Decorator {
    //定义被修饰这
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void method1() {
        System.out.println("A修饰");
    }

    @Override
    public void operation() {
        this.method1();
        super.operation();
    }
}
