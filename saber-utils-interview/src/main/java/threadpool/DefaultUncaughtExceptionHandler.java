package threadpool;


/**
 * Description:
 *
 * @author Aria
 * @time on 2018/5/17.
 */
public class DefaultUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    //private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUncaughtExceptionHandler.class);

    private String name;

    public DefaultUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    /**
     * Method invoked when the given thread terminates due to the
     * given uncaught exception.
     * <p>Any exception thrown by this method will be ignored by the
     * Java Virtual Machine.
     *
     * @param t the thread
     * @param e the exception
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String msg = String.format("%s线程池任务[%s]发生不可知异常", name, t);
       // LOGGER.error(msg, e);
    }
}
