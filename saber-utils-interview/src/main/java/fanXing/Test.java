package fanXing;

import java.util.ArrayList;

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
    }
}
