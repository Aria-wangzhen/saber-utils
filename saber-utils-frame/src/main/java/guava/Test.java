package guava;

import java.math.BigDecimal;

/**
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2017/12/5.
 */
public class Test {

    public static void change(BigDecimal a) {
       a = BigDecimal.ONE;
        System.out.println(Long.MAX_VALUE);

    }

    public static void main(String[] args) {
        BigDecimal a = BigDecimal.ZERO;
        change(a);

        System.out.println("a=" + a);
    }
}
