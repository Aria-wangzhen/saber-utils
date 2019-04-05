package algorithm.leetCode.simple;

/**
 * Reverse Integer 翻转整数
 *
 * @author Aria
 * @time on 2019-02-14.
 */
public class L007 {

    public static void main(String[] args) {
        System.out.println(reverse1(1534236469));
    }

    private static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (Math.abs(res) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static int reverse1(int x) {
        long res = 0;
        boolean pos = true;
        if (x < 0) {
            pos = false;
            x *= -1;
        }
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE) {
            return 0;
        }
        if (pos) {
            return (int) res;
        } else {
            return -(int) res;
        }

    }
}
