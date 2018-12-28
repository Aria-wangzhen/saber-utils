package algorithm;


import com.alibaba.fastjson.JSON;

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
     * https://blog.csdn.net/afei__/article/details/83214042
     * 最长回文字符串
     * 这道题本质是求字符串中的最大回文字串的长度
     * 动态规划法，
     * 假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出：
     * dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。
     * 这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，
     * 因此需要求出基准情况才能套用以上的公式：
     * a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
     * b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。
     * 有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n^2)的空间。
     *
     * @param s
     * @return
     */
    public static String getLPS(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 第一维参数表示起始位置坐标，第二维参数表示终点坐标
        // lps[j][i] 表示以 j 为起始坐标，i 为终点坐标是否为回文子串
        boolean[][] lps = new boolean[length][length];
        // 记录最长回文子串最长长度
        int maxLen = 1;
        // 记录最长回文子串起始位置
        int start = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 2) {
                    // 子字符串长度小于 2 的时候单独处理
                    lps[j][i] = (chars[i] == chars[j]);
                } else {
                    // 如果 [i, j] 是回文子串，那么一定有 [j+1, i-1] 也是回子串
                    lps[j][i] = lps[j + 1][i - 1] && (chars[i] == chars[j]);
                }
                if (lps[j][i] && (i - j + 1) > maxLen) {
                    // 如果 [i, j] 是回文子串，并且长度大于 max，则刷新最长回文子串
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLen);
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
     * 编辑距离的代价
     * http://www.cnblogs.com/BlackStorm/p/5400809.html
     *
     * @return
     */
    public static int minCost1(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length + 1;
        int col = chs2.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dc * i;
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = ic * j;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[row - 1][col - 1];
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
        for (int i = 0; i < length; i++) {
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
     * 最长公共子序列路径长度
     */
    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }


    /**
     * 最长公共子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int[][] lcsChun1(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < str2.length; j++) {
            if (str1[0] == str2[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    /**
     * 最长公共子串路径
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = lcsChun1(chs1, chs2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
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

