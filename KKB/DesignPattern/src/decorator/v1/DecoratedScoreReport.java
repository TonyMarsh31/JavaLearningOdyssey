package decorator.v1;

public class DecoratedScoreReport extends MyScoreReport {
    public void reportHighestScore() {
        System.out.println("这次考试最高分也才78分");
    }

    public void reportSort() {
        System.out.println("我在班级的排名是前20名");
    }

    @Override
    public void show() {
        super.show();
        this.reportHighestScore();
        this.reportSort();
    }
}
