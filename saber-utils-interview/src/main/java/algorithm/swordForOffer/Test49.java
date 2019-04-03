package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-06-14
 * Time: 16:26
 * Declaration: All Rights Reserved !!!
 */
public class Test49 {

    /**
     * ��Ŀ��ʵ��һ������stringToInt,ʵ�ְ��ַ���ת��������������ܣ�
     * ����ʹ��atoi�����������ƵĿ⺯����
     *
     * @param num
     * @return
     */
    public static int stringToInt(String num) {

        if (num == null || num.length() < 1) {
            throw new NumberFormatException(num);
        }

        char first = num.charAt(0);
        if (first == '-') {
            return parseString(num, 1, false);
        } else if (first == '+') {
            return parseString(num, 1, true);
        } else if (first <= '9' && first >= '0') {
            return parseString(num, 0, true);
        } else {
            throw new NumberFormatException(num);
        }
    }

    /**
     * �ж��ַ��Ƿ�������
     *
     * @param c �ַ�
     * @return true�ǣ�false��
     */
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * ���ַ������н���
     *
     * @param num      ���ִ�
     * @param index    ��ʼ����������
     * @param positive ���������Ǹ���
     * @return ���ؽ��
     */
    private static int parseString(String num, int index, boolean positive) {

        if (index >= num.length()) {
            throw new NumberFormatException(num);
        }

        int result;
        long tmp = 0;
        while (index < num.length() && isDigit(num.charAt(index))) {
            tmp = tmp * 10 + num.charAt(index) - '0';
            // ��֤��ĵõ�ֵ������������������ֵ
            if (tmp > 0x8000_0000L) {
                throw new NumberFormatException(num);
            }
            index++;
        }

        if (positive) {
            if (tmp >= 0x8000_0000L) {
                throw new NumberFormatException(num);
            } else {
                result = (int) tmp;
            }
        } else {
            if (tmp == 0x8000_0000L) {
                result = 0x8000_0000;
            } else {
                result = (int) -tmp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt(Integer.MIN_VALUE + ""));
//        System.out.println(0x8000_0000L);
//        System.out.println(stringToInt(""));
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("+123"));
        System.out.println(stringToInt("-123"));
        System.out.println(stringToInt("1a123"));
        System.out.println(stringToInt("+2147483647"));
        System.out.println(stringToInt("-2147483647"));
        System.out.println(stringToInt("+2147483648"));
        System.out.println(stringToInt("-2147483648"));
//        System.out.println(stringToInt("+2147483649"));
//        System.out.println(stringToInt("-2147483649"));
//        System.out.println(stringToInt("+"));
//        System.out.println(stringToInt("-"));
    }

}
