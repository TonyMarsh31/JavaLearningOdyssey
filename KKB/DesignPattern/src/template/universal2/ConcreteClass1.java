package template.universal2;

public class ConcreteClass1 extends AbstractClass {
    //实现基本方法
    protected void doSomething() {
        //处理业务逻辑
    }

    protected void doAnything() {
        //处理业务逻辑
    }

    public void HookMethod1() {
        System.out.println("钩子方法1被重写...");
    }

    public boolean HookMethod2() {
        return false;
    }
}
