package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aria
 * @time on 2018/12/17.
 */
public class TestSort {

    public static void main(String[] args) {
      int[] numbers = {-5,0,1,2,6,7,10,15,20,55};

        //int[] numbers = {1, 2, 3, 4, 10};
        System.out.print("排序前：");
        printArr(numbers);
        QuickSort.quick(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);

        Map<String,String> map = new HashMap<>(1000);
        System.out.print(map.size());
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }
}
