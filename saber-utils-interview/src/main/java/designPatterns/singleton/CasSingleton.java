package designPatterns.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Aria
 * @time on 2019-05-06.
 */
public class CasSingleton {
    /**
     * 静态、最终、AtomicReference
     */
    private static final AtomicReference<CasSingleton> INSTANCE = new AtomicReference<CasSingleton>();

    private CasSingleton() {
    }

    /**
     * 静态方法
     *
     * @return
     */
    public static CasSingleton getInstance() {
        /**
         * 死循环
         */
        for (; ; ) {
            CasSingleton singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new CasSingleton();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
}
