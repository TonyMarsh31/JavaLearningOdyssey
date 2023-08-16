package decorator.v2;

import decorator.v2.decorate.HighestScoreDecorator;
import decorator.v2.decorate.SortDecorator;

public class Parent {
    public static void main(String[] args) {
        //拿到原始成绩单
        ScoreReport report = new MyScoreReport();
        //装饰1，加了最高成绩修饰到的成绩单
        report = new HighestScoreDecorator(report);
        report.show();
        report.sign("张三");
        System.out.println();
        //装饰2，加了成绩排名
        report = new SortDecorator(report);
        report.show();
    }
}
