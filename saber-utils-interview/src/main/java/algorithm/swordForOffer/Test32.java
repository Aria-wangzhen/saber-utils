package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-06-11
 * Time: 09:22
 * Declaration: All Rights Reserved !!!
 */
public class Test32 {

    /**
     * ��Ŀ������һ������n���1 ��n��n��������ʮ���Ʊ�ʾ��1 ���ֵĴ�����
     * @param n ��������
     * @return 1-n�У�������λ1���ֵĴ���
     */
    public static int numberOf1Between1AndN(int n) {
        if (n <= 0) {
            return 0;
        }

        String value = n + "";
        int[] numbers = new int[value.length()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = value.charAt(i) - '0';
        }

        return numberOf1(numbers, 0);
    }

    /**
     * ��0-numbers��������е�1�ĸ���
     *
     * @param numbers ���֣���{1, 2, 3, 4, 5}��ʾ����12345
     * @param curIdx  ��ǰ�����λ��
     * @return 1�ĸ���
     */
    private static int numberOf1(int[] numbers, int curIdx) {

        if (numbers == null || curIdx >= numbers.length || curIdx < 0) {
            return 0;
        }
        // ������ĵ�һ������
        int first = numbers[curIdx];

        // Ҫ��������ֵ�λ��
        int length = numbers.length - curIdx;

        // ���ֻ��һλ����һλ��0����0
        if (length == 1 && first == 0) {
            return 0;
        }

        // ���ֻ��һλ����һλ����0����1
        if (length == 1 && first > 0) {
            return 1;
        }

        // ����numbers��21345
        // numFirstDigit������10000-19999�ĵ�һ��λ�е���Ŀ
        int numFirstDigit = 0;
        // ������λ����1����21345����[1236, 21345]�У����λ1���ֵ�ֻ��[10000, 19999]�У�����1�Ĵ�����10^4����
        if (first > 1) {
            numFirstDigit = powerBase10(length - 1);
        }
        // ������λ��1����12345����[2346, 12345]�У����λ1���ֵ�ֻ��[10000, 12345]�У��ܼ�2345+1��
        else if (first == 1) {
            numFirstDigit = atoi(numbers, curIdx + 1) + 1;
        }

        // numOtherDigits����[1346, 21345]�У����˵�һλ֮�⣨����21345�еĵ�һλ2������λ�е�1����Ŀ
        int numOtherDigits = first * (length - 1) * powerBase10(length - 2);
        // numRecursive��1-1234��1�ĵ���Ŀ
        int numRecursive = numberOf1(numbers, curIdx + 1);

        return numFirstDigit + numOtherDigits + numRecursive;
    }

    /**
     * ����������ת������ֵ����{1, 2, 3, 4, 5}��i = 2�������345
     * @param numbers ����
     * @param i ��ʼ������λ��
     * @return ת�����
     */
    private static int atoi(int[] numbers, int i) {
        int result = 0;
        for (int j = i; j < numbers.length; j++) {
            result = (result * 10 + numbers[j]);
        }
        return result;
    }

    /**
     * ��10��n�η����ٶ�n��Ϊ����
     * @param n �ݣ��Ǹ���
     * @return 10��n�η�
     */
    private static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(1)); // 1
        System.out.println(numberOf1Between1AndN(5)); // 1
        System.out.println(numberOf1Between1AndN(10)); // 2
        System.out.println(numberOf1Between1AndN(55)); // 16
        System.out.println(numberOf1Between1AndN(99)); // 20
        System.out.println(numberOf1Between1AndN(10000)); // 4001
        System.out.println(numberOf1Between1AndN(21345)); // 18821
        System.out.println(numberOf1Between1AndN(0)); // 0
    }
}
