package designPatterns.factory.factoryMethod;

import designPatterns.factory.simpleFactory.Operation;
import designPatterns.factory.simpleFactory.Sub;

/**
 * @author Aria
 * @time on 2019-04-15.
 */
public class SubFactory implements Factory {

    @Override
    public Operation createOperation() {
        System.out.println("减法运算");
        return new Sub();
    }
}
