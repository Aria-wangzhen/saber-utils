package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 13:39
 * Declaration: All Rights Reserved !!!
 */
public class Test12 {

    /**
     * ��������n����˳���ӡ����1����nλʮ����������������3�����ӡ��1��2��3 һֱ������3λ����999��
     *
     * @param n ���ֵ����λ��
     */
    public static void printOneToNthDigits(int n) {
        // ��������ֲ���ΪС��1
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        // ����һ���������ڴ���ֵ
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    /**
     * ��������n����˳���ӡ����1����nλʮ��������
     *
     * @param n   ��ǰ������ǵڸ�Ԫ�أ���0��ʼ����
     * @param arr ��Ž��������
     */
    public static void printOneToNthDigits(int n, int[] arr) {

        // ˵�����е���������ѡ���Ѿ���������
        if (n >= arr.length) {
            // �������������ֵ
            printArray(arr);
        } else {
            // ��
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }

    /**
     * ���������Ԫ�أ������ң��ӵ�һ����0ֵ����ʼ���������Ԫ�ء�
     *
     * @param arr Ҫ���������
     */
    public static void printArray(int[] arr) {
        // �ҵ�һ����0��Ԫ��
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }

        // �ӵ�һ����0ֵ����ʼ���������Ԫ�ء�
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        // ��������˵���������з���Ԫ�أ�������Ҫ����
        if (index < arr.length) {
            System.out.println();
        }
    }

    /**
     * ��������n����˳���ӡ����1����nλʮ����������������3�����ӡ��1��2��3 һֱ������3λ����999��
     * ���ڶ��ַ���������һ�������ڴ�ռ䡿
     *
     * @param n ���ֵ����λ��
     */
    public static void printOneToNthDigits2(int n) {
        // ����ֵ�������0
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }

        // ����һ������Ϊn������
        int[] arr = new int[n];
        // Ϊ����Ԫ�ظ���ʼֵ
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        // ������������λû�н�λ��һֱ���д���
        while (addOne(arr) == 0) {
            printArray(arr);
        }
    }

    /**
     * ��arr��ʾ����������λ��1 arr�е�ÿ���������ܳ���9����С��0��ÿ��λ��ģ��һ����λ
     *
     * @param arr ��������
     * @return �ж����λ�Ƿ��н�λ������н�λ�ͷ���1�����򷵻�0
     */
    public static int addOne(int[] arr) {
        // �����λֵ����Ϊÿ�����λ��1
        int carry = 1;
        // ���λ��λ�õĺ�һλ
        int index = arr.length;

        do {
            // ָ����һ������λ��
            index--;
            // ����λ�õ�ֵ���Ͻ�λ��ֵ
            arr[index] += carry;
            // ����λ�õĽ�λ
            carry = arr[index] / 10;
            // ����λ�õ�ֵ
            arr[index] %= 10;
        } while (carry != 0 && index > 0);

        // ���index=0˵���Ѿ����������λ��carry>0˵�����λ�н�λ������1
        if (carry > 0 && index == 0) {
            return 1;
        }

        // �޽�λ����0
        return 0;
    }


    public static void main(String[] args) {
        printOneToNthDigits2(2);
        System.out.println();
        printOneToNthDigits(2);
    }

}
