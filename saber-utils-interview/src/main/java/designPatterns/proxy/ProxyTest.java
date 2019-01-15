package designPatterns.proxy;

/**
 * @author Aria
 * @time on 2019-01-15.
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler(new RealObject());
        //绑定该类实现的所有接口
        Call callProxy = proxyHandler.bind();
        //sub.call
        callProxy.call();
    }
}
