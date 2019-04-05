package algorithm.leetCode.simple;

/**
 * Palindrome Number 验证回文数字
 *
 * @author Aria
 * @time on 2019-02-19.
 */
public class L008 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        //算法一
        /*String str = String.valueOf(x);
        char[] charStr = str.toCharArray();
        int length = charStr.length;
        int left = 0;
        int right = length - 1;
        if (length == 1) {
            return true;
        }
        while (left < right) {
            if (charStr[left] != charStr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;*/

        //算法二
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }
}
