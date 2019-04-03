package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-06-17
 * Time: 19:19
 * Declaration: All Rights Reserved !!!
 */
public class Test67 {
    /**
     * ��Ŀ�������и�m��n�еķ���һ�������˴�����(0,0)�ĸ��ӿ�ʼ�ƶ���
     * ��ÿһ�ο��������ҡ��ϡ����ƶ�һ�񣬵����ܽ�������������������
     * λ֮�ʹ���k�ĸ��ӡ����磬��kΪ18ʱ���������ܹ����뷽��(35,37)��
     * ��Ϊ3+5+3+7=18.�������ܽ��뷽��(35,38)����Ϊ3+5+3+8=19.
     * ���ʸû������ܹ��ﵽ���ٸ��ӣ�
     *
     * @param threshold Լ��ֵ
     * @param rows      ���������
     * @param cols      ���������
     * @return �����ߵķ���
     */
    public static int movingCount(int threshold, int rows, int cols) {
        // ����У��
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }

        // ������ʼ��
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    /**
     * �ݹ���ݷ���
     *
     * @param threshold Լ��ֵ
     * @param rows      ���������
     * @param cols      ���������
     * @param row       ��ǰ������к�
     * @param col       ��ǰ������к�
     * @param visited   ���ʱ������
     * @return �����ߵķ���
     */
    private static int movingCountCore(int threshold, int rows, int cols,
                                       int row, int col, boolean[] visited) {

        int count = 0;

        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }

        return count;
    }

    /**
     * �ϻ������ܷ��������Ϊ(row, col)�ķ���
     *
     * @param threshold Լ��ֵ
     * @param rows      ���������
     * @param cols      ���������
     * @param row       ��ǰ������к�
     * @param col       ��ǰ������к�
     * @param visited   ���ʱ������
     * @return �Ƿ���Խ��룬true�ǣ�false��
     */
    private static boolean check(int threshold, int rows, int cols,
                                 int row, int col, boolean[] visited) {
        return col >= 0 && col < cols
                && row >= 0 && row < rows
                && !visited[row * cols + col]
                && (getDigitSum(col) + getDigitSum(row) <= threshold);
    }

    /**
     * һ�����ֵ���λ֮��
     *
     * @param number ����
     * @return ���ֵ���λ֮��
     */
    private static int getDigitSum(int number) {
        int result = 0;
        while (number > 0) {
            result += (number % 10);
            number /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(15, 20, 20) + "[359]");
        System.out.println(movingCount(10, 1, 100) + "[29]");
        System.out.println(movingCount(10, 1, 10) + "[10]");
        System.out.println(movingCount(15, 100, 1) + "[79]");
        System.out.println(movingCount(15, 10, 1) + "[10]");
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(12, 1, 1) + "[1]");
        System.out.println(movingCount(-10, 10, 10) + "[0]");
    }
}
