package algorithm;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 来源：https://www.cnblogs.com/huststl/p/8664608.html
 *
 * @author Aria
 * @time on 2018/12/20.
 */
public class Dynamic {

    /**
     * 数塔取数
     * 来源：https://blog.csdn.net/tterminator/article/details/50951137?utm_source=blogxgwz3
     *
     * @param tower
     * @return
     */
    public static int dataTower(int tower[][]) {
        int heigh = tower.length;//数塔高度
        int len = tower[heigh - 1].length;//数塔底部宽度
        int[][] resultTower = new int[heigh][len];//结果数塔，存放路径数值和
        int[][] path = new int[heigh][len];//计算结果数塔生成路径

        //初始化结果数塔
        for (int i = 0; i < len; i++) {
            resultTower[heigh - 1][i] = tower[heigh - 1][i];
        }

        //开始计算结果数塔及路径
        for (int i = heigh - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (resultTower[i + 1][j] > resultTower[i + 1][j + 1]) {
                    resultTower[i][j] = tower[i][j] + resultTower[i + 1][j];
                    path[i][j] = j;
                } else {
                    resultTower[i][j] = tower[i][j] + resultTower[i + 1][j + 1];
                    path[i][j] = j + 1;
                }
            }
        }

        //打印路径
        System.out.println("最大数值和为" + resultTower[0][0] + "\n最大数值和路径:");
        System.out.println("第0层数值：" + tower[0][0]);
        int j = path[0][0];
        for (int i = 1; i <= heigh - 1; i++) {
            System.out.println("第" + i + "层数值：" + tower[i][j]);
            j = path[i][j];
        }
        System.out.println();

        return resultTower[0][0];
    }


    /**
     * 编辑距离
     * http://www.cnblogs.com/BlackStorm/p/5400809.html
     *
     * @return
     */
    public static void editDistance(String str1, String str2) {
        //Scanner scan = new Scanner(System.in);
        int aLen = str1.length();
        int bLen = str2.length();
        //存储结果集
        int[][] dp = new int[aLen + 1][bLen + 1];
        //初始化
        for (int i = 0; i < aLen + 1; i++) {
            dp[i][0] = i;
        }
        //初始化
        for (int i = 0; i < bLen + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //修改，删除，插入的代价
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                // System.out.println(dp[i][j]);
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
     * 参考：https://www.cnblogs.com/lfeng1205/p/5981198.html
     *
     * @param m 表示背包的最大容量 m = 10
     * @param n 表示商品个数 n = 3
     * @param w 表示商品重量数组 w[] = {3, 4, 5}
     * @param p 表示商品价值数组 p[] = {4, 5, 6}
     */
    public static int BackPack_Solution(int m, int n, int[] w, int[] p) {
        //value[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int value[][] = new int[n + 1][m + 1];
        //行初始化 --- n 个数
        for (int i = 0; i < n + 1; i++) {
            value[i][0] = 0;
        }
        //列初始化 --- m 重量
        for (int j = 0; j < m + 1; j++) {
            value[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，value[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以value[i][j]为value[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以value[i][j]为value[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (value[i - 1][j] < (value[i - 1][j - w[i - 1]] + p[i - 1])) {
                        value[i][j] = value[i - 1][j - w[i - 1]] + p[i - 1];
                    } else {
                        value[i][j] = value[i - 1][j];
                    }
                } else {
                    value[i][j] = value[i - 1][j];
                }
            }
        }
        return value[n][m];
    }


    /**
     * 最长递增子序列
     * https://blog.csdn.net/lk274857347/article/details/72938050
     *
     * @return
     */
    public static int longestIncreasingSubsequence(int[] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }

        int maxCount = 0;
        int[] dp = new int[length];
        for (
                int i = 0;
                i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
                if (maxCount < dp[i]) {
                    maxCount = dp[i];
                }
            }
        }
        return maxCount;
    }

    /**
     * 最长递增连续子序列
     * https://blog.csdn.net/boguesfei/article/details/82901414
     *
     * @param A
     * @return
     */
    public static int getMaxlength(int[] A) {
        int size = A.length;
        if (size <= 0) {
            return 0;
        }

        int res = 1;
        int current = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] > A[i - 1]) {
                current++;
            } else {
                if (current > res) {
                    res = current;
                }
                current = 1;
            }
        }
        return res;
    }

    /**
     * 最大子段和,当全为负数时候合为0
     *
     * @return
     */
    public static int maxSubSum1(int[] a) {
        int maxSum = 0;
        int nowSum = 0;
        for (int i = 0; i < a.length; i++) {
            nowSum = nowSum + a[i];
            //更新最大子段和
            if (nowSum > maxSum) {
                maxSum = nowSum;
            }
            ////当当前累加和为负数时舍弃，重置为0
            if (nowSum < 0) {
                nowSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * 最长公共子序列
     * https://blog.csdn.net/qq_31881469/article/details/77892324
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[len1][len2];
    }

    /**
     * 最长公共子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int lcsChun(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int result = 0;     //记录最长公共子串长度
        int maxIndex = 0;
        int c[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    //result = Math.max(c[i][j], result);
                } else {
                    c[i][j] = 0;
                }
                if (c[i][j] > result) {
                    result = c[i][j];
                    maxIndex = i;
                }
            }
        }
        System.out.println(str1.substring(maxIndex - result, maxIndex));
        return result;
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

