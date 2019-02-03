package jvmTest.fenPai;

/**
 * 虽编译器能确定被调用方法的重载版本，但是在很多情况下重载版本并不唯一，往往只能确定一个更加合适的版本。
 * <p>
 * 主要原因是字面量作为参数传入是没有显式的静态类型的。只能选择一个最贴近该字面型类型的方法。实际工作中要避免出现
 *
 * @author Aria
 * @time on 2019-02-03.
 */
public class StaticDispatch1 {
    public void sayHello(byte i) {
        System.out.println("byte");
    }

    public void sayHello(short i) {
        System.out.println("short");
    }

    public void sayHello(int i) {
        System.out.println("int");
    }

    public void sayHello(int... i) {
        System.out.println("int...");
    }

    public void sayHello(long i) {
        System.out.println("long");
    }

    public static void main(String[] args) {
        StaticDispatch1 d = new StaticDispatch1();
        d.sayHello(2);  //上面的方法好像看似都可以，到底哪个被调用呢?
    }
}
