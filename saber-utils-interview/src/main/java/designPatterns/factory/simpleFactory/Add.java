package designPatterns.factory.simpleFactory;

/**
 * @author Aria
 * @time on 2019-04-15.
 */
public class Add implements Operation {

    /**
     * 加法计算
     */
    @Override
    public double getResult(double numberA, double numberB) {

        return numberA + numberB;

    }
}
