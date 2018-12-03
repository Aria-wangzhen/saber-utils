package designPatterns.producerconsumer;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 1、wait()和notify()
 *
 * Created by wangzhen on 2017/5/17.
 */
public class ProducerConsumer1 {
    private LinkedList<Object> storoHouse = new LinkedList<Object>();
    private static int MAX = 10;

    public ProducerConsumer1() {

    }

    public void start() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Produce());
        service.submit(new Consumer());

    }

    class Produce implements Runnable {



        public void run() {

            while (true) {
                synchronized (storoHouse) {
                    try {
                        while (storoHouse.size() == MAX) {
                            System.out.println("storeHouse is full , please wait");
                            storoHouse.wait();
                        }

                        Object object = new Object();
                        if(storoHouse.add(object)) {
                            System.out.println("Producer put a Object to storeHouse");
                            Thread.sleep((long) Math.random()*3000);
                            storoHouse.notify();
                        }

                    } catch (InterruptedException e) {
                        System.out.println("producer is interrupted!");
                    }
                }
            }
        }
    }

    class Consumer implements Runnable {



        public void run() {

            while (true) {
                synchronized (storoHouse) {
                    try {
                        while (storoHouse.size() == 0) {
                            System.out.println("storeHouse is empty , please wait");
                            storoHouse.wait();
                        }

                        storoHouse.removeLast();
                        System.out.println("Comsumer get  a Object from storeHouse");
                        Thread.sleep((long) Math.random()*3000);
                        storoHouse.notify();
                    } catch (InterruptedException e) {
                        System.out.println("Consumer is interrupted");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ProducerConsumer1 pc = new ProducerConsumer1();
        pc.start();
    }
}

