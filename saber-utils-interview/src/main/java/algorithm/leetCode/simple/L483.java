package algorithm.leetCode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aria
 * @time on 2019-04-14.
 */
public class L483 {
    //https://www.cnblogs.com/tanfd/p/6099463.html
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        //差异度指数
        int NumberOfDeference = p.length();
        //窗口左右指针
        int left = 0, right = 0;
        int[] asciiChars = new int[256];
        //记录p中字符有哪些及其数量的数组
        for (int i = p.length() - 1; i >= 0; --i) {
            ++asciiChars[p.charAt(i)];
        }
        //滑动右窗口
        for (; right < s.length(); right++) {
            //在该字符相应位置减一
            asciiChars[s.charAt(right)]--;
            if (asciiChars[s.charAt(right)] >= 0) {
                NumberOfDeference--;
            }
            //如果加进来的那个在p中，NumberOfDeference减一
            if (right - left == (p.length() - 1)) {
                //如果这时窗口大小为p.length()
                if (NumberOfDeference == 0) {
                    //这时出现一次匹配，将左窗口加到result中
                    result.add(left);
                }
                //下面是滑动左窗口的操作
                if (asciiChars[s.charAt(left)] >= 0) {
                    //如果被踢出的那个在p中，NumberOfDeference加一
                    NumberOfDeference++;
                }
                //数组中相应字符计数位置加回来
                asciiChars[s.charAt(left)]++;
                //左窗口向右滑动
                left++;
            }
        }
        return result;
    }
}
