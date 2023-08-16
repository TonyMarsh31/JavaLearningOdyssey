package decorator.v1;

public class Parent {
    public static void main(String[] args) {
        ScoreReport scoreReport = new DecoratedScoreReport();
        scoreReport.show();
        scoreReport.sign("张三");
    }
}
