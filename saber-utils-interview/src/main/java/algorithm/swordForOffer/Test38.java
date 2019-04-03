package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-06-13
 * Time: 14:24
 * Declaration: All Rights Reserved !!!
 */
public class Test38 {
    /**
     * ������������k��һ�γ��ֵ�λ��
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getFirstK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx > 0 && data[midIdx - 1] != k || midIdx == 0) {
                return midIdx;
            } else {
                end = midIdx - 1;
            }
        } else if (midData > k) {
            end = midIdx - 1;
        } else {
            start = midIdx + 1;
        }

        return getFirstK(data, k, start, end);
    }

    /**
     * ������������k���һ�γ��ֵ�λ��
     *
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getLastK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIdx = start + (end - start) / 2;
        int midData = data[midIdx];

        if (midData == k) {
            if (midIdx + 1 < data.length && data[midIdx + 1] != k || midIdx == data.length - 1) {
                return midIdx;
            } else {
                start = midIdx + 1;
            }
        } else if (midData < k) {
            start = midIdx + 1;
        } else {
            end = midIdx - 1;
        }

        return getLastK(data, k, start, end);
    }

    /**
     * ��Ŀ��ͳ��һ�����֣������������г��ֵĴ���
     * @param data
     * @param k
     * @return
     */
    public static int getNumberOfK(int[] data, int k) {
        int number = 0;
        if (data != null && data.length > 0) {
            int first = getFirstK(data, k, 0, data.length - 1);
            int last = getLastK(data, k, 0, data.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;
    }

    public static void main(String[] args) {
        // ���ҵ����ֳ�����������м�
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data1, 3)); // 4

        // ���ҵ��������������Ŀ�ͷ
        int[] data2 = {3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data2, 3)); // 4

        // ���ҵ��������������Ľ�β
        int[] data3 = {1, 2, 3, 3, 3, 3};
        System.out.println(getNumberOfK(data3, 3)); // 4

        // ���ҵ����ֲ�����
        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data4, 2)); // 0

        // ���ҵ����ֱȵ�һ�����ֻ�С��������
        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data5, 0)); // 0

        // ���ҵ����ֱ����һ�����ֻ��󣬲�����
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data6, 0)); // 0

        // �����е����ִ�ͷ��β���ǲ��ҵ�����
        int[] data7 = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data7, 3)); // 4

        // �����е����ִ�ͷ��βֻ��һ���ظ������֣����ǲ��ҵ�����
        int[] data8 = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data8, 4)); // 0

        // ������ֻ��һ�����֣��ǲ��ҵ�����
        int[] data9 = {3};
        System.out.println(getNumberOfK(data9, 3)); // 1

        // ������ֻ��һ�����֣����ǲ��ҵ�����
        int[] data10 = {3};
        System.out.println(getNumberOfK(data10, 4)); // 0
    }
}
