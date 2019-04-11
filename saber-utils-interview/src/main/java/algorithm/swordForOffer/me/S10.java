package algorithm.swordForOffer.me;

/**
 * 二进制中1的个数
 *
 * @author Aria
 * @time on 2019-04-06.
 */
public class S10 {
    public int count(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n = (n - 1) & n;
        }
        return result;
    }
}
