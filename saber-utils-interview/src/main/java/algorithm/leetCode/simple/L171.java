package algorithm.leetCode.simple;

/**
 * Excel表列序号
 *
 * @author Aria
 * @time on 2019-03-24.
 */
public class L171 {
    public static void main(String[] args) {
        String s = "AAA";
        titleToNumber(s);
    }
    public static int titleToNumber(String s) {
        int len = s.length();
        int result = 0;
        int xishu = 1;
        for(int i = len - 1;i >= 0;i--){
            result = result  + (s.charAt(i) - 'A' + 1)* xishu;
            xishu *= 26;
        }
        return result;
    }
}
