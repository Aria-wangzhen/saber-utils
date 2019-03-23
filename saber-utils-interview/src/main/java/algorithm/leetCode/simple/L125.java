package algorithm.leetCode.simple;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Valid Palindrome 验证回文字符串
 * http://www.cnblogs.com/grandyang/p/4030114.html
 *
 * @author Aria
 * @time on 2019-03-20.
 */
public class L125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toUpperCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isAlpbNum(s.charAt(left))) {
                ++left;
            } else if (!isAlpbNum(s.charAt(right))) {
                --right;
            } else if (s.charAt(left) != (s.charAt(right))) {
                return false;

            } else {
                ++left;
                --right;
            }
        }
        return true;
    }

    public boolean isAlpbNum(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }

        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
}
