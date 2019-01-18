package jvmTest;

/**
 * 类加载机制：http://www.cnblogs.com/ityouknow/p/5603287.html
 *
 * @author Aria
 * @time on 2019-01-18.
 */
public class ClassloaderTest {
    public static void main(String[] args) {
        //ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //ClassLoader loader = ClassloaderTest.class.getClassLoader();
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}
