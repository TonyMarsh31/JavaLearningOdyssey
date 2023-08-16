package builder.universal;

public class Client {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Decider decider = new Decider(builder);
        Product a = decider.constructA();
        Product b = decider.constructB();
        a.doSomething();
        b.doSomething();
    }
}
