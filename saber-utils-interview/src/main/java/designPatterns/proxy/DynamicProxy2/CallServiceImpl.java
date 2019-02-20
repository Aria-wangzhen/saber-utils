package designPatterns.proxy.DynamicProxy2;

/**
 * @author Aria
 * @time on 2019-02-20.
 */
public class CallServiceImpl implements CallService {
    @Override
    public void call() {
        System.out.println("我是真实对象");
    }
}
