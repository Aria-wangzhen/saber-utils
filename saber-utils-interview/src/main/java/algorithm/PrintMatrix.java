package algorithm;

/**
 * https://blog.csdn.net/cherrydreamsover/article/details/80518759
 * https://blog.csdn.net/derrantcm/article/details/46691013
 * <p>
 * 剑指20题目
 *
 * @author Aria
 * @time on 2019-04-06.
 */
public class PrintMatrix {
    public static void printMatrix(int[][] arr) {
        if (arr == null) {
            return;
        }
        int start = 0;
        int row = arr.length;
        int col = arr[0].length;
        while (row > start * 2 && col > start * 2) {
            printCircle(arr, row, col, start);
            start++;
        }

    }

    private static void printCircle(int[][] arr, int row, int col, int start) {
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        //从左到右
        for (int i = start; i <= endX; i++) {
            System.out.print(arr[start][i] + " ");
        }
        //从上向下打印
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(arr[i][endX] + " ");
            }
        }

        //从右到左
        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(arr[endY][i] + " ");
            }
        }

        //从上到下打印
        if (start < endY - 1 && start < endX) {
            for (int i = endY - 1; i > start; i--) {
                System.out.print(arr[i][start] + " ");
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
        printMatrix(numbers);
        System.out.println();

        int[][] numbers2 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12},

        };
        printMatrix(numbers2);
        System.out.println();


        int[][] numbers3 = {
                {1, 2, 3, 4, 5, 6, 7, 8}
        };
        printMatrix(numbers3);
        System.out.println();

        int[][] numbers4 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {16, 15, 14, 13, 12, 11, 10, 9}
        };
        printMatrix(numbers4);
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
        printMatrix(numbers5);
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
        printMatrix(numbers6);
        System.out.println();


        int[][] numbers7 = {
                {1, 2},
                {4, 3}
        };
        printMatrix(numbers7);
        System.out.println();

        int[][] numbers8 = {
                {1}
        };
        printMatrix(numbers8);
        System.out.println();

        // 0个元素的数组
        printMatrix(new int[][]{{}});
        // 空数组
        printMatrix(null);
    }
}
