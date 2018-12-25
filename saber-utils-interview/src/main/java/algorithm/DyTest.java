package algorithm;

import java.util.ArrayList;

/**
 * @author Aria
 * @time on 2018-12-24.
 */
public class DyTest {
    public static void main(String[] args) {
        //数塔取数
        int[][] tower = {{13}, {11, 8}, {12, 7, 26}, {6, 14, 15, 8}, {12, 7, 13, 24, 11}};
        int result = Dynamic.dataTower(tower);
        //编辑距离
       /* String aStr = "qbcde";
        String bStr = "qbcdw";
        Dynamic.editDistance(aStr,bStr);*/
        //数组取数
       // Dynamic.matrixFetch();
        ArrayList<Integer> arrayList = null;
       /* //背包问题
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c = BackPack_Solution(m, n, w, p);
        System.out.println(c);*/
        //lcsChun("123","6");
        //最大字段和
        int[] sub = {-2, -100, -9, -1};
        System.out.println(Dynamic.maxSubSum1(sub));
    }
}
