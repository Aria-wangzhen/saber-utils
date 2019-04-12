package concurrent;

/**
 * @author Aria
 * @time on 2019-04-12.
 */
public class SequenceNumber1 {


    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);

        t1.start();
        t2.start();
        t3.start();

        t1.print();
        t2.print();
        t3.print();


    }

    private static class TestClient extends Thread {
        private static int flag = 0;

        private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>();

        private SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                seqNum.set(flag++);
                System.out.println(Thread.currentThread().getName() + " --> " + seqNum.get());
            }
        }

        public void print() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + seqNum.get());
            }
        }
    }

}
