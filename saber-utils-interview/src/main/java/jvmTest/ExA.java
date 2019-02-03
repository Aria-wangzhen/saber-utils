package jvmTest;

/**
 * 静态代码块以及非静态代码块都会在构造函数前执行，首次访问时，静态代码块会在非静态代码块前执行
 *
 * @author Aria
 * @time on 2019-02-03.
 */
public class ExA {
    static {
        System.out.println("父类--静态代码块");
    }

    public ExA() {
        System.out.println("父类--构造函数");
    }

    {
        System.out.println("父类--非静态代码块");
    }

    public static void main(String[] args) {
        new ExB();
    }
}
