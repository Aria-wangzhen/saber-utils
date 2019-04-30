package designPatterns.singleton;

import designPatterns.roundingMode.Main;

/**
 * 超级好：https://www.cnblogs.com/codingmengmeng/p/9846131.html
 * 带volatile的DCL（双重检查锁）的单例模式
 * @author Aria
 * @time on 2019-02-20.
 */
public class DCLSingleton {
    private volatile static DCLSingleton dclSingleton = null;
    public static DCLSingleton getInstance(){
        if(null == dclSingleton){
            //刚开始是dclSingleton=null,所有不能synchronized(dclSingleton),synchronized不能锁空对象；
            //synchronized(this)

            synchronized (DCLSingleton.class){
                if(null == dclSingleton){
                    dclSingleton = new DCLSingleton();
                }
            }
        }
        return dclSingleton;
    }

    private DCLSingleton() {
    }



}
