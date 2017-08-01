package singleton;

/**
 * 根据jvm规范，当某对象第一次调用LazyInitHolderSingleton.getInstance()时，LazyInitHolderSingleton类被首次主动使用，jvm对其进行初始化（此时并不会调用LazyInitHolderSingleton()构造方法;进行LazyInitHolderSingleton的类加载，初始化静态变量），然后LazyInitHolderSingleton调用getInstance()方法，该方法中，又首次主动使用了SingletonHolder类，所以要对SingletonHolder类进行初始化（类的静态变量首先加载，进行初始化），初始化中，INSTANCE常量被赋值时才调用了 LazyInitHolderSingleton的构造方法LazyInitHolderSingleton()，完成了实例化并返回该实例。
 * 当再有对象（也许是在别的线程中）再次调用LazyInitHolderSingleton.getInstance()时，因为已经初始化过了，不会再进行初始化步骤，所以直接返回INSTANCE常量即同一个LazyInitHolderSingleton实例。
 * 静态内部类实现单例模式，
 * Created by wangzhen on 2017/5/17.
 * http://www.cnblogs.com/ttylinux/p/6498822.html?utm_source=itdadao&utm_medium=referral
 * <p>
 * http://www.blogjava.net/kenzhh/archive/2013/03/15/357824.html
 */
public class LazyInitHolderSingleton {
    private LazyInitHolderSingleton() {
    }

    private static class SingletonHolder {
        private static final LazyInitHolderSingleton INSTANCE = new LazyInitHolderSingleton();
    }

    public static LazyInitHolderSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
