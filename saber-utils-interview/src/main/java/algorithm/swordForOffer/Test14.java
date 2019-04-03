package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 15:53
 * Declaration: All Rights Reserved !!!
 */
public class Test14 {

    /**
     * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
     * ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
     *
     * @param arr ���������
     */
    public static void reorderOddEven(int[] arr) {
        // �������������Ϊ�գ����߳���С��2��ֻ�ӷ���
        if (arr == null || arr.length < 2) {
            return;
        }

        // �������Ҽ�¼ż����λ��
        int start = 0;
        // ���������¼������λ��
        int end = arr.length - 1;
        // ��ʼ����������ż����λ��
        while (start < end) {
            // ��ż��
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            // ������
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }

            // �ҵ���ͽ�������ż������λ��
            // ����start=end������������������ʲôӰ��
            // ���Խ�if�ж�ʡȥ��
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    /**
     * ����������Ϣ
     *
     * @param arr ���������
     */
    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderOddEven(array);
        printArray(array);
    }
}
