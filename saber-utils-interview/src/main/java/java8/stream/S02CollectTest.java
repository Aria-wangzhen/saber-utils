package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 那么只是过滤后显示个数，一点意义都没有，那么最好的做法是将这些过滤后的数据收集起来变为一个新的集合出现，那么就可以使用收集器完成：
 * <p>
 * 　　　　　public <R,A> R collect(Collector<? super T,A,R> collector)；
 * <p>
 * 这个方法需要使用一个Collector类型，这个类型可以通过Collectors类取得：
 * <p>
 * 　　　　 · 收集的结果为List集合：public static<T> Collector<T,?,List<T>> toList()。
 *
 * @author Aria
 * @time on 2019-03-07.
 */
public class S02CollectTest {
    public static void main(String[] args) throws Exception {

        List<String> all = new ArrayList<String>();
        all.add("java");
        all.add("jsp");
        all.add("servlet");
        all.add("ajax");
        all.add("jquery");
        Stream<String> stream = all.stream().filter((e) -> e.contains("j"));
        List<String> result = stream.collect(Collectors.toList());
        System.out.println(result);
    }
}
