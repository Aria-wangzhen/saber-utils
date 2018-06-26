package threadpool;



import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Aria
 * @time on 2018/5/17.
 */
public class ThreadPoolManager {

    //private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolManager.class);

    private static final Map<String, ExecutorService> CACHE = new HashMap<>(16);

    private static final int DEFAULT_CORE_POOL_SIZE;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE;
    private static final int DEFAULT_KEEP_ALIVE_TIME = 200;
    private static final int DEFAULT_QUEUE_SIZE;

    static {
        // cpu数量
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        // 核心线程数
        DEFAULT_CORE_POOL_SIZE = 2 * availableProcessors + 1;
        // 最大线程数量
        DEFAULT_MAXIMUM_POOL_SIZE = DEFAULT_CORE_POOL_SIZE;
        // 线程池饱和后是拒绝状态，因此队列长一点
        DEFAULT_QUEUE_SIZE = 100 * (DEFAULT_CORE_POOL_SIZE + 1);
    }

    /**
     * 获取默认配置的普通线程池
     *
     * @param name 线程池名称, 同时也作为key, 需要保证唯一性
     * @return 线程池
     */
    public static ThreadPoolExecutor getFixThreadPool(String name) {
        return getFixThreadPool(name,
                DEFAULT_CORE_POOL_SIZE, DEFAULT_MAXIMUM_POOL_SIZE,
                DEFAULT_KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                DEFAULT_QUEUE_SIZE);
    }

    /**
     * 获取默认配置的普通线程池
     *
     * @param name          线程池名称, 同时也作为key, 需要保证唯一性
     * @param coreSize      核心线程数量
     * @param maxCoreSize   允许的最大线程数量
     * @param keepAliveTime 额外线程的线程活跃时间
     * @param unit          活跃时间单位
     * @param queueCapacity 最大线程池容量
     * @return 线程池
     */
    public static ThreadPoolExecutor getFixThreadPool(String name,
                                                      int coreSize, int maxCoreSize,
                                                      long keepAliveTime, TimeUnit unit,
                                                      int queueCapacity) {
        ThreadFactory threadFactory = getDefaultThreadFactory(name);
        RejectedExecutionHandler handler = getDefaultRejectHandler(name);
        return getFixThreadPool(name,
                coreSize, maxCoreSize,
                keepAliveTime, unit,
                queueCapacity, threadFactory, handler);
    }

    /**
     * 获取默认配置的普通线程池
     *
     * @param name          线程池名称, 同时也作为key, 需要保证唯一性
     * @param coreSize      核心线程数量
     * @param maxCoreSize   允许的最大线程数量
     * @param keepAliveTime 额外线程的线程活跃时间
     * @param unit          活跃时间单位
     * @param queueCapacity 最大线程池容量
     * @param threadFactory 线程工厂
     * @param handler       拒绝策略
     * @return 线程池
     */
    public static ThreadPoolExecutor getFixThreadPool(String name,
                                                      int coreSize, int maxCoreSize,
                                                      long keepAliveTime, TimeUnit unit,
                                                      int queueCapacity,
                                                      ThreadFactory threadFactory,
                                                      RejectedExecutionHandler handler) {
       // if (StringUtils.isBlank(name)) {
       //     name = "default_thread_pool";
       // }
        ExecutorService service = CACHE.get(name);
        if (service != null && service.isShutdown()) {
            CACHE.remove(name);
            service = null;
        }
        synchronized (ThreadPoolManager.class) {
            if (service == null) {
                service = CACHE.get(name);

                if (service == null) {
                    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(queueCapacity);
                    ThreadPoolExecutor threadPoolExecutor = new DefaultThreadPoolExecutor(
                            coreSize, maxCoreSize, keepAliveTime, unit,
                            workQueue, threadFactory, handler);
                    CACHE.put(name, threadPoolExecutor);
                    registerMonitor(threadPoolExecutor, name);
                }
            }
        }
        return (ThreadPoolExecutor) CACHE.get(name);
    }

