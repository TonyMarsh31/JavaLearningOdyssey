package decorator.universal;

public class ConcreteDecoratorB extends Decorator {
    //定义被修饰者
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void method2() {
        System.out.println("B修饰");
    }

    @Override
    public void operation() {
        this.method2();
        super.operation();
    }
}
