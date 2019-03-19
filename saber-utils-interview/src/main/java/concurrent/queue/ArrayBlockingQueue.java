package concurrent.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Aria
 * @time on 2019-03-19.
 */
public class ArrayBlockingQueue<E> {
    /**
     * The queued items
     * 队列中的元素
     */
    private final Object[] items;
    /**
     * 下一次提取的元素下标
     */
    private int takeIndex;
    /**
     * 下一次添加的元素下标
     */
    private int putIndex;
    /**
     * 计数队列中元素个数
     */
    private int count;

    /**
     * 主锁🔐保证所有的访问
     */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 等待取出元素的状态
     */
    private final Condition notEmpty = lock.newCondition();

    /**
     * 等待插入元素的状态
     */
    private final Condition notFull = lock.newCondition();

    public ArrayBlockingQueue(int cap) {
        items = new Object[cap];
    }

    public void add(E e) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putIndex++] = e;
            if (putIndex == items.length) {
                putIndex = 0;
            }
            count++;
            notFull.signal();
        } finally {
            lock.unlock();
        }

    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            E e = (E) items[takeIndex++];
            count--;
            if (takeIndex == items.length) {
                takeIndex = 0;
            }
            notEmpty.signal();
            return e;
        } finally {
            lock.unlock();
        }

    }
}
