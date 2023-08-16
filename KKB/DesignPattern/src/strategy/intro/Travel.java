package strategy.intro;

public class Travel {
    public void travelType(String type) {
        switch (type) {
            case "飞机":
                System.out.println("飞机");
                break;
            case "火车":
                System.out.println("火车");
                break;
            case "汽车":
                System.out.println("汽车");
                break;
            default:
                System.out.println("错误");
                break;
        }
    }
}
