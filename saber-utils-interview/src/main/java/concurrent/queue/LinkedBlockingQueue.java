package concurrent.queue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/h525483481/article/details/80347485
 * https://www.jianshu.com/p/a636b3d83911
 * 基于链表的阻塞队列
 *
 * @author Aria
 * @time on 2019-03-19.
 */
public class LinkedBlockingQueue<E> {

    private final int capacity;

    private Lock lock = new ReentrantLock();

    private Condition unFull = lock.newCondition();

    private Condition unEmpty = lock.newCondition();

    private int count;

    private LinkedList<E> queue;

    public LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }


    public LinkedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<E>();
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (count == capacity) {
                unFull.await();
            }
            queue.addLast(e);
            count++;
            unEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                unEmpty.await();
            }
            E e = queue.pop();
            count--;
            unFull.signal();
            return e;
        } finally {
            lock.unlock();
        }

    }
}
