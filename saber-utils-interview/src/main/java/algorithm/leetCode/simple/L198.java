package algorithm.leetCode.simple;

/**
 * House Robber 打家劫舍
 * http://www.cnblogs.com/grandyang/p/4383632.html
 *
 * @author Aria
 * @time on 2019-04-01.
 */
public class L198 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        rob(arr);
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        //初始化
        dp[0] = nums[0];
        if (len == 1) {
            return dp[0];
        }

        dp[1] = Math.max(nums[0], nums[1]);
        if (len == 2) {
            return dp[1];
        }
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len-1];


    }
}
