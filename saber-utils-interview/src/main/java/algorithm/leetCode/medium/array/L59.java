package algorithm.leetCode.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aria
 * @time on 2019-05-28.
 */
public class L59 {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        if (n < 1) {
            return arr;
        }

        int start = 0;
        while (2 * start < n) {
            spiralPrint(arr, n, start);
            start++;
        }
        return arr;
    }


    private void spiralPrint(int[][] matrix, int n, int start) {
        int endX = n - 1 - start;
        int endY = n - 1 - start;

        //从左到右第一行
        for (int i = start; i <= endX; i++) {
            if (start == 0 && i == 0) {
                matrix[start][i] = 1;
            } else {
                matrix[start][i] = matrix[start][i - 1] + 1;
            }

        }
        //从上向下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                matrix[i][endX] = matrix[i - 1][endX] + 1;
            }
        }
        //从右向左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                matrix[endY][i] = matrix[endY][i + 1] + 1;

            }
        }

        //从下向上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                matrix[i][start] = matrix[i + 1][start] + 1;
            }
        }
    }
}
