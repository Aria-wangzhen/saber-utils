package executor;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 只给推送语音，文案和打印用的线程池
 */
public class PushVoiceBoxExecutorService {
    private final ThreadPoolExecutor service;


    private static final PushVoiceBoxExecutorService INSTANCE = new PushVoiceBoxExecutorService();

    private static final int POOL_SIZE = 128;

    private PushVoiceBoxExecutorService() {

        service = new ThreadPoolExecutor(
                POOL_SIZE,
                POOL_SIZE,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(10000),
                new DefaultThreadFactory(PushVoiceBoxExecutorService.class));
    }

    public static final PushVoiceBoxExecutorService getInstance() {
        return INSTANCE;
    }

    public void start(Runnable command) {
        service.execute(command);
    }

    public void shutdown() {
        service.shutdown();
    }
}