    /**
     * 获取可调度的线程池
     *
     * @param name 线程池名称, 同时也作为key, 需要保证唯一性
     * @return 线程池
     */
    public static ScheduledThreadPoolExecutor getScheduledThreadPool(String name) {
        return getScheduledThreadPool(name,
                DEFAULT_CORE_POOL_SIZE, DEFAULT_MAXIMUM_POOL_SIZE,
                DEFAULT_KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                DEFAULT_QUEUE_SIZE);
    }

    /**
     * 获取可调度的线程池
     *
     * @param name          线程池名称, 同时也作为key, 需要保证唯一性
     * @param coreSize      核心线程数量
     * @param maxCoreSize   允许的最大线程数量
     * @param keepAliveTime 额外线程的线程活跃时间
     * @param unit          活跃时间单位
     * @param queueCapacity 最大线程池容量
     * @return 线程池
     */
    public static ScheduledThreadPoolExecutor getScheduledThreadPool(String name,
                                                                     int coreSize, int maxCoreSize,
                                                                     long keepAliveTime, TimeUnit unit,
                                                                     int queueCapacity) {
        ThreadFactory threadFactory = getDefaultThreadFactory(name);
        RejectedExecutionHandler handler = getDefaultRejectHandler(name);
        return getScheduledThreadPool(name,
                coreSize, maxCoreSize,
                keepAliveTime, unit,
                queueCapacity, threadFactory, handler);
    }

    /**
     * 获取可调度的线程池
     *
     * @param name          线程池名称, 同时也作为key, 需要保证唯一性
     * @param coreSize      核心线程数量
     * @param maxCoreSize   允许的最大线程数量
     * @param keepAliveTime 额外线程的线程活跃时间
     * @param unit          活跃时间单位
     * @param queueCapacity 最大线程池容量
     * @param threadFactory 线程工厂
     * @param handler       拒绝策略
     * @return 线程池
     */
    public static ScheduledThreadPoolExecutor getScheduledThreadPool(String name,
                                                                     int coreSize, int maxCoreSize,
                                                                     long keepAliveTime, TimeUnit unit,
                                                                     int queueCapacity,
                                                                     ThreadFactory threadFactory,
                                                                     RejectedExecutionHandler handler) {
       // if (StringUtils.isBlank(name)) {
       //     name = "default_scheduled_thread_pool";
       // }
        ExecutorService service = CACHE.get(name);
        if (service != null && service.isShutdown()) {
            CACHE.remove(name);
            service = null;
        }
        synchronized (ThreadPoolManager.class) {
            if (service == null) {
                service = CACHE.get(name);

                if (service == null) {
                    ScheduledThreadPoolExecutor threadPoolExecutor = new DefaultScheduledThreadPoolExecutor(
                            coreSize, queueCapacity, threadFactory, handler);
                    threadPoolExecutor.setMaximumPoolSize(maxCoreSize);
                    threadPoolExecutor.setKeepAliveTime(keepAliveTime, unit);
                    CACHE.put(name, threadPoolExecutor);
                    registerMonitor(threadPoolExecutor, name);
                }
            }
        }
        return (ScheduledThreadPoolExecutor) CACHE.get(name);
    }

    private static RejectedExecutionHandler getDefaultRejectHandler(String name) {
        return new DefaultRejectedExecutionHandler(name);
    }

    private static ThreadFactory getDefaultThreadFactory(String name) {
        return new ThreadFactoryBuilder()
                .setDaemon(false)
                .setNameFormat(name + "thread-pool-%d")
                .setUncaughtExceptionHandler(new DefaultUncaughtExceptionHandler(name))
                .build();
    }

    private static void registerMonitor(ThreadPoolExecutor threadPoolExecutor,
                                        String threadPoolName) {
        try {
           // LOGGER.info(threadPoolName + "线程池监控器开始注册");
           // StatusExtensionRegister.getInstance().register(new ThreadPoolCatMonitor(threadPoolExecutor, threadPoolName));
        } catch (Exception ex) {
           // LOGGER.error(threadPoolName + "线程池监控器注册失败", ex);
        }
    }
}
