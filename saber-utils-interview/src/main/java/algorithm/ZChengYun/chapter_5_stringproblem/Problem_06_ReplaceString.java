package algorithm.ZChengYun.chapter_5_stringproblem;


/**
 * 替换字符串中连续出现的指定的字符串
 */
public class Problem_06_ReplaceString {

    public static String replace(String str, String from, String to) {
        if (str == null || from == null || str.equals("") || from.equals("")) {
            return str;
        }
        char[] strArr = str.toCharArray();
        char[] fromArr = from.toCharArray();
        int match = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == fromArr[match]) {
                ++match;
                if (match == fromArr.length) {
                    clear(strArr, i, fromArr.length);
                    match = 0;
                }
            } else {
                if (strArr[i] == fromArr[0]) {
                    i--;
                }
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != 0) {
                cur = cur + String.valueOf(strArr[i]);
            }
            if (strArr[i] == 0 && (i == 0 || strArr[i - 1] != 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        if (!cur.equals("")) {
            res = res + cur;
        }
        return res;
    }

    public static void clear(char[] chas, int end, int len) {
        while (len-- != 0) {
            chas[end--] = 0;
        }
    }

    public static void main(String[] args) {
        String str = "abc1abcabc1234abcabcabc5678";
        String from = "abc";
        String to = "XY";
        System.out.println(replace(str, from, to));

        str = "abc";
        from = "123";
        to = "X";
        System.out.println(replace(str, from, to));

    }

}
