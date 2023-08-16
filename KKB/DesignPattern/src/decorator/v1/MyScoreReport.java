package decorator.v1;

public class MyScoreReport extends ScoreReport {
    @Override
    public void show() {
        System.out.println("尊敬的家长，您的孩子的成绩如下，请阅读后在后面的家长处签名：");
        System.out.println("语文：60");
        System.out.println("数学：61");
        System.out.println("英语：62");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名：" + name);
    }
}
