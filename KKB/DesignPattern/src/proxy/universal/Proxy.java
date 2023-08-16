package proxy.universal;

/**
 * 代理类，代理模式的核心就在这个类中
 */
public class Proxy implements Subject {
    //要代理的主体对象
    private Subject subject = null;

    //通过构造方法传入要代理的主体对象
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        preRequest();
        subject.request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("代理前的预处理");
    }

    public void postRequest() {
        System.out.println("代理后的处理");
    }
}
