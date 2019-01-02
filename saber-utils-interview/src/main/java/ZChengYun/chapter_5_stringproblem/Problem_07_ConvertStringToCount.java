package ZChengYun.chapter_5_stringproblem;

/**
 * 字符串的统计字符串
 */
public class Problem_07_ConvertStringToCount {

    /**
     * 字符串的统计字符串
     *
     * @param str
     * @return
     */
    public static String getCountString(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != chs[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(res, String.valueOf(num), "");
    }

    /**
     * @param str
     * @param num
     * @param nextChar
     * @return
     */
    public static String concat(String str, String num, String nextChar) {
        return str + "_" + num + (nextChar.equals("") ? nextChar : "_" + nextChar);
    }

    /**
     * 下标查找数字
     *
     * @param cstr
     * @param index
     * @return
     */
    public static char getCharAt(String cstr, int index) {
        if (cstr == null || cstr.equals("")) {
            return 0;
        }
        char[] chs = cstr.toCharArray();
        boolean stage = true;
        char cur = 0;
        int num = 0;
        int sum = 0;
        for (int i = 0; i != chs.length; i++) {
            if (chs[i] == '_') {
                stage = !stage;
            } else if (stage) {
                sum += num;
                if (sum > index) {
                    return cur;
                }
                num = 0;
                cur = chs[i];
            } else {
                num = num * 10 + chs[i] - '0';
            }
        }
        return sum + num > index ? cur : 0;
    }

    /**
     * 下标查找数字
     *
     * @param cstr
     * @param index
     * @return
     */
    public static char getCharAt1(String cstr, int index) {
        if (cstr == null || cstr.equals("")) {
            return 0;
        }
        int indexLength = -1;
        char result = 0;
        String[] strArr = cstr.split("_");
        for (int i = 0; i < strArr.length; i += 2) {

            if (index <= (indexLength = indexLength + Integer.valueOf(strArr[i + 1]))) {
                return strArr[i].charAt(0);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "aaabbadddffc";
        String res = getCountString(str);
        System.out.println(str);
        System.out.println(res);
        System.out.println("++++++++++++++原有：" + getCharAt(res, 11));
        System.out.println("++++++++++++++自己：" + getCharAt1(res, 11));
    }

}
