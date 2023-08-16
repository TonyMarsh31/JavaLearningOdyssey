package template.universal;

/**
 * 抽象模板类
 */
public abstract class AbstractClass {
    //基本方法：抽象方法1
    protected abstract void doSomething();

    //基本方法：抽象方法2
    protected abstract void doAnything();

    //基本方法：具体方法
    protected void specificMethod() {
        //具体方法的业务逻辑
    }

    //模板方法
    public void templateMethod() {
        //调用基本方法，完成相关逻辑
        this.specificMethod();
        this.doSomething();
        this.doAnything();
    }
}
