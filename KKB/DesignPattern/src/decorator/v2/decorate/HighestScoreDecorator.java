package decorator.v2.decorate;

import decorator.v2.ScoreReport;

public class HighestScoreDecorator extends Decorator {
    public HighestScoreDecorator(ScoreReport scoreReport) {
        super(scoreReport);
    }

    private void reportHighestScore() {
        System.out.println("这次考试最高分也才78分");
    }

    @Override
    public void show() {
        super.show();
        this.reportHighestScore();
    }
}
