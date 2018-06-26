package threadpool;




import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * Description:
 *
 * @author Aria
 * @time on 2018/5/17.
 */
public class DefaultRejectedExecutionHandler implements RejectedExecutionHandler {

    //private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRejectedExecutionHandler.class);

    private String name;

    public DefaultRejectedExecutionHandler(String name) {
        this.name = name;
    }

    /**
     * Method that may be invoked by a {@link ThreadPoolExecutor} when
     * {@link ThreadPoolExecutor#execute execute} cannot accept a
     * task.  This may occur when no more threads or queue slots are
     * available because their bounds would be exceeded, or upon
     * shutdown of the Executor.
     *
     * <p>In the absence of other alternatives, the method may throw
     * an unchecked {@link RejectedExecutionException}, which will be
     * propagated to the caller of {@code execute}.
     *
     * @param r        the runnable task requested to be executed
     * @param executor the executor attempting to execute this task
     * @throws RejectedExecutionException if there is no remedy
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        String msg = String.format("%s线程池满负荷，任务[%s]丢失", name, r);
        RuntimeException exception = new RejectedExecutionException(msg);
        //LOGGER.error(msg, exception);
        throw exception;
    }
}
