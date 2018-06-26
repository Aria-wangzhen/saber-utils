package coding;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 21:22
 * Declaration: All Rights Reserved !!!
 */
public class Test20 {
    /**
     * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡÿһ������
     *
     * @param numbers ����Ķ�ά���飬��ά���������N*M�ģ�����ֳ���
     */
    public static void printMatrixClockWisely(int[][] numbers) {
        // ����Ĳ�������Ϊ��
        if (numbers == null) {
            return;
        }

        // ��¼һȦ�������Ŀ�ʼλ�õ���
        int x = 0;
        // ��¼һȦ�������Ŀ�ʼλ�õ���
        int y = 0;
        // ��ÿһȦ���������д���
        // �к������(numbers.length-1)/2
        // �к������(numbers[0].length-1)/2
        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
            // ָ����һ��Ҫ����ĵĻ��ĵ�һ��λ��
            x++;
            y++;
        }
    }

    public static void printMatrixInCircle(int[][] numbers, int x, int y) {
        // ���������
        int rows = numbers.length;
        // ���������
        int cols = numbers[0].length;

        // �����������һ�У��������е��Ǹ�����
        for (int i = y; i <= cols - y - 1; i++) {
            System.out.print(numbers[x][i] + " ");
        }

        // ���ĸ߶�����Ϊ2�Ż�����ұߵ�һ��
        // rows-x-1����ʾ���ǻ����µ���һ�е��к�
        if (rows - x - 1 > x) {
            // ��Ϊ�ұ���һ�е���������һ���Ѿ�������ˣ������гʴ�x+1��ʼ��
            // ��������ұ����е��������Ǹ�
            for (int i = x + 1; i <= rows - x - 1; i++) {
                System.out.print(numbers[i][cols - y - 1] + " ");
            }
        }

        // ���ĸ߶�������2���һ��Ŀ��������2�Ż����������һ��
        // cols-1-y����ʾ���ǻ�������һ�е��к�
        if (rows - x - 1 > x && cols - 1 - y > y) {
            // ��Ϊ�������½ǵ�λ���Ѿ�����ˣ������кŴ�cols-y-2��ʼ
            for (int i = cols - y - 2; i >= y; i--) {
                System.out.print(numbers[rows - 1 - x][i] + " ");
            }
        }

        // ���Ŀ��������2���һ��ĸ߶�������3�Ż�����������һ��
        // rows-x-1����ʾ���ǻ����µ���һ�е��к�
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            // ��Ϊ�������һ�еĵ�һ�������һ���Ѿ��������
            for (int i = rows - 1 - x - 1; i >= x + 1; i--) {
                System.out.print(numbers[i][y] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        printMatrixClockWisely(numbers);
        System.out.println();

        int[][] numbers2 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12},

        };
        printMatrixClockWisely(numbers2);
        System.out.println();


        int[][] numbers3 = {
                {1, 2, 3, 4, 5, 6, 7, 8}
        };
        printMatrixClockWisely(numbers3);
        System.out.println();

        int[][] numbers4 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {16, 15, 14, 13, 12, 11, 10, 9}
        };
        printMatrixClockWisely(numbers4);
        System.out.println();


        int[][] numbers5 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
        printMatrixClockWisely(numbers5);
        System.out.println();

        int[][] numbers6 = {
                {0, 1},
                {15, 2},
                {14, 3},
                {13, 4},
                {12, 5},
                {11, 6},
                {10, 7},
                {9, 8}
        };
        printMatrixClockWisely(numbers6);
        System.out.println();


        int[][] numbers7 = {
                {1, 2},
                {4, 3}
        };
        printMatrixClockWisely(numbers7);
        System.out.println();

        int[][] numbers8 = {
                {1}
        };
        printMatrixClockWisely(numbers8);
        System.out.println();

        // 0��Ԫ�ص�����
        printMatrixClockWisely(new int[][]{{}});
        // ������
        printMatrixClockWisely(null);
    }
}
