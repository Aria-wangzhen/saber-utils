package designPatterns.singleton;

/**
 *
 * 使用枚举类的方式来实现单例
 * 1.线程安全：枚举类在被虚拟机加载的时候会保证线程安全的被初始
 * 2.反序列化：枚举的序列化和反序列化是有特殊定制的。这就可以避免反序列化过程中由于反射而导致的单例被破坏问题。
 * Created by wangzhen on 2017/5/17.
 */
public enum EnumSingleton {
    INSTANCE;
    public void whateverMethod() {
    }
}
