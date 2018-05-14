package proxy;

import java.lang.reflect.Proxy;

/**
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2018/2/11.
 */
public class Test {
    public static void main(String[] args) {
        BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
        BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
        //BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(bpimpl.getClass().getClassLoader(), bpimpl.getClass().getInterfaces(), handler);
        //Thread.currentThread().getContextClassLoader()用来在运行时动态地载入其它类
        BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), bpimpl.getClass().getInterfaces(), handler);

        bp.processBusiness();
    }
}
