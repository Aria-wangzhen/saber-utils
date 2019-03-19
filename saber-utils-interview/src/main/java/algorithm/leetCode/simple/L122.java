package algorithm.leetCode.simple;

/**
 * Best Time to Buy and Sell Stock II 买股票的最佳时间之二
 * http://www.cnblogs.com/grandyang/p/4280803.html
 *
 * @author Aria
 * @time on 2019-03-13.
 */
public class L122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
