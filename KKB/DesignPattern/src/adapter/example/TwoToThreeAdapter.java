package adapter.example;

public class TwoToThreeAdapter implements ThreePower {
    private TwoPower twoPower;

    public TwoToThreeAdapter(TwoPower twoPower) {
        this.twoPower = twoPower;
    }

    @Override
    public void powerByThree() {
        twoPower.powerByTwo();
        System.out.println("插头通过Adapter转换为三项供电");
    }
}
