package coding;

/**
 * Author: ������
 * Date: 2015-06-10
 * Time: 19:54
 * Declaration: All Rights Reserved !!!
 */
public class Test31 {
    /**
     * ��Ŀ2 ����һ���������飬������������Ҳ�и�����������һ������
     * ���Ķ���������һ�������顣������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
     *
     * @param arr ��������
     * @return ���������������
     */
    public static int findGreatestSumOfSubArray(int[] arr) {
        // ����У��
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Array must contain an element");
        }

        // ��¼����������ͣ���ʼʱ����С������
        int max = Integer.MIN_VALUE;
        // ��ǰ�ĺ�
        int curMax = 0;
        // �������
        for (int i : arr) {
            // �����ǰ��С�ڵ���0�����������õ�ǰ��
            if (curMax <= 0) {
                curMax = i;
            }
            // �����ǰ�ʹ���0���ۼӵ�ǰ��
            else {
                curMax += i;
            }

            // ���¼�¼�������ڵ��������
            if (max < curMax) {
                max = curMax;
            }
        }


        return max;
    }

    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};

        System.out.println(findGreatestSumOfSubArray(data));
        System.out.println(findGreatestSumOfSubArray(data2));
        System.out.println(findGreatestSumOfSubArray(data3));
    }
}
