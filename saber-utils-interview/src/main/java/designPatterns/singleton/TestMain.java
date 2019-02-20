package designPatterns.singleton;

/**
 * Created by wangzhen on 2017/5/17.
 */
public class TestMain {

    public static void main(String[] args) {

        LazyInitHolderSingleton one = LazyInitHolderSingleton.getInstance();
        LazyInitHolderSingleton two = LazyInitHolderSingleton.getInstance();
        /*one.test();
        one.setName("I am a SingletonClass Instance");
        System.out.println(one.getName());*/
        if (one == two) {

            System.out.println("There are same");
        }

        DCLSingleton singleton = DCLSingleton.getInstance();

    }
}
