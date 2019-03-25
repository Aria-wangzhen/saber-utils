package algorithm.leetCode.simple;

/**
 * Excel表列名称
 *
 * @author Aria
 * @time on 2019-03-24.
 */
public class L168 {
    public String convertToTitle(int n) {
        String s = "";
        while (n != 0) {
            int temp = (n - 1) % 26;
            s = (char) ('A' + temp) + s;
            n = (n - 1) / 26;
        }
        return s;
    }
}
