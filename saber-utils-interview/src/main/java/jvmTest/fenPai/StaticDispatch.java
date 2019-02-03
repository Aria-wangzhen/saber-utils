package jvmTest.fenPai;

/**
 * 静态分派发生在代码的编译阶段：
 * 在编译阶段，Java编译器会根据参数的静态类型决定调用哪个重载版本，但在有些情况下，重载的版本不是唯一的，
 * 这样只能选择一个“更加合适的版本”进行调用，所以不建议在实际项目中使用这种模糊的方法重载。
 *
 * @author Aria
 * @time on 2019-02-03.
 */
public class StaticDispatch {
    static abstract class Humnan {
    }

    static class Man extends Humnan {
    }

    static class Woman extends Humnan {
    }

    public void hello(Humnan guy) {
        System.out.println("hello, Humnan");
    }

    public void hello(Man guy) {
        System.out.println("hello, Man");
    }

    public void hello(Woman guy) {
        System.out.println("hello, Woman");
    }

    public static void main(String[] args) {
        Humnan man = new Man();
        Humnan woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.hello(man);
        dispatch.hello(woman);
        //
        dispatch.hello((Man)man);
        dispatch.hello((Woman)woman);
    }
}
