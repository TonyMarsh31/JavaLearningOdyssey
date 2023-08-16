package strategy.v2;

public class AirStrategy implements TravelStrategy {
    @Override
    public void travelType() {
        System.out.println("乘坐飞机出行---------");
    }
}
