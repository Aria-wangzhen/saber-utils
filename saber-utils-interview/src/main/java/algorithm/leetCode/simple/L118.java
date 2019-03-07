package algorithm.leetCode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle 杨辉三角
 * https://www.cnblogs.com/springfor/p/3887910.html
 *
 * @author Aria
 * @time on 2019-03-07.
 */
public class L118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return res;
        }

        for (int j = 0; j < numRows; j++) {
            List<Integer> row = new ArrayList<Integer>();
            //开头的1
            row.add(1);
            //除去第一行和第二行才进这个循环
            for (int i = 1; i < j; i++) {
                //当前行的上一行
                List<Integer> prevRow = res.get(j - 1);
                int temp = prevRow.get(i - 1) + prevRow.get(i);
                row.add(temp);
            }
            //除了第一行，末尾接个1
            if (j != 0) {
                row.add(1);
            }
            //行放入list
            res.add(row);
        }
        return res;
    }
}
