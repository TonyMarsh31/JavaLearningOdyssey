package ThreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个使用JDKExecutor线程池的代码示例
 */
public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        //1.创建一个默认的线程池对象，池子中默认是空的，默认最多可以容纳int类型的最大值个线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        //Executors -- 工具类，用来创建线程池对象
        //ExecutorService -- 线程池接口，用来从线程池中获取线程，调用start方法，执行线程任务

        //submit方法用来提交线程任务，线程池会开启一个线程，执行线程任务
        //submit方法的参数是一个Runnable接口的实现类对象
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));

        executorService.shutdown();
    }
}
