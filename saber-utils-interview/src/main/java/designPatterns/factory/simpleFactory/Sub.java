package designPatterns.factory.simpleFactory;

/**
 * @author Aria
 * @time on 2019-04-15.
 */
public class Sub implements Operation {
    /**
     * 减法运算
     *
     * @param numberA
     * @param numberB
     * @return
     * @throws Exception
     */
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA - numberB;
    }
}
