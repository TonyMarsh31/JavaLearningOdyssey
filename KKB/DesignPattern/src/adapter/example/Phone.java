package adapter.example;

public class Phone {
    private ThreePower threePower; //期待三项充电

    public Phone(ThreePower threePower) {
        this.threePower = threePower;
    }

    public static void main(String[] args) {
        //现在只有两项插座供电
        TwoPower twoPower = new TwoPower();
        //通过适配器转换
        ThreePower threePower = new TwoToThreeAdapter(twoPower);
        Phone phone = new Phone(threePower);
        // 充电
        phone.recharge();
        // 拍照
        phone.takePicture();
    }

    public void recharge() {
        threePower.powerByThree();
        System.out.println("手机通过三项插座充电中-------------");
    }

    public void takePicture() {
        System.out.println("拍了一张照片");
    }
}
