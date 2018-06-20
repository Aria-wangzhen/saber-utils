package interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aria
 * @time on 2018/6/20.
 */
public class Test {
    public static void main(String[] args) {
        TestService testServiceA = new TestServiceImplA();

        TestService testServiceB = new TestServiceImplB();

        List<TestService> list = new ArrayList<TestService>();
        list.add(testServiceA);
        list.add(testServiceB);
        for (TestService testService : list) {
            System.out.println(testService.getName());
        }

    }
}
