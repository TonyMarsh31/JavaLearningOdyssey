package ThreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 一个使用FixedThreadPool线程池的代码示例,参数为线程池中线程的最大个数
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        //注意参数不是初始值而是最大值
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;//向下转型,使用该对象中的一些静态方法,可以获取线程池的一些信息
        System.out.println(pool.getPoolSize());//0

        pool.submit(() -> System.out.println(Thread.currentThread().getName() + "在执行了"));
        pool.submit(() -> System.out.println(Thread.currentThread().getName() + "在执行了"));

        System.out.println(pool.getPoolSize());//2
        //可以多添加几个任务,最终效果是线程池中的线程数不会超过10个
        pool.shutdown();
    }
}
