package algorithm.leetCode.simple;

/**
 * Remove Element 移除元素
 * http://www.cnblogs.com/grandyang/p/4606700.html
 *
 * @author Aria
 * @time on 2019-02-20.
 */
public class L027 {
    public static void main(String[] args) {

    }

    public static int strStr(String haystack, String needle) {
        if((needle == null && haystack == null) || (haystack.length() == 0 && needle.length() == 0)){
            return 0;
        }
        if (needle == null) {
            return -1;
        }
        if (haystack == null) {
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();
        if (n > m) {
            return -1;
        }
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == n){
                return i;
            }
        }
        return  -1;

    }
}
