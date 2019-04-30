package concurrent;

/**
 * @author Aria
 * @time on 2019-04-15.
 */
public class Test {
    private static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal1.set(1);
        threadLocal2.set(2);
    }
}
