package decorator.v2.decorate;

import decorator.v2.ScoreReport;

/**
 * 专门负责装饰的类
 */
public class Decorator extends ScoreReport {
    private ScoreReport scoreReport;

    public Decorator(ScoreReport scoreReport) {
        this.scoreReport = scoreReport;
    }

    @Override
    public void show() {
        scoreReport.show();
    }

    @Override
    public void sign(String name) {
        scoreReport.sign(name);
    }
}
