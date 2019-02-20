package designPatterns.proxy.DynamicProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Aria
 * @time on 2019-02-20.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object tar;

    public MyInvocationHandler(Object tar) {
        this.tar = tar;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(),
                this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(tar, args);
    }
}
