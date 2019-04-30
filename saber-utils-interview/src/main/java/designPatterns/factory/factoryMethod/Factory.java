package designPatterns.factory.factoryMethod;

import designPatterns.factory.simpleFactory.Operation;

/**
 * 工厂方法模式
 *
 * @author Aria
 * @time on 2019-04-15.
 */
public interface Factory {
    public Operation createOperation();
}
