package strategy.v2;

public class CarStrategy implements TravelStrategy {
    @Override
    public void travelType() {
        System.out.println("乘坐汽车出行---------");
    }
}
