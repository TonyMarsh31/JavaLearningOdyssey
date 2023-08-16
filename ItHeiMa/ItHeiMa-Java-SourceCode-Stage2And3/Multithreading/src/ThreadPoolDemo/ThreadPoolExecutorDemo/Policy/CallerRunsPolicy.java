package ThreadPoolDemo.ThreadPoolExecutorDemo.Policy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor.AbortPolicy:   当新任务被拒绝添加到队列中时，丢弃任务并抛出RejectedExecutionException异常。是默认的策略。<br>
 * ThreadPoolExecutor.DiscardPolicy:    当新任务被拒绝添加到队列中时，丢弃任务，但是不抛出异常 这是不推荐的做法.<br>
 * ThreadPoolExecutor.DiscardOldestPolicy:  当新任务被拒绝添加到队列中时，抛弃队列中等待最久的任务 然后把当前任务加入队列中。<br>
 * <u>ThreadPoolExecutor.CallerRunsPolicy:     当新任务被拒绝加入队列中时，调用任务的run()方法绕过线程池直接执行。即将任务交给本地线程执行，一般会是main线程</u><br>
 */
public class CallerRunsPolicy {
    public static void main(String[] args) {

        // 核心线程数量为1 ， 最大线程池数量为3, 任务容器的容量为1 ,空闲线程的最大存在时间为20s
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(1, 3, 20, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        // 提交5个任务
        for (int x = 0; x < 5; x++) {
            threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + "---->> 执行了任务"));
        }
        threadPoolExecutor.shutdown();
    }
}
