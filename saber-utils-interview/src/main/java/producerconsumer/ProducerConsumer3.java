package producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by wangzhen on 2017/5/17.
 */
public class ProducerConsumer3 {

    // 建立一个阻塞队列
    private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(10);

    public ProducerConsumer3() {
    }

    public void start() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Producer());
        service.submit(new Consumer());


    }

    public static void main(String[] args) throws Exception {
        ProducerConsumer3 s3 = new ProducerConsumer3();
        s3.start();
    }

    class Producer implements Runnable {

        public void run() {
            while (true) {
                try {
                    Object o = new Object();
                    // 取出一个对象
                    queue.put(o);
                    System.out.println("Producer: " + o);
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
                // }
            }
        }
    }

    class Consumer implements Runnable {

        public void run() {
            while (true) {
                try {
                    // 取出一个对象
                    Object o = queue.take();
                    System.out.println("Consumer: " + o);
                } catch (InterruptedException e) {
                    System.out.println("producer is interrupted!");
                }
                // }
            }
        }
    }

}