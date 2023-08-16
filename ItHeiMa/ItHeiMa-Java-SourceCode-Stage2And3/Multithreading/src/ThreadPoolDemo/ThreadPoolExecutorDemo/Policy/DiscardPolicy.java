package ThreadPoolDemo.ThreadPoolExecutorDemo.Policy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor.AbortPolicy:   丢弃任务并抛出RejectedExecutionException异常。是默认的策略。<br>
 * <u>ThreadPoolExecutor.DiscardPolicy:    丢弃任务，但是不抛出异常 这是不推荐的做法.</u><br>
 * ThreadPoolExecutor.DiscardOldestPolicy:  抛弃队列中等待最久的任务 然后把当前任务加入队列中。<br>
 * ThreadPoolExecutor.CallerRunsPolicy:     调用任务的run()方法绕过线程池直接执行。<br>
 */
public class DiscardPolicy {
    public static void main(String[] args) {

        //核心线程数量为1 ， 最大线程池数量为3, 任务容器的容量为1 ,空闲线程的最大存在时间为20s
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 20, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        // 提交5个任务，而该线程池最多可以处理4个任务，当我们使用DiscardPolicy这个任务处理策略的时候，控制台不会报错
        // 并不推荐这个策略，因为任务丢失的时候没有任何提示
        try {
            for (int x = 0; x < 5; x++) {
                threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + "---->> 执行了任务"));
            }
        } catch (Exception e) {
            System.out.println("出现异常了");//仅做演示，实际开发环境中不推荐直接输入到控制台，而是使用日志系统
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
