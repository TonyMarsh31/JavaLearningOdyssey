package ThreadPoolDemo.ThreadPoolExecutorDemo.Policy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor.AbortPolicy:   当新任务被拒绝添加到队列中时，丢弃任务并抛出RejectedExecutionException异常。是默认的策略。<br>
 * ThreadPoolExecutor.DiscardPolicy:    当新任务被拒绝添加到队列中时，丢弃任务，但是不抛出异常 这是不推荐的做法.<br>
 * <u>ThreadPoolExecutor.DiscardOldestPolicy:  当新任务被拒绝添加到队列中时，抛弃队列中等待最久的任务 然后把当前任务加入队列中。</u><br>
 * ThreadPoolExecutor.CallerRunsPolicy:     当新任务被拒绝加入队列中时，调用任务的run()方法绕过线程池直接执行。<br>
 */
public class DiscardOldestPolicy {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor;
        //核心线程数量为1 ， 最大线程池数量为3, 任务容器的容量为1 ,空闲线程的最大存在时间为20s
        threadPoolExecutor = new ThreadPoolExecutor(1, 3, 20, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        // 提交5个任务
        try {
            for (int x = 0; x < 5; x++) {
                // 定义一个变量，来指定指定当前执行的任务;这个变量需要被final修饰
                int taskNo = x;
                threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + "---->> 执行了任务" + taskNo));
                // 运行结果解释：
                // 任务0是第一个任务，直接创建线程然后执行，
                // 到任务1的时候，此时的线程池唯一的线程在执行任务0，没有多余线程了，同时线程数没达到maximumPoolSize，所以创建新的线程
                // 而创建线程这一操作是需要开销的，所以任务1最先进入任务队列
                // 之后其他任务又加入到队列中来的，因为队列容量只有1，所以此时最先加入的任务1成为了oldestTask被抛弃，
                // 此时队列中的任务为任务2，而新线程这时候应该已经创建好了，同时任务0可能也执行完毕了，所以任务2大概率有空闲线程可以执行，所以正常出列
                // 之后的任务3和4由于线程池中的线程数量多了起来，所以也大概率可以正常执行了，不需要抛弃
                // 最终结果就是任务0执行，任务1被抛弃，2、3、4看电脑性能，一般都会被执行

                // 更新：
                // 其实这一个例子不是很直观，你可以试着把任务容器的容量改大一点，然后提交的任务数量也多一点
                // 比如提交25个任务，任务队列为10，再运行一下可能有更好的理解，
                // 虽然结果会因为你的电脑性能发生改变，但大概率会是后面的任务都被执行了，而前面的任务被抛弃
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}

