package decorator.v2.decorate;

import decorator.v2.ScoreReport;

public class SortDecorator extends Decorator {
    public SortDecorator(ScoreReport scoreReport) {
        super(scoreReport);
    }

    private void reportSort() {
        System.out.println("这次考试我的成绩排名是第一名");
    }

    @Override
    public void show() {
        super.show();
        this.reportSort();
    }
}
