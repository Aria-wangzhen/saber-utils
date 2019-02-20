package fanXing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * @author Aria
 * @time on 2019-02-02.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("abc");
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass() == arrayList2.getClass());

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
    }
}
