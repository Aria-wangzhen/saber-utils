package algorithm;

/**
 * @author Aria
 * @time on 2018-12-24.
 */
public class BackPack {
    public static void main(String[] args) {
        int m = 14000;
        int w[] = {3, 4, 5, 1, 6};
        int p[] = {4, 5, 6, 13, 8};
        int n = w.length;
        int[][] a = BackPack_Solution(m, w, p);
        System.out.println("原方法：" + a[n][m]);

        /*for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(a[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }*/
        int[][] c = BackPack_Solution1(m, w, p);
        System.out.println("自己方法：" + c[n - 1][m]);
       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }*/

    }

    /**
     * 不可重复放：（01背包问题）可重复放置
     * https://www.cnblogs.com/lfeng1205/p/5981198.html
     *
     * @param m 表示背包的最大容量 m = 10
     * @param w 表示商品重量数组 w[] = {3, 4, 5}
     * @param p 表示商品价值数组 p[] = {4, 5, 6}
     */
    public static int[][] BackPack_Solution(int m, int[] w, int[] p) {
        //c[i][v] 表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        //行是物品数字。列是容量
        //下标会走到n或者m所以加1
        int n = w.length;
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1])) {
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c;
    }

    /**
     * 可重复放置
     *
     * @param m
     * @param w
     * @param p
     * @return
     */
    public static int[][] BackPack_Solution1(int m, int[] w, int[] p) {
        //c[i][j] 表示前i件物品恰放入一个容量为j的背包可以获得的最大价值
        //行是物品数字。列是容量
        //下标会走到n或者m所以加1
        int n = w.length;
        int c[][] = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            //可以重复放
           /* if (j >= w[0]) {
                c[0][j] = (j / w[0]) * p[0];
            } else {
                c[0][j] = 0;
            }*/
            //不可重复放
            if (j >= w[0]) {
                c[0][j] = p[0];
            } else {
                c[0][j] = 0;
            }

        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i]] + p[i])) {
                        c[i][j] = c[i - 1][j - w[i]] + p[i];
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c;
    }


}
