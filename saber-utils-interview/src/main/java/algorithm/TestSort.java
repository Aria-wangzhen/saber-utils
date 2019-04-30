package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aria
 * @time on 2018/12/17.
 */
public class TestSort {

    public static void main(String[] args) {
        int[] numbers = {10, 15, 20, 55, -5, 0, 1, 2, 6, 7};

        //int[] numbers = {1, 2, 3, 4, 10};
        System.out.print("排序前：");
        printArr(numbers);
        //1.冒泡排序
        BubbleSort.bubbleSort(numbers);
        System.out.print("冒泡排序后：");
        printArr(numbers);
        //2.快排
        QuickSort.quick(numbers);
        System.out.print("快排排序后：");
        printArr(numbers);
        //3.归并
        MergeSort.sort(numbers, 0, numbers.length - 1);
        System.out.print("归并排序后：");
        printArr(numbers);
        //4.插入排序
        InsertSort.insertSort(numbers);
        System.out.print("插入排序后：");
        printArr(numbers);
        //5.选择排序
        SelectSort.selectSort(numbers);
        System.out.print("选择排序后：");
        printArr(numbers);
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }
}
