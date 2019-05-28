package algorithm.leetCode.medium.array;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author Aria
 * @time on 2019-05-28.
 */
public class L54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length < 1) {
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        while (2 * start < row && 2 * start < col) {
            spiralPrint(matrix, row, col, start, list);
            start++;
        }
        return list;

    }

    private void spiralPrint(int[][] matrix, int row, int col, int start, List<Integer> list) {
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        //从左到右第一行
        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }
        //从上向下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }
        //从右向左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);
            }
        }

        //从下向上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                list.add(matrix[i][start]);
            }
        }
    }
}
