package designPatterns.factory.simpleFactory;

/**
 * 简单工厂模式
 *
 * @author Aria
 * @time on 2019-04-15.
 */
public class EasyFactory {
    public static Operation createOperation(String name) {
        Operation operationObj = null;
        switch (name) {
            case "+":
                operationObj = new Add();
                break;
            case "-":
                operationObj = new Sub();
                break;
        }
        return operationObj;
    }


}
