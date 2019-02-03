package jvmTest.fenPai;

/**
 * @author Aria
 * @time on 2019-02-03.
 */
public class DynamicDispatch {
    static abstract class Humnan {
        abstract void say();
    }
    static class Man extends Humnan {
        @Override
        void say() {
            System.out.println("hello, i'm Man");
        }
    }
    static class Woman extends Humnan {
        @Override
        void say() {
            System.out.println("hello, i'm Woman");
        }
    }

    public static void main(String[] args) {
        Humnan man = new Man();
        Humnan woman = new Woman();
        man.say();
        woman.say();
    }
}
