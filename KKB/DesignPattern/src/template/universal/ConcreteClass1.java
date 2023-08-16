package template.universal;

public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("ConcreteClass1 doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("ConcreteClass1 doAnything");
    }

    @Override
    protected void specificMethod() {
        System.out.println("ConcreteClass1 specificMethod");
    }
}
