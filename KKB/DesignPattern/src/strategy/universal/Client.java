package strategy.universal;

public class Client {
    public static void main(String[] args) {
        Strategy s = new ConcreteStrategyA();
        Context c = new Context(s);
        c.strategyMethod();
        System.out.println("-----------------");
        s = new ConcreteStrategyB();
        c = new Context(s);
        c.strategyMethod();
    }
}
