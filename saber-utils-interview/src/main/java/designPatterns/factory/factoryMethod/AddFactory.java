package designPatterns.factory.factoryMethod;

import designPatterns.factory.simpleFactory.Add;
import designPatterns.factory.simpleFactory.Operation;

/**
 * @author Aria
 * @time on 2019-04-15.
 */
public class AddFactory implements Factory {
    @Override
    public Operation createOperation() {
        System.out.println("加法运算");
        return new Add();
    }
}
