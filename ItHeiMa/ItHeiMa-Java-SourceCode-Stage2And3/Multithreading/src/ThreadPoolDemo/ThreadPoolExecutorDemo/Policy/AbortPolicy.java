package ThreadPoolDemo.ThreadPoolExecutorDemo.Policy;

import java.util.concurrent.*;

/**
 * <u>ThreadPoolExecutor.AbortPolicy:   丢弃任务并抛出RejectedExecutionException异常。是默认的策略。</u><br>
 * ThreadPoolExecutor.DiscardPolicy:    丢弃任务，但是不抛出异常 这是不推荐的做法。<br>
 * ThreadPoolExecutor.DiscardOldestPolicy:  抛弃队列中等待最久的任务 然后把当前任务加入队列中。<br>
 * ThreadPoolExecutor.CallerRunsPolicy:     调用任务的run()方法绕过线程池直接执行。<br>
 */
public class AbortPolicy {
    public static void main(String[] args) {
        //核心线程数量为1,最大线程池数量为3, 任务容器的容量为1 ,空闲线程的最大存在时间为20s
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 20, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 提交5个任务，而该线程池最多可以处理4个任务(任务队列数+最大线程数)，当我们使用AbortPolicy这个任务处理策略的时候，就会抛出异常
        try {
            for (int x = 0; x < 5; x++) {
                threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + "---->> 执行了任务"));
            }
        } catch (RejectedExecutionException e) {
            System.out.println("有任务被拒绝了");
            //异常处理逻辑……
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
