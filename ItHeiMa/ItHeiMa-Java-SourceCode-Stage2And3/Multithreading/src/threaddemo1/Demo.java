package threaddemo1;

//展示多线程执行的特点:交替执行
public class Demo {
    public static void main(String[] args) {
        //创建一个线程对象
        MyThread t1 = new MyThread();
        //创建一个线程对象
        MyThread t2 = new MyThread();

        //run()表示的仅仅是创建对象,用对象去调用方法,并没有开启线程.
        //t1.run();
        //t2.run();
        //开启一条线程 进入start内部，你会看到其是被native修饰的方法
        t1.start();
        //开启第二条线程
        t2.start();
    }
}
