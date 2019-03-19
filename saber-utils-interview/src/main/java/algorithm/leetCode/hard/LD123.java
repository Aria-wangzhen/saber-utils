package algorithm.leetCode.hard;

/**
 * Best Time to Buy and Sell Stock III 买股票的最佳时间之三
 * http://www.cnblogs.com/grandyang/p/4281975.html
 * local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)
 * <p>
 * global[i][j] = max(local[i][j], global[i - 1][j])
 *
 * @author Aria
 * @time on 2019-03-13.
 */
public class LD123 {
}
