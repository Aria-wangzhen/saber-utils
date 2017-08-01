package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 可以看到，通过反射获取构造函数，然后调用setAccessible(true)就可以调用私有的构造函数，所有e1和e2是两个不同的对象。
 * 如果要抵御这种攻击，可以修改构造器，让它在被要求创建第二个实例的时候抛出异常。
 * http://blog.csdn.net/u013256816/article/details/50525335
 * <p>
 * 静态内部类可以防止被反射
 * Created by wangzhen on 2017/5/17.
 */
public class Elvis {
    private static boolean flag = false;

    private Elvis() {
        synchronized (Elvis.class) {
            System.out.println(" try to instance");
            if (flag == false) {
                System.out.println("first time instance");
                flag = !flag;
            } else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    private static class SingletonHolder {
        // jvm保证在任何线程访问INSTANCE静态变量之前一定先创建了此实例
        private static final Elvis INSTANCE = new Elvis();
    }

    public static Elvis getInstance() {
        System.out.println("in getInstance");
        return SingletonHolder.INSTANCE;
    }

    public void doSomethingElse() {

    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

        Class<?> classType = Elvis.class;
        Constructor<?> c = classType.getDeclaredConstructor(null);
        c.setAccessible(true);
        Elvis e1 = (Elvis) c.newInstance();

        Elvis e2 = Elvis.getInstance();

        System.out.println(e1 == e2);
    }
}
