package lambda;

public class intro1 {
    public static void main(String[] args) {
        //老的写法 -- 创建匿名内部类
        Runnable runnable1 = new Runnable() {
            public void run() {
                System.out.println("Hello World");
            }
        };

        //使用lambda表达式重构上述代码
        Runnable runnable2 = () -> {
            System.out.println("Hello from Thread2");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
    }
}
