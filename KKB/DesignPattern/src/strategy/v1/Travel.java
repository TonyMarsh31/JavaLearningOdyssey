package strategy.v1;

public class Travel {
    public void travelType(String type) {
        switch (type) {
            case "飞机":
                byAir();
                break;
            case "火车":
                byTrain();
                break;
            case "汽车":
                byCar();
                break;
            default:
                error();
                break;
        }
    }

    public void byAir() {
        System.out.println("飞机");
    }

    public void byTrain() {
        System.out.println("火车");
    }

    public void byCar() {
        System.out.println("汽车");
    }

    public void error() {
        System.out.println("错误");
    }

}
