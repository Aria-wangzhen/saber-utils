package coding;

/**
 * Author: ������
 * Date: 2015-06-14
 * Time: 12:01
 * Declaration: All Rights Reserved !!!
 */
public class Test43 {
    /**
     * ����ͨ�����
     *
     * @param number ɫ�Ӹ���
     * @param max    ɫ�ӵ����ֵ
     */
    public static void printProbability(int number, int max) {
        if (number < 1 || max < 1) {
            return;
        }

        int maxSum = number * max;
        int[] probabilities = new int[maxSum - number + 1];
        probability(number, probabilities, max);

        double total = 1;
        for (int i = 0; i < number; i++) {
            total *= max;
        }

        for (int i = number; i <= maxSum; i++) {
            double ratio = probabilities[i - number] / total;
            System.out.printf("%-8.4f", ratio);
        }

        System.out.println();

    }

    /**
     * @param number        ɫ�Ӹ���
     * @param probabilities ��ͬɫ�������ִ����ļ�������
     * @param max           ɫ�ӵ����ֵ
     */
    private static void probability(int number, int[] probabilities, int max) {
        for (int i = 1; i <= max; i++) {
            probability(number, number, i, probabilities, max);
        }
    }

    /**
     * @param original      �ܵ�ɫ����
     * @param current       ��ǰ������ǵڼ���
     * @param sum           �Ѿ�ǰ���ɫ������
     * @param probabilities ��ͬɫ�������ִ����ļ�������
     * @param max           ɫ�ӵ����ֵ
     */
    private static void probability(int original, int current, int sum, int[] probabilities, int max) {
        if (current == 1) {
            probabilities[sum - original]++;
        } else {
            for (int i = 1; i <= max; i++) {
                probability(original, current - 1, i + sum, probabilities, max);
            }
        }
    }

    /**
     * ����ѭ�����
     * @param number ɫ�Ӹ���
     * @param max    ɫ�ӵ����ֵ
     */
    public static void printProbability2(int number, int max) {
        if (number < 1 || max < 1) {
            return;
        }

        int[][] probabilities = new int[2][max * number + 1];
        // ���ݳ�ʼ��
        for (int i = 0; i < max * number + 1; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }

        // ��ǵ�ǰҪʹ�õ��ǵ�0�����黹�ǵ�1������
        int flag = 0;

        // �׳�һ������ʱ���ֵĸ������
        for (int i = 1; i <= max; i++) {
            probabilities[flag][i] = 1;
        }

        // �׳���������
        for (int k = 2; k <= number; k++) {
            // ����׳���k�����ӣ���ô��Ϊ[0, k-1]�ĳ��ִ���Ϊ0
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }

            // �׳�k�����ӣ����к͵Ŀ���
            for (int i = k; i <= max * k; i++) {
                probabilities[1 - flag][i] = 0;

                // ÿ�����ӵĳ��ֵ����п��ܵĵ���
                for (int j = 1; j <= i && j <= max; j++) {
                    // ͳ�Ƴ���Ϊi�ĵ������ֵĴ���
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }

            flag = 1 - flag;
        }


        double total = 1;
        for (int i = 0; i < number; i++) {
            total *= max;
        }

        int maxSum = number * max;
        for (int i = number; i <= maxSum; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.printf("%-8.4f", ratio);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        test01();
        test02();
    }

    private static void test01() {
        printProbability(2, 4);
    }

    private static void test02() {
        printProbability2(2, 4);
    }
}
