package designPatterns.proxy.DynamicProxy1;

import designPatterns.proxy.DynamicProxy1.Call;

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
