package threadpool;

import java.util.concurrent.*;

/**

 * 1. 有界的ScheduledThreadPoolExecutor
 * 2. 现在线程池cat打点没法串连，这里底层通过fork线程实现相同请求的日志串联
 * @author Aria
 * @time on 2018/5/17.
 */
public class DefaultScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

    private int queueCapacity;

    /**
     *
     * @param corePoolSize  核心线程池线程数量
     * @param threadFactory 线程工厂
     * @param handler       拒绝策略
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     * @throws NullPointerException     if {@code threadFactory} or {@code handler} is null
     */
    public DefaultScheduledThreadPoolExecutor(int corePoolSize,
                                              ThreadFactory threadFactory,
                                              RejectedExecutionHandler handler) {
        this(corePoolSize, Integer.MAX_VALUE, threadFactory, handler);
    }

    /**
     * Creates a new ScheduledThreadPoolExecutor with the given
     * initial parameters.
     *
     * @param corePoolSize  核心线程池线程数量
     * @param queueCapacity 线程池等待队列最大长度，超过长度走拒绝策略
     * @param threadFactory 线程工厂
     * @param handler       拒绝策略
     * @throws IllegalArgumentException if {@code corePoolSize < 0}
     * @throws NullPointerException     if {@code threadFactory} or {@code handler} is null
     */
    public DefaultScheduledThreadPoolExecutor(int corePoolSize,
                                              int queueCapacity,
                                              ThreadFactory threadFactory,
                                              RejectedExecutionHandler handler) {
        super(corePoolSize, threadFactory, handler);
        this.queueCapacity = queueCapacity;
    }

    /**
     *
     * @param runnable 提交的任务
     * @param task     包装类
     * @return a task that can execute the runnable
     * @since 1.6
     */
    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        tryRejectByThrowException(task);
        return super.decorateTask(runnable, task);
    }

    /**
     *
     * @param callable 提交的任务
     * @param task     包装类
     * @return a task that can execute the callable
     * @since 1.6
     */
    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task) {
        tryRejectByThrowException(task);
        return super.decorateTask(callable, task);
    }

    private void tryRejectByThrowException(Runnable command) {
        if (getQueueCapacity() <= getQueue().size()) {
            getRejectedExecutionHandler().rejectedExecution(command, this);
        }
    }

    /**
     * Gets queue capacity.
     *
     * @return the queue capacity
     */
    public int getQueueCapacity() {
        return queueCapacity;
    }

    /**
     * Sets queue capacity.
     *
     * @param queueCapacity the queue capacity
     */
    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
