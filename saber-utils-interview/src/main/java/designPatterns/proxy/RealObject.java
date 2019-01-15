package designPatterns.proxy;

/**
 * @author Aria
 * @time on 2019-01-15.
 */
public class RealObject implements Call {
    @Override
    public void call() {
      System.out.println("call a realObject");
    }
}
