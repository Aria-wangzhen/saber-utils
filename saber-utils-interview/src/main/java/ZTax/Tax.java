package ZTax;

import java.math.BigDecimal;

/**
 * https://jingyan.baidu.com/article/fd8044fa169f0b5031137a95.html
 *
 * @author Aria
 * @time on 2019-01-10.
 */
public class Tax {

    public static void main(String[] args) {

        //五险一金扣除后工资
        BigDecimal money = BigDecimal.valueOf(50000);
        deductTax(money);

    }

    /**
     * 个人所得税扣除
     *
     * @param money
     */
    private static void deductTax(BigDecimal money) {
        BigDecimal tax = BigDecimal.ZERO;
        if (money.compareTo(step) <= 0) {
            tax = BigDecimal.ZERO;
        }
        if (money.compareTo(step) > 0 && money.compareTo(step8) <= 0) {
            tax = (money.subtract(step)).multiply(tax8);

        }
        if (money.compareTo(step8) > 0 && money.compareTo(step17) <= 0) {
            tax = (money.subtract(step8)).multiply(tax17)
                    .add((step8.subtract(step)).multiply(tax8));
        }

        if (money.compareTo(step17) > 0 && money.compareTo(step30) <= 0) {
            tax = (money.subtract(step17)).multiply(tax30)
                    .add((step17.subtract(step8)).multiply(tax17))
                    .add((step8.subtract(step)).multiply(tax8));
        }

        if (money.compareTo(step30) > 0 && money.compareTo(step40) <= 0) {
            tax = (money.subtract(step30)).multiply(tax40)
                    .add((step30.subtract(step17)).multiply(tax30))
                    .add((step17.subtract(step8)).multiply(tax17))
                    .add((step8.subtract(step)).multiply(tax8));
        }
        if (money.compareTo(step40) > 0 && money.compareTo(step60) <= 0) {
            tax = (money.subtract(step40)).multiply(tax60)
                    .add((step40.subtract(step30)).multiply(tax40))
                    .add((step30.subtract(step17)).multiply(tax30))
                    .add((step17.subtract(step8)).multiply(tax17))
                    .add((step8.subtract(step)).multiply(tax8));
        }

        if (money.compareTo(step60) > 0 && money.compareTo(step85) <= 0) {
            tax = (money.subtract(step60)).multiply(tax85)
                    .add((step60.subtract(step40)).multiply(tax60))
                    .add((step40.subtract(step30)).multiply(tax40))
                    .add((step30.subtract(step17)).multiply(tax30))
                    .add((step17.subtract(step8)).multiply(tax17))
                    .add((step8.subtract(step)).multiply(tax8));

        }

        if (money.compareTo(step85) > 0) {
            tax = (money.subtract(step85)).multiply(extand)
                    .add((step85.subtract(step60)).multiply(tax85))
                    .add((step60.subtract(step40)).multiply(tax60))
                    .add((step40.subtract(step30)).multiply(tax40))
                    .add((step30.subtract(step17)).multiply(tax30))
                    .add((step17.subtract(step8)).multiply(tax17))
                    .add((step8.subtract(step)).multiply(tax8));
        }
        System.out.println("个人所得税扣除：" + tax);
        System.out.println("(个人所得税扣除)税后：" + money.subtract(tax));
    }




    //起征点
    private static final BigDecimal step = BigDecimal.valueOf(5000);

    private static final BigDecimal step8 = BigDecimal.valueOf(8000);

    private static final BigDecimal step17 = BigDecimal.valueOf(17000);

    private static final BigDecimal step30 = BigDecimal.valueOf(30000);

    private static final BigDecimal step40 = BigDecimal.valueOf(40000);

    private static final BigDecimal step60 = BigDecimal.valueOf(60000);

    private static final BigDecimal step85 = BigDecimal.valueOf(85000);

    //税率
    private static final BigDecimal tax8 = BigDecimal.valueOf(0.03);

    private static final BigDecimal tax17 = BigDecimal.valueOf(0.1);

    private static final BigDecimal tax30 = BigDecimal.valueOf(0.2);

    private static final BigDecimal tax40 = BigDecimal.valueOf(0.25);

    private static final BigDecimal tax60 = BigDecimal.valueOf(0.3);

    private static final BigDecimal tax85 = BigDecimal.valueOf(0.35);

    private static final BigDecimal extand = BigDecimal.valueOf(0.45);
}
