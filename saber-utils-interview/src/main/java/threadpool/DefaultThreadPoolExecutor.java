package threadpool;

import java.util.concurrent.*;

/**

 * Description: 现在线程池cat打点没法串连，这里底层通过fork线程实现相同请求的日志串联
 *
 * @author Aria
 * @time on 2018/5/17.
 */
public class DefaultThreadPoolExecutor extends ThreadPoolExecutor {

    /**
     *
     * @param corePoolSize    核心线程池线程数量
     * @param maximumPoolSize 允许的最大线程数量
     * @param keepAliveTime   额外线程的线程活跃时间
     * @param unit            单位
     * @param workQueue       等待队列
     * @throws IllegalArgumentException {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue} is null
     */
    public DefaultThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    /**
     *
     * @param corePoolSize    核心线程池线程数量
     * @param maximumPoolSize 允许的最大线程数量
     * @param keepAliveTime   额外线程的线程活跃时间
     * @param unit            单位
     * @param workQueue       等待队列
     * @param threadFactory   线程工厂
     * @throws IllegalArgumentException {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue}
     *                                  or {@code threadFactory} is null
     */
    public DefaultThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    /**
     *
     * @param corePoolSize    核心线程池线程数量
     * @param maximumPoolSize 允许的最大线程数量
     * @param keepAliveTime   额外线程的线程活跃时间
     * @param unit            单位
     * @param workQueue       等待队列
     * @param handler         拒绝策略
     * @throws IllegalArgumentException {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue}
     *                                  or {@code handler} is null
     */
    public DefaultThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    /**
     *
     * @param corePoolSize    核心线程池线程数量
     * @param maximumPoolSize 允许的最大线程数量
     * @param keepAliveTime   额外线程的线程活跃时间
     * @param unit            单位
     * @param workQueue       等待队列
     * @param threadFactory   线程工厂
     * @param handler         拒绝策略
     * @throws IllegalArgumentException {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue}
     *                                  or {@code threadFactory} or {@code handler} is null
     */
    public DefaultThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


}
