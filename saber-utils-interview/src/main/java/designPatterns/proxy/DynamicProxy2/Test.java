package designPatterns.proxy.DynamicProxy2;

import java.lang.reflect.Proxy;

/**
 * @author Aria
 * @time on 2019-02-20.
 */
public class Test {
    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new CallServiceImpl());
        CallService callService = myInvocationHandler.getProxy();
        callService.call();
    }

}
