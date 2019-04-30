package algorithm.leetCode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aria
 * @time on 2019-04-13.
 */
public class L290 {
    public static void main(String[] args) {
        String s = null;
        s.toCharArray();
        wordPattern("abba","dog cat cat fish");
    }
    public static boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strArr[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strArr[i])) {
                    return false;
                } else {
                    map.put(ch, strArr[i]);
                }
            }
        }
        return true;

    }
}
