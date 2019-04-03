package algorithm.leetCode.simple;

/**
 * Single Number 单独的数字
 * http://www.cnblogs.com/grandyang/p/4130577.html
 *
 * @author Aria
 * @time on 2019-03-20.
 */
public class L136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;

    }

}
