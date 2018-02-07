package executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2018/2/7.
 */
public class ExecutorServiceExample {
    private static final ExecutorService UPLOAD_POOL;

    static {
        UPLOAD_POOL = new ThreadPoolExecutor(
                5,
                10,
                0L,TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1000),
                new ThreadFactoryBuilder().setNameFormat("uploadAction-%d").setDaemon(false).build(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        //ERROR_LOG.info("UPLOAD_POOL is full, over info may be reject");
                    }
                }
        );

    }
}
