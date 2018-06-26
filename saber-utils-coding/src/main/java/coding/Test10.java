package coding;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 09:21
 * Declaration: All Rights Reserved !!!
 */
public class Test10 {

    /**
     * ��ʵ��һ�������� ����һ��������������������Ʊ�ʾ��1�ĸ�����
     * �����9��ʾ�ɶ�������1001 ����2λ��1. ����������9���ó�2��
     *
     * @param n ��������
     * @return �����ж����Ʊ���1����Ŀ
     */
    public static int numberOfOne(int n) {
        // ��¼������1��λ��
        int result = 0;

        // JAVA���Թ淶�У�int����ռ�ĸ��ֽڣ��ܼ�32λ
        // ��ÿһ��λ����1����������������ۼӾͿ��������ǰ���ֵı�ʾ�Ƕ���λ1
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>>= 1;
        }

        // ������õĽ��
        return result;
    }

    /**
     * ��ʵ��һ�������� ����һ��������������������Ʊ�ʾ��1�ĸ�����
     * �����9��ʾ�ɶ�������1001 ����2λ��1. ����������9���ó�2��
     * �����ַ�����Ч�ʸ��ߡ�
     *
     * @param n ��������
     * @return �����ж����Ʊ���1����Ŀ
     */
    public static int numberOfOne2(int n) {
        // ��¼������1��λ��
        int result = 0;

        // ���ֵĶ����Ʊ�ʾ���ж��ٸ�1�ͽ��ж��ٴβ���
        while (n != 0) {
            result++;
            // �����ұߵ�1��ʼ��ÿһ�β�����ʹn�����ҵ�һ��1�����0��
            // ��ʹ�Ƿ���λҲ����в�����
            n = (n - 1) & n;
        }

        // ������õĽ��
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(numberOfOne(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(numberOfOne(0B11111111_11111111_11111111_11111111)); // -1
        System.out.println(0B01111111_11111111_11111111_11111111 == Integer.MAX_VALUE);
        System.out.println(numberOfOne(0B01111111_11111111_11111111_11111111)); // Integer.MAX_VALUE
        System.out.println(0B10000000_00000000_00000000_00000000 == Integer.MIN_VALUE);
        System.out.println(numberOfOne(0B10000000_00000000_00000000_00000000)); // Integer.MIN_VALUE

        System.out.println("");
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(numberOfOne2(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(numberOfOne2(0B11111111_11111111_11111111_11111111)); // -1
        System.out.println(numberOfOne2(0B01111111_11111111_11111111_11111111)); // Integer.MAX_VALUE
        System.out.println(numberOfOne2(0B10000000_00000000_00000000_00000000)); // Integer.MIN_VALUE
    }
}
