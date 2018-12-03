package designPatterns.singleton;

/**
 * Created by wangzhen on 2017/5/17.
 */
public class TestMain {

    public static void main(String[] args) {

        SingletonClass one = SingletonClass.INSTANCE;
        SingletonClass two = SingletonClass.INSTANCE;


        /*one.test();
        one.setName("I am a SingletonClass Instance");
        System.out.println(one.getName());*/

        if (one == two) {

            System.out.println("There are same");
        }
    }
}
