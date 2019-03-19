package algorithm.leetCode.simple;

/**
 * Best Time to Buy and Sell Stock 买卖股票的最佳时间
 * https://www.cnblogs.com/grandyang/p/4280131.html
 *
 * @author Aria
 * @time on 2019-03-13.
 */
public class L121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int res = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            //buy保存当前值前面(含当前值)最小值
            buy = Math.min(buy, price);
            //以前的卖出最大值和当前卖出最大值比较
            res = Math.max(res, price - buy);
        }
        return res;
    }
}
