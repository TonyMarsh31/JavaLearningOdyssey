package strategy.v2;

public class Traveler {
    //出行策略
    private final TravelStrategy travelStrategy;
    //设定出行策略

    public Traveler(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void travelStyle() {
        travelStrategy.travelType();
    }
}
