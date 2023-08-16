package proxy.universal;

/**
 * 具体主体类
 */
public class ConcreteSubject implements Subject {
    @Override
    public void request() {
        //业务逻辑处理
        System.out.println("具体主体类的业务逻辑处理");
    }
}
