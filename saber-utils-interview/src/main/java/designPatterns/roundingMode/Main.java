package designPatterns.roundingMode;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 构造 BigDecimal 对象常用以下方法:
 * BigDecimal BigDecimal(double d); //不允许使用
 * BigDecimal BigDecimal(String s); //常用,推荐使用
 * static BigDecimal valueOf(double d); //常用,推荐使用
 * 其中,
 * 1. double 参数的构造方法,不允许使用!!!!因为它不能精确的得到相应的值;
 * 2. String 构造方法是完全可预知的: 写入 new BigDecimal("0.1") 将创建一个 BigDecimal,它正好等于预期的0.1; 因此,通常建议优先使用 String 构造方法;
 * 3. 静态方法 valueOf(double val) 内部实现,仍是将 double 类型转为 String 类型; 这通常是将 double(或float)转化为 BigDecimal 的首选方法;
 */
public class Main {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(new String("1.555"));
        System.out.println("HALF_DOWN:"+a.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println("HALF_UP:"+a.setScale(2, BigDecimal.ROUND_UNNECESSARY));


    }
}
