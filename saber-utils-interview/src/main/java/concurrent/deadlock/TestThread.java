package concurrent.deadlock;

/**
 * @author Aria
 * @time on 2019-04-03.
 */
public class TestThread {
    public static void main(String[] args) {
// test dead lock
        Thread t9 = new Thread(
                new DeadLock(true));
        Thread t10 = new Thread(
                new DeadLock(false));
        t9.start();
        t10.start();

    }
}
