package algorithm.leetCode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II 杨辉三角之二
 * http://www.cnblogs.com/grandyang/p/4031536.html
 * https://www.cnblogs.com/springfor/p/3887913.html
 *下面讲解转自Alf的：
 *
 * “如果没有这个O(k)空间的限制，那么可以一行一行迭代生成。如果要直接生成第i行，假设生成k=3，可以这样考虑这样的一个过程：
 *
 * 1 0 0 0    k = 0
 * 1 1 0 0    k = 1
 *
 * 1 1 1 0
 *
 * 1 2 1 0    k = 2
 *
 * 1 2 1 1
 *
 * 1 2 3 1
 *
 * 1 3 3 1    k = 3
 * 上述过程实际上就是一个in-place的迭代过程。每当生成下一行的时候，首先数组相应位置1，然后从右向左计算每一个系数。
 *
 * ”
 * @author Aria
 * @time on 2019-03-07.
 */
public class L119 {
    public static void main(String[] args) {
        getRow(3);
    }


    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            result.add(0);
        }
        result.set(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            result.set(i, 1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}
