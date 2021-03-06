package designPatterns.factory.simpleFactory;

/**
 * @author Aria
 * @time on 2019-04-15.
 */
public class Test {
    public static void main(String[] args) throws Exception {

        Operation add = EasyFactory.createOperation("+");
        Operation sub = EasyFactory.createOperation("-");
        Operation mul = EasyFactory.createOperation("*");
        Operation div = EasyFactory.createOperation("/");

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
        System.out.println(mul.getResult(1, 1));
        System.out.println(div.getResult(1, 1));
    }
}
