package algorithm.sword;

import java.util.Comparator;

/**
 * @author Aria
 * @time on 2019-05-05.
 */
public class S33 {
    /**
     * 自定义的排序比较器，实现算法说明的排序原理
     */
    private static class MComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {

            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("Arg should not be null");
            }

            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        }
    }

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers    带查找数组
     * @param low        开始位置
     * @param high       结束位置
     * @param comparator
     * @return 中轴所在位置
     */
    private static int getMiddle(String[] array, int low, int high, Comparator<String> comparator) {
        String temp = array[low]; //数组的第一个作为中轴
        while (low < high) {
            //直到找到一个比中轴值小的
            while (low < high && comparator.compare(array[high], temp) >= 0) {
                high--;
            }
            array[low] = array[high];//比中轴小的记录移到低端
            while (low < high && comparator.compare(array[low], temp) <= 0) {
                low++;
            }
            array[high] = array[low]; //比中轴大的记录移到高端
        }
        array[low] = temp; //中轴记录到尾
        //numbers[high] = temp; //王振
        return low; // 返回中轴的位置
    }

    /**
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    private static void quickSort1(String[] numbers, int low, int high, Comparator<String> comparator) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high, comparator); //将numbers数组进行一分为二
            quickSort1(numbers, low, middle - 1, comparator);   //对低字段表进行递归排序
            quickSort1(numbers, middle + 1, high, comparator); //对高字段表进行递归排序
        }

    }

    /**
     * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     *
     * @param array 输入的数组
     * @return 输出结果
     */
    public static String printMinNumber(String[] array) {

        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("Array must contain value");
        }

        MComparator comparator = new MComparator();
        quickSort1(array, 0, array.length - 1, comparator);

        StringBuilder builder = new StringBuilder(256);
        for (String s : array) {
            builder.append(s);
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String[] data = {"3", "5", "1", "4", "2"};
        System.out.println(printMinNumber(data));

        String[] data2 = {"3", "32", "321"};
        System.out.println(printMinNumber(data2));

        String[] data3 = {"3", "323", "32123"};
        System.out.println(printMinNumber(data3));

        String[] data4 = {"1", "11", "111"};
        System.out.println(printMinNumber(data4));

        String[] data5 = {"321"};
        System.out.println(printMinNumber(data5));
    }
}


