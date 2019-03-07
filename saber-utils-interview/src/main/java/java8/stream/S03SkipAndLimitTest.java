package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 既然流式处理之中主要是为大数据而生的概念，那么就需要考虑一个数据的分页问题，提供有两个方法：
 * <p>
 * · 跳过数据量：public Stream<T> skip(long n)；
 * <p>
 * · 取出的数据量：public Stream<T> limit(long maxSize)。
 * <p>
 * 范例：执行分页控制
 *
 * @author Aria
 * @time on 2019-03-07.
 */
public class S03SkipAndLimitTest {
    public static void main(String[] args) throws Exception {

        List<String> all = new ArrayList<String>();
        all.add("java");
        all.add("jsp");
        all.add("servlet");
        all.add("ajax");
        all.add("jquery");
        all.add("javaScript");
        all.add("json");
        all.add("jdbc");
        Stream<String> stream = all.stream()
                .skip(3).limit(3)
                .map((e) -> e.toLowerCase())
                .filter((e) -> e.contains("j"));
        List<String> result = stream.collect(Collectors.toList());
        System.out.println(result);
    }
}
