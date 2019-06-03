package designPatterns.singleton;

import designPatterns.roundingMode.Main;

/**
 * 写一个线程安全的双重检查锁（DCL）的单例模式
 * 超级好：https://www.cnblogs.com/codingmengmeng/p/9846131.html
 * 带volatile的DCL（双重检查锁）的单例模式
 * @author Aria
 * @time on 2019-02-20.
 */
public class DCLSingleton {
    private volatile static DCLSingleton instance = null;

    public static DCLSingleton getInstance(){
        if(null == instance){
            //刚开始是dclSingleton=null,所有不能synchronized(dclSingleton),synchronized不能锁空对象；
            //synchronized(this)
            synchronized (DCLSingleton.class){
                if(null == instance){
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

    private DCLSingleton() {
    }



}
