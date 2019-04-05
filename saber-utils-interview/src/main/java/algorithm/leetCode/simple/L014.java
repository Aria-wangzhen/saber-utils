package algorithm.leetCode.simple;

/**
 * Longest Common Prefix 最长共同前缀
 * http://www.cnblogs.com/grandyang/p/4606926.html
 *
 * @author Aria
 * @time on 2019-02-20.
 */
public class L014 {
    public static void main(String[] args) {
        /**
         * ｛int i=0; int j=i++;｝
         * ｛int i=0; int z=++i;}
         * 运算过后，j=0；表明i++是指先把i赋值给j然后再自身加1；
         * 运算过后，z=1；表明++i是指先自身加1后赋值给z；
         * 总之记住++号在后面的意思是先赋值然后自身加1；++在前面的是先自身加1后赋值；
         */
        int i = 0, k = 10;
        while (k-- > 0) {
            i = i++;
        }
        System.out.println(i);
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
