package algorithm.leetCode.simple;

/**
 * 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * http://www.cnblogs.com/grandyang/p/4219878.html
 *
 * @author Aria
 * @time on 2019-03-24.
 */
public class L172 {
    public static void main(String[] args) {
        trailingZeroes(25);
    }
    public static int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
