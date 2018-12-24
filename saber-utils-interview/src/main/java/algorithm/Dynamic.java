package algorithm;


import java.util.Scanner;

/**
 * 来源：https://www.cnblogs.com/huststl/p/8664608.html
 *
 * @author Aria
 * @time on 2018/12/20.
 */
public class Dynamic {

    public static void main(String[] args) {
        //int[][] tower = {{13}, {11, 8}, {12, 7, 26}, {6, 14, 15, 8}, {12, 7, 13, 24, 11}};
        //int result = dataTower(tower);
        //editDistance();
        //matrixFetch();

        //背包问题
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c = BackPack_Solution(m, n, w, p);
        System.out.println(c);
    }

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
    public static void editDistance() {
        //Scanner scan = new Scanner(System.in);
        String aStr = "qbcde";
        String bStr = "qbcdw";
        int aLen = aStr.length();//
        int bLen = bStr.length();
        int[][] dp = new int[aLen + 1][bLen + 1];//存储结果集
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
                if (aStr.charAt(i - 1) == bStr.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //修改，删除，插入的代价
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                System.out.println(dp[i][j]);
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
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int BackPack_Solution(int m, int n, int[] w, int[] p) {
        //value[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int value[][] = new int[n + 1][m + 1];
        //行初始化
        for (int i = 0; i < n + 1; i++) {
            value[i][0] = 0;
        }
        //列初始化
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

