package java8.stream;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * 大数据最本质的做法就是MapReduce，属于数据的两个处理阶段：
 * <p>
 * · Map阶段：对要参与运算的数据进行提前处理；
 * <p>
 * 　　|- 方法：public <R> Stream<R> map(Function<? super T,? extends R> mapper)；
 * <p>
 * · Reduce阶段：对处理后的数据进行统计。
 * <p>
 * 　　|- 方法：public <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)。
 * <p>
 * 下面做一个订单操作的类，这个订单的操作类之中保存有商品的名称、商品单价、商品的购买数量。
 * <p>
 * 范例：实现统计处理
 *
 * @author Aria
 * @time on 2019-03-07.
 */
public class S04MapAndReduceTest {
    private String ptitle;
    private double price;
    private int amount;

    public S04MapAndReduceTest(String ptitle, double price, int amount) {
        super();
        this.ptitle = ptitle;
        this.price = price;
        this.amount = amount;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public class Test {

    }
}
