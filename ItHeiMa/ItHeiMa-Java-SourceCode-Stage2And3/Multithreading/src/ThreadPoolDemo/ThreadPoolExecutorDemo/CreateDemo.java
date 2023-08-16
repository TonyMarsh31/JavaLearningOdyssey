package ThreadPoolDemo.ThreadPoolExecutorDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 一个使用ThreadPoolExecutor线程池的代码示例<br>
 * 之前使用的cached与fixed线程池都是ThreadPoolExecutor的子类，是java预设好参数的,但是这个类是线程池的核心类,可以<u>自定义</u>线程池的各种参数，比如线程池的大小，任务队列的大小等等。
 */
public class CreateDemo {
    //参数一：核心线程数量
    //参数二：最大线程数
    //参数三：空闲线程最大存活时间
    //参数四：时间单位
    //参数五：任务队列
    //参数六：创建线程工厂
    //参数七：任务的拒绝策略
    public static void main(String[] args) {
        //corePoolSize：   核心线程的最大值，不能小于0
        //maximumPoolSize：最大线程数，不能小于等于0，maximumPoolSize >= corePoolSize
        //keepAliveTime：  空闲线程最大存活时间,不能小于0
        //unit：           时间单位
        //workQueue：      任务队列，不能为null
        //threadFactory：  创建线程工厂,不能为null
        //handler：        任务的拒绝策略,不能为null
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        pool.submit(() -> System.out.println(Thread.currentThread().getName() + "在执行了"));
        pool.submit(() -> System.out.println(Thread.currentThread().getName() + "在执行了"));

        pool.shutdown();
    }
}
