package concurrent.deadlock;

/**
 * @author Aria
 * @time on 2019-04-03.
 */
public class DeadLock implements Runnable {

    private boolean lockFormer;
    //必须是静态
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    DeadLock(boolean lockFormer) {
        this.lockFormer = lockFormer;
    }

    @Override
    public void run() {
        if (this.lockFormer) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                    //记住这个异常名字
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1ok");
                }
            }
        } else {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("1ok");
                }
            }
        }

    }

}
