package algorithm.leetCode.medium.array;

/**
 * 旋转图像
 * https://www.cnblogs.com/grandyang/p/4389572.html
 *
 * @author Aria
 * @time on 2019-05-28.
 */
public class L48 {

    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            reverse(matrix, i, n-1);
        }

    }

    private void reverse(int[][] matrix, int i, int max) {
        int j = 0;
        while (j < max) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[i][max];
            matrix[i][max] = tmp;
            max--;
            j++;
        }
    }
}
