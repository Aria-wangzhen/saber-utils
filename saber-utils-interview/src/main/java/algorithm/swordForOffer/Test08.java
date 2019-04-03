package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-22
 * Time: 10:57
 * Declaration: All Rights Reserved !!!
 */
public class Test08 {

    /**
     * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�� ���ǳ�֮�������ת��
     * ����һ����������������һ����ת�������ת�������СԪ�ء�
     * ��������{3, 4, 5, 1, 2��Ϊ��l ,2, 3, 4, 5}��һ����ת�����������СֵΪ
     *
     * @param numbers ��ת����
     * @return �������Сֵ
     */
    public static int min(int[] numbers) {
        // �ж������Ƿ�Ϸ�
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("Invalid input.");
        }

        // ��ʼ����ĵ�һ��λ��
        int lo = 0;
        // ��ʼ��������һ��λ��
        int hi = numbers.length - 1;
        // ���ó�ʼֵ
        int mi = lo;

        // ȷ��lo��ǰһ���ź���Ĳ��֣�hi���ź���ĺ�һ������
        while (numbers[lo] >= numbers[hi]) {
            // ������Χֻ����������ʱ�����غ�һ�����
            // ��Ϊnumbers[lo] >= numbers[hi]���ǳ�������һ�������Ӧ������С��ֵ
            if (hi - lo == 1) {
                return numbers[hi];
            }

            // ȡ�м��λ��
            mi = lo + (hi - lo) / 2;

            // �������������ȣ�����Ҫ����˳������ͷ��β����С��ֵ
            if (numbers[mi] == numbers[lo] && numbers[hi] == numbers[mi]) {
                return minInorder(numbers, lo, hi);
            }

            // ����м�λ�ö�Ӧ��ֵ��ǰһ���ź���Ĳ��֣���lo����Ϊ�µĴ���λ��
            if (numbers[mi] >= numbers[lo]) {
                lo = mi;
            }
            // ����м�λ�ö�Ӧ��ֵ�ں�һ���ź���Ĳ��֣���hi����Ϊ�µĴ���λ��
            else if (numbers[mi] <= numbers[hi]) {
                hi = mi;
            }
        }

        // �������յĴ�����
        return numbers[mi];
    }

    /**
     * �������е���Сֵ
     *
     * @param numbers ����
     * @param start   �������ʼλ��
     * @param end     ����Ľ���λ��
     * @return �ҵ�����С����
     */
    public static int minInorder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        // �������룬��������������һ����ת
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(min(array1));

        // ���ظ����֣������ظ������ָպõ���С������
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(min(array2));

        // ���ظ����֣����ظ������ֲ��ǵ�һ�����ֺ����һ������
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(min(array3));

        // ���ظ������֣������ظ������ָպ��ǵ�һ�����ֺ����һ������
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(min(array4));

        // �����������飬��ת0��Ԫ�أ�Ҳ���ǵ����������鱾��
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(min(array5));

        // ������ֻ��һ������
        int[] array6 = {2};
        System.out.println(min(array6));

        // ���������ֶ���ͬ
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(min(array7));
        System.out.println(min(array6));

        // ����NULL
        System.out.println(min(null));


    }
}
