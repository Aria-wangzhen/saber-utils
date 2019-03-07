package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://www.cnblogs.com/liyang31/p/5813886.html
 * tream相当于是所有数据的流式数据分析工具，既然是数据的分析，那么就需要对数据执行一些简单的操作，例如：可能需要一些过滤
 * ，即：满足一些条件之后的数据可以进行分析。
 * <p>
 * 　　 · 过滤方法：public Stream<T> filter(Predicate<? super T> predicate)；
 * <p>
 * 范例：执行过滤
 *
 * @author Aria
 * @time on 2019-03-07.
 */
public class S01FilterTest {
    public static void main(String[] args) throws Exception {

        List<String> all = new ArrayList<String>();
        all.add("java");
        all.add("jsp");
        all.add("servlet");
        all.add("ajax");
        all.add("jquery");
        Stream<String> stream = all.stream().filter((e) -> e.contains("j"));
        System.out.println(stream.count());
    }
}
