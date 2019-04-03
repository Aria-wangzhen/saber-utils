package algorithm.swordForOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-14
 * Time: 10:06
 * Declaration: All Rights Reserved !!!
 */
public class Test41 {
    /**
     * ����һ����������������һ������s���������в�����������ʹ�õ����ǵĺ�������s��
     * ����ж�����ֵĺ͵���s���������һ�Լ��ɡ�
     *
     * @param data
     * @param sum
     * @return
     */
    public static List<Integer> findNumbersWithSum(int[] data, int sum) {
        List<Integer> result = new ArrayList<>(2);

        if (data == null || data.length < 2) {
            return result;
        }

        int ahead = data.length - 1;
        int behind = 0;
        long curSum; // ͳ�ƺͣ�ȡlong�Ƿ�ֹ������

        while (behind < ahead) {
            curSum = data[behind] + data[ahead];

            if (curSum == sum) {
                result.add(data[behind]);
                result.add(data[ahead]);
                break;
            } else if (curSum < sum) {
                behind++;
            } else {
                ahead--;
            }
        }

        return result;
    }

    /**
     * ��Ŀ��������һ������s����ӡ�����к�Ϊs �������������У���������������
     * @param sum
     * @return
     */
    public static List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                List<Integer> list = new ArrayList<>(2);
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
            }

            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;

                if (curSum == sum) {
                    List<Integer> list = new ArrayList<>(2);
                    for (int i = small; i <= big; i++) {
                        list.add(i);
                    }
                    result.add(list);
                }
            }

            big++;
            curSum += big;
        }

        return result;
    }
    public static void main(String[] args) {
        test01();
        System.out.println("---------------");
        test02();
    }

    private static void test01() {
        int[] data1 = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumbersWithSum(data1, 15));

        int[] data2 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumbersWithSum(data2, 17));

        int[] data3 = {1, 2, 4, 7, 11, 16};
        System.out.println(findNumbersWithSum(data3, 10));
    }

    public static void test02(){
        System.out.println(findContinuousSequence(1));
        System.out.println(findContinuousSequence(3));
        System.out.println(findContinuousSequence(4));
        System.out.println(findContinuousSequence(9));
        System.out.println(findContinuousSequence(15));
        System.out.println(findContinuousSequence(100));
    }
}
