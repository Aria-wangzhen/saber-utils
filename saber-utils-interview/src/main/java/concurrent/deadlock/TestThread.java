package concurrent.deadlock;

/**
 * 写一个可以运行的线程死锁程序
 *
 * @author Aria
 * @time on 2019-04-03.
 */
public class TestThread {
    public static void main(String[] args) {
        Thread t9 = new Thread(
                new DeadLock(true));
        Thread t10 = new Thread(
                new DeadLock(false));
        t9.start();
        t10.start();

    }
}
