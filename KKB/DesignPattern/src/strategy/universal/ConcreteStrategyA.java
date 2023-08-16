package strategy.universal;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("策略A实现");
    }
}
