package algorithm.ZChengYun.chapter_5_stringproblem;

import com.alibaba.fastjson.JSON;

/**
 * 添加最少字符使字符串整体都是回文字符串
 */
public class Problem_13_PalindromeString {


    private static int longestPalindrome(String s) {

        // 不考虑非法输入的情况，比如null
        int maxLen = 0;
        int len = s.length();
        boolean[][] t = new boolean[len][len];

        // 单个字符串都是回文
        for (int i = 0; i < len; i++) {
            t[i][i] = true;
            maxLen = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                t[i][i + 1] = true;
                maxLen = 2;
            }
        }
        // 求长度大于2的子串是否是回文串
        for (int gap = 3; gap <= len; gap++) {
            for (int i = 0, j; (j = i + gap - 1) <= len - 1; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    t[i][j] = t[i + 1][j - 1];
                    if (t[i][j] && gap > maxLen) {
                        maxLen = gap;
                    }
                } else {
                    t[i][j] = false;
                }
            }
        }
        return maxLen;
    }

    /**
     * 添加最少字符使字符串整体都是回文字符串
     *
     * @param str
     * @return
     */
    public static int[][] getDP(char[] str) {
        int[][] dp = new int[str.length][str.length];
        for (int j = 1; j < str.length; j++) {
            dp[j - 1][j] = (str[j - 1] == str[j] ? 0 : 1);
            for (int i = j - 2; i > -1; i--) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp;
    }

    public static String getPalindrome1(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        char[] chas = str.toCharArray();
        int[][] dp = getDP(chas);
        System.out.println(JSON.toJSONString(dp));
        System.out.println(JSON.toJSONString(dp[0][str.length() - 1]));
        char[] res = new char[chas.length + dp[0][chas.length - 1]];
        int i = 0;
        int j = chas.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        while (i <= j) {
            if (chas[i] == chas[j]) {
                res[resl++] = chas[i++];
                res[resr--] = chas[j--];
            } else if (dp[i][j - 1] < dp[i + 1][j]) {
                res[resl++] = chas[j];
                res[resr--] = chas[j--];
            } else {
                res[resl++] = chas[i];
                res[resr--] = chas[i++];
            }
        }
        return String.valueOf(res);
    }


    public static String getPalindrome2(String str, String strlps) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chas = str.toCharArray();
        char[] lps = strlps.toCharArray();
        char[] res = new char[2 * chas.length - lps.length];
        int chasl = 0;
        int chasr = chas.length - 1;
        int lpsl = 0;
        int lpsr = lps.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        int tmpl = 0;
        int tmpr = 0;
        while (lpsl <= lpsr) {
            tmpl = chasl;
            tmpr = chasr;
            while (chas[chasl] != lps[lpsl]) {
                chasl++;
            }
            while (chas[chasr] != lps[lpsr]) {
                chasr--;
            }
            set(res, resl, resr, chas, tmpl, chasl, chasr, tmpr);
            resl += chasl - tmpl + tmpr - chasr;
            resr -= chasl - tmpl + tmpr - chasr;
            res[resl++] = chas[chasl++];
            res[resr--] = chas[chasr--];
            lpsl++;
            lpsr--;
        }
        return String.valueOf(res);
    }

    public static void set(char[] res, int resl, int resr, char[] chas, int ls,
                           int le, int rs, int re) {
        for (int i = ls; i < le; i++) {
            res[resl++] = chas[i];
            res[resr--] = chas[i];
        }
        for (int i = re; i > rs; i--) {
            res[resl++] = chas[i];
            res[resr--] = chas[i];
        }
    }

    public static void main(String[] args) {
        String str = "AB1CD2EFG3H43IJK2L1MN";

        System.out.println(getDP(str.toCharArray())[0][str.length() - 1]);
        System.out.println(getPalindrome1(str));

        String strlps = "1234321";
        System.out.println(getPalindrome2(str, strlps));

    }

}
