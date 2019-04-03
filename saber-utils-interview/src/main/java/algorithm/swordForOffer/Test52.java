package algorithm.swordForOffer;

import java.util.Arrays;

/**
 * Author: ������
 * Date: 2015-06-15
 * Time: 08:59
 * Declaration: All Rights Reserved !!!
 */
public class Test52 {
    public static double[] multiply(double[] data) {
        if (data == null || data.length < 2) {
            return null;
        }

        double[] result = new double[data.length];

        // result[0]ȡ1
        result[0] = 1;
        for (int i = 1; i < data.length; i++) {
            // ��һ��ÿ��result[i]��������data[0]*data[1]...data[i-1]
            // ��i=n-1ʱ����ʱresult[n-1]�Ľ���Ѿ���������ˡ�A��
            result[i] = result[i -1] * data[i - 1];
        }

        // tmp����data[n-1]*data[n-2]...data[i+1]�Ľ��
        double tmp = 1;
        // �ڶ�����data[n-1]*data[n-2]...data[i+1]
        // ��A��result[n-1]�Ľ���Ѿ�������������Դ�data.length-2��ʼ����
        for (int i = data.length - 2; i >= 0; i--) {
            tmp *= data[i + 1];
            result[i] *= tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        double[] array1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(array1))); // double expected[] = {120, 60, 40, 30, 24};
        double[] array2 = {1, 2, 0, 4, 5};
        System.out.println(Arrays.toString(multiply(array2))); // double expected[] = {0, 0, 40, 0, 0};
        double[] array3 = {1, 2, 0, 4, 0};
        System.out.println(Arrays.toString(multiply(array3))); // double expected[] = {0, 0, 0, 0, 0};
        double[] array4 = {1, -2, 3, -4, 5};
        System.out.println(Arrays.toString(multiply(array4))); // double expected[] = {120, -60, 40, -30, 24};
        double[] array5 = {1, -2};
        System.out.println(Arrays.toString(multiply(array5))); // double expected[] = {-2, 1};
    }

}
