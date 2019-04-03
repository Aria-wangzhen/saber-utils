package algorithm.ZPractise;

/**
 * @author Aria
 * @time on 2019-01-25.
 */
public class juzhen {
    public static void main(String args[]) {
        int[][] arr = {{0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
        //int[][] arr = {{0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int m = arr.length;
        int n = arr[0].length;
        System.out.println("原有：" + cout(arr, m, n));
    }


    /**
     * @param arr
     * @param m   行数
     * @param n   列数
     * @return
     */
    private static int cout(int[][] arr, int m, int n) {
        int max = -1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1) {
                    int min = arr[i - 1][j - 1];
                    if (arr[i - 1][j] < min) {
                        min = arr[i - 1][j];
                    }
                    if (arr[i][j - 1] < min) {
                        min = arr[i][j - 1];
                    }
                    arr[i][j] += min;
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                    }
                }
            }
        }
        return max;
    }

}
