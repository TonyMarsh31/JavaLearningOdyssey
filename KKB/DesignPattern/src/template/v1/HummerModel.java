package template.v1;

public abstract class HummerModel {
    public abstract void start();

    public abstract void stop();

    public abstract void alarm();

    public abstract void engineBoom();

    //既然实现类中run方法的实现方式是一样的，所以可以抽取成一个方法，这样就可以避免重复的代码了。
    public void run() {
        start();
        engineBoom();
        alarm();
        stop();
    }

}
