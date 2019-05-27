package concurrent.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 从源码中可以看出ArrayBlockingQueue内部是采用数组进行数据存储的（属性items），为了保证线程安全，采用的是ReentrantLock
 * lock，为了保证可阻塞式的插入删除数据利用的是Condition，
 * 当获取数据的消费者线程被阻塞时,会将该线程放置到notEmpty等待队列中，
 * 当插入数据的生产者线程被阻塞时，会将该线程放置到notFull等待队列中。
 * 而notEmpty和notFull等中要属性在构造方法中进行创建
 * https://www.jianshu.com/p/a636b3d83911
 *
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
            notEmpty.signal();
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
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }

    }
}
