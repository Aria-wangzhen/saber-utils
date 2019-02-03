package jvmTest;

/**
 * @author Aria
 * @time on 2019-02-03.
 */
public class ExB extends ExA {
    static {
        System.out.println("子类--静态代码块");
    }

    {
        System.out.println("子类--非静态代码块");
    }

    public ExB() {
        System.out.println("子类--构造函数");
    }
}
