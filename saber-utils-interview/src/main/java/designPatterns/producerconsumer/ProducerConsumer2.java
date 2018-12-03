package designPatterns.producerconsumer;


import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await()和signal()，即线程锁的方式
 * Created by wangzhen on 2017/5/17.
 */
public class ProducerConsumer2 {
    private LinkedList<Object> storoHouse = new LinkedList<Object>();
    private static int MAX = 10;
    private final Lock lock = new ReentrantLock();
    private final Condition empty = lock.newCondition();
    private final Condition full = lock.newCondition();

    public ProducerConsumer2() {

    }

    public void start() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Produce());
        service.submit(new Consumer());

    }

    class Produce implements Runnable {



        public void run() {

            while (true) {
                lock.lock();
                ;
                try {
                    while (storoHouse.size() == MAX) {
                        System.out.println("storeHouse is full , please wait");
                        full.await();
                    }

                    Object object = new Object();
                    if (storoHouse.add(object)) {
                        System.out.println("Producer put a Object to storeHouse");
                        Thread.sleep((long) Math.random() * 3000);
                        empty.signal();
                    }

                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    class Consumer implements Runnable {



        public void run() {

            while (true) {
                lock.lock();
                try {
                    while (storoHouse.size() == 0) {
                        System.out.println("storeHouse is empty , please wait");
                        empty.await();
                    }

                    storoHouse.removeLast();
                    System.out.println("Comsumer get  a Object from storeHouse");
                    Thread.sleep((long) Math.random() * 3000);
                    full.signal();
                } catch (InterruptedException e) {
                    System.out.println("Consumer is interrupted");
                } finally {
                    lock.unlock();
                    ;
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        ProducerConsumer2 pc = new ProducerConsumer2();
        pc.start();
    }
}
