package algorithm.swordForOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-17
 * Time: 09:44
 * Declaration: All Rights Reserved !!!
 */
public class Test65 {
    private static List<Integer> maxInWindows(List<Integer> data, int size) {
        List<Integer> windowMax = new LinkedList<>();

        // �������
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }

        Deque<Integer> idx = new LinkedList<>();

        // ���ڻ�û�б�����ʱ�������ֵ������
        for (int i = 0; i < size && i < data.size(); i++) {
            // ���������Ӧ��ֵ��֮ǰ�洢������ֵ��Ӧ��ֵ�������ȣ���ɾ��֮ǰ�洢��ֵ
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }

            //  �������
            idx.addLast(i);
        }

        // �����Ѿ���������
        for (int i = size; i < data.size(); i++) {
            // ��һ�����ڵ����ֵ����
            windowMax.add(data.get(idx.getFirst()));

            // ���������Ӧ��ֵ��֮ǰ�洢������ֵ��Ӧ��ֵ�������ȣ���ɾ��֮ǰ�洢��ֵ
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }

            // ɾ���Ѿ��������ڵ����ݶ�Ӧ���±�
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }

            // ���ܵ������±��������
            idx.addLast(i);
        }

        // ���һ���������ֵ���
        windowMax.add(data.get(idx.getFirst()));

        return windowMax;

    }

    private static List<Integer> arrayToCollection(int[] array) {
        List<Integer> result = new LinkedList<>();
        if (array != null) {
            for (int i : array) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // expected {7};
        List<Integer> data1 = arrayToCollection(new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(data1 + "," + maxInWindows(data1, 10));

        // expected {3, 3, 5, 5, 6, 7};
        List<Integer> data2 = arrayToCollection(new int[]{1, 3, -1, -3, 5, 3, 6, 7});
        System.out.println(data2 + "," + maxInWindows(data2, 3));

        // expected {7, 9, 11, 13, 15};
        List<Integer> data3 = arrayToCollection(new int[]{1, 3, 5, 7, 9, 11, 13, 15});
        System.out.println(data3 + "," + maxInWindows(data3, 4));

        // expected  {16, 14, 12};
        List<Integer> data5 = arrayToCollection(new int[]{16, 14, 12, 10, 8, 6, 4});
        System.out.println(data5 + "," + maxInWindows(data5, 5));

        // expected  {10, 14, 12, 11};
        List<Integer> data6 = arrayToCollection(new int[]{10, 14, 12, 11});
        System.out.println(data6 + "," + maxInWindows(data6, 1));

        // expected  {14};
        List<Integer> data7 = arrayToCollection(new int[]{10, 14, 12, 11});
        System.out.println(data7 + "," + maxInWindows(data7, 4));
    }
}
