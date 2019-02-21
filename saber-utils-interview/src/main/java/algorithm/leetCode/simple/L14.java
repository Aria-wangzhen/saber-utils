package algorithm.leetCode.simple;

/**
 * Longest Common Prefix 最长共同前缀
 * http://www.cnblogs.com/grandyang/p/4606926.html
 *
 * @author Aria
 * @time on 2019-02-20.
 */
public class L14 {
    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = new String();
        for (int j = 0; j < strs[0].length(); ++j) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;

    }
}
