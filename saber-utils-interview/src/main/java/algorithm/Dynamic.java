package algorithm;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.bind.v2.util.EditDistance;

import java.util.Scanner;

/**
 * 来源：https://www.cnblogs.com/huststl/p/8664608.html
 *
 * @author Aria
 * @time on 2018/12/20.
 */
public class Dynamic {

    /**
     * 数塔取数问题
     *
     * @return
     */
    public static void getNumberFomPyramid() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long max = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = scan.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = scan.nextInt();
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                }
                max = Math.max(dp[i][j], max);
            }
            System.out.println(max);
        }
    }

    /**
     * 编辑距离
     *
     * @return
     */
    public static void editDistance() {
        Scanner scan = new Scanner(System.in);
        String aStr = scan.nextLine();
        String bStr = scan.nextLine();
        int aLen = aStr.length();
        int bLen = bStr.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 0; i < aLen + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < bLen + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (aStr.charAt(i - 1) == bStr.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        System.out.println(dp[aLen][bLen]);
    }


    /**
     * 矩阵取数问题
     *
     * @return
     */
    public static void matrixFetch() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] dp = new int[n + 1];
        int[] readMax = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (int k = 1; k < n + 1; k++) {
                readMax[k] = scan.nextInt();
            }
            for (int j = 1; j < n + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + readMax[j];
            }
        }
        System.out.println(dp[n]);
    }


    /**
     * 背包问题
     *
     * @return
     */
    public static void packProblem() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int v = scan.nextInt();
        int[] dp = new int[v + 1];
        int[] price = new int[n + 1];
        int[] weight = new int[n + 1];
        long max = 0;
        for (int i = 1; i < n + 1; i++) {
            weight[i] = scan.nextInt();
            price[i] = scan.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = v; j > 0; j--) {
                if (j - weight[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);
                } else {
                    dp[j] = dp[i];
                }
            }

        }
        for (int i = 0; i < v + 1; i++) {
            max = max > dp[i] ? max : dp[i];
        }
        System.out.println(max);
    }


    /**
     * 最长递增子序列
     *
     * @return
     */
    public static void longestIncreasingSubsequence() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scan.nextInt();
        }
        double[] dou = new double[n + 1];
        dou[0] = Integer.MIN_VALUE;
        dou[1] = num[0];
        int Len = 1;
        int p, r, m;
        for (int i = 1; i < n; i++) {
            p = 0;
            r = Len;
            while (p <= r) {
                m = (p + r) / 2;
                if (dou[m] < num[i]) {
                    p = m + 1;
                } else {
                    r = m - 1;
                }
            }
            dou[p] = num[i];
            if (p > Len) {
                Len++;
            }
        }
        System.out.println(Len);
    }


    /**
     * 最大子段和
     *
     * @return
     */
    public static int maxSubSum1(int[] a) {
        int maxSum = 0;
        int nowSum = 0;
        for (int i = 0; i < a.length; i++) {
            nowSum = nowSum + a[i];
            if (nowSum > maxSum) {//更新最大子段和
                maxSum = nowSum;
            }
            if (nowSum < 0) {//当当前累加和为负数时舍弃，重置为0
                nowSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * 最长公共子序列Lcs
     *
     * @return
     */
    public static void longestCommonSubsequence() {
        Scanner scan = new Scanner(System.in);
        String aStr = scan.nextLine();
        String bStr = scan.nextLine();
        int aLen = aStr.length();
        int bLen = bStr.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (dp[i - 1][j] == dp[i][j - 1] && aStr.charAt(i - 1) == bStr.charAt(j - 1)
                        && dp[i - 1][j] == dp[i - 1][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int max = dp[aLen][bLen];
        StringBuilder sb = new StringBuilder(128);
        while (max > 0) {
            if (dp[aLen - 1][bLen] == dp[aLen][bLen - 1] && dp[aLen - 1][bLen] + 1 == dp[aLen][bLen]) {
                sb.append(aStr.charAt(aLen - 1));
                max--;
                aLen--;
                bLen--;
            } else {
                if (dp[aLen][bLen - 1] == dp[aLen][bLen]) {
                    bLen--;
                } else {
                    aLen--;
                }
            }
            System.out.println(sb.reverse().toString());
        }
    }

    /**
     * 正整数分组
     *
     * @return
     */
    public static void positiveIntegerGrouping() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long sum = 0, max = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
            sum += nums[i];
        }
        int[] dp = new int[(int) (sum / 2 + 1)];
        for (int i = 0; i < n; i++) {
            for (int j = (int) (sum / 2); j > 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }

        }
        for (int i = 1; i < sum / 2 + 1; i++) {
            max = max > dp[i] ? max : dp[i];
        }
        System.out.println(Math.abs((sum - max) - max));
    }


}

