package designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Aria
 * @time on 2019-01-15.
 */
public class ProxyHandler implements InvocationHandler {

    private Object tar;

    public ProxyHandler(Object tar) {
        this.tar = tar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(tar, args);
    }

    /**
     * 绑定委托对象，并返回代理类
     * @param <T>
     * @return
     */
    public <T> T bind() {
        //绑定该类实现的所有接口，取得代理类
        return (T) Proxy.newProxyInstance(tar.getClass().getClassLoader()
                , tar.getClass().getInterfaces(), this);
    }
}
