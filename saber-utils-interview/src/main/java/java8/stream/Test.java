package java8.stream;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @author Aria
 * @time on 2019-03-07.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        List<S04MapAndReduceTest> all = new ArrayList<S04MapAndReduceTest>();
        all.add(new S04MapAndReduceTest("平板电脑", 4999, 20));
        all.add(new S04MapAndReduceTest("手机", 1099, 200));
        all.add(new S04MapAndReduceTest("笔记本", 9, 80));
        all.add(new S04MapAndReduceTest("U盘", 99, 180));
        all.add(new S04MapAndReduceTest("鼠标", 49, 15));
        double allPrice =
                all.stream().map((obj) -> obj.getPrice() * obj.getAmount()).reduce((sum, x) -> sum + x).get();
        System.out.println("商品总销量" + allPrice);
        DoubleSummaryStatistics dss =
                all.stream().mapToDouble((obj) -> obj.getPrice() * obj.getAmount()).summaryStatistics();
        System.out.println("销售总销量" + dss.getCount());
        System.out.println("最高销量" + dss.getMax());
        System.out.println("最低销量" + dss.getMin());
        System.out.println("平均销量" + dss.getAverage());
        System.out.println("总销量" + dss.getSum());
    }
}
