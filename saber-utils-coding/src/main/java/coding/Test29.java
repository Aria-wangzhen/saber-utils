package coding;

/**
 * Author: ������
 * Date: 2015-05-06
 * Time: 08:44
 * Declaration: All Rights Reserved !!!
 */
public class Test29 {

    /**
     * ��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ��������
     *
     * @param numbers ��������
     * @return �ҵ�������
     */
    public static int moreThanHalfNum(int[] numbers) {

        // ����У��
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("array length must large than 0");
        }

        // ���ڼ�¼���ִ�����������һ�����
        int result = numbers[0];
        // �ڵ�ǰ��¼������ͬ�����ĸ���
        int count = 1;
        // �ӵڶ�������ʼ�����
        for (int i = 1; i < numbers.length; i++) {
            // �������Ϊ0
            if (count == 0) {
                // ���¼�¼һ�������������ǳ��ִ�����������һ���
                result = numbers[i];
                // ��¼ͳ��ֵ
                count = 1;
            }
            // �����¼��ֵ��ͳ��ֵ��ȣ�����ֵ����
            else if (result == numbers[i]) {
                count++;
            }
            // �������ͬ�ͼ��٣��໥����
            else {
                count--;
            }
        }

        // ����result�����ǳ��ִ�����������һ�볤�ȵ�ֵ
        // ͳ��result�ĳ��ִ���
        count = 0;
        for (int number : numbers) {
            if (result == number) {
                count++;
            }
        }

        // ������ִ������������һ��ͷ��ض�Ӧ��ֵ
        if (count > numbers.length / 2) {
            return result;
        }
        // ���������쳣
        else {
            throw new IllegalArgumentException("invalid input");
        }
    }

    public static void main(String[] args) {
        // ���ڳ��ִ����������鳤��һ�������
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(numbers));

        // ���ִ����������鳤��һ������ֶ������������ǰ�벿��
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNum(numbers2));

        // ���ִ����������鳤��һ������ֶ�����������ĺ�벿��
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNum(numbers3));

        // ֻ��һ����
        int numbers4[] = {1};
        System.out.println(moreThanHalfNum(numbers4));

        // �����ָ��
        moreThanHalfNum(null);
        // �����ڳ��ִ����������鳤��һ�������
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        moreThanHalfNum(numbers5);
    }
}


