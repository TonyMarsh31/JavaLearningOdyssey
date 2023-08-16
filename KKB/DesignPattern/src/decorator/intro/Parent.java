package decorator.intro;

public class Parent {
    public static void main(String[] args) {
        ScoreReport scoreReport = new MyScoreReport();
        scoreReport.show();
        System.out.println("这成绩还想要签名吗？");
    }
}
