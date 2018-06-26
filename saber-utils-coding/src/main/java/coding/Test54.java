package coding;

/**
 * Author: ������
 * Date: 2015-06-15
 * Time: 13:42
 * Declaration: All Rights Reserved !!!
 */
public class Test54 {
    /**
     * ��Ŀ����ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
     *
     * @param string
     * @return
     */
    public static boolean isNumeric(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }
        int index = 0;

        if (string.charAt(index) == '+' || string.charAt(index) == '-') {
            index++;
        }

        // �Ѿ������ַ�����ĩβ��
        if (index >= string.length()) {
            return false;
        }

        boolean numeric = true;
        index = scanDigits(string, index);
        // ��δ���ַ�����ĩβ
        if (index < string.length()) {
            // �����С����
            if (string.charAt(index) == '.') {
                // �ƶ�����һ��λ��
                index++;
                index = scanDigits(string, index);

                // �Ѿ������ַ�����ĩβ��
                if (index >= string.length()) {
                    numeric = true;
                }
                // ��δ���ַ�������λ��
                else if (index < string.length() && (string.charAt(index) == 'e' || string.charAt(index) == 'E')) {
                    numeric = isExponential(string, index);
                } else {
                    numeric = false;
                }
            }
            // �����ָ����ʶ
            else if (string.charAt(index) == 'e' || string.charAt(index) == 'E') {
                numeric = isExponential(string, index);
            } else {
                numeric = false;
            }

            return numeric;
        }
        // �Ѿ������ַ�����ĩβ�ˣ�˵����û��ָ������
        else {
            return true;
        }

    }

    /**
     * �ж��Ƿ��ǿ�ѧ�������Ľ�β���֣���E5��e5��E+5��e-5��e(E)���������
     *
     * @param string �ַ���
     * @param index  ��ʼƥ���λ��
     * @return ƥ��Ľ��
     */
    private static boolean isExponential(String string, int index) {

        if (index >= string.length() || (string.charAt(index) != 'e' && string.charAt(index) != 'E')) {
            return false;
        }

        // �ƶ�����һ��Ҫ�����λ��
        index++;

        // �����ַ�����ĩβ���ͷ���false
        if (index >= string.length()) {
            return false;
        }

        if (string.charAt(index) == '+' || string.charAt(index) == '-') {
            index++;
        }

        // �����ַ�����ĩβ���ͷ���false
        if (index >= string.length()) {
            return false;
        }

        index = scanDigits(string, index);

        // ����Ѿ������˵����ֵ�ĩβ����Ϊ����ȷ��ָ��
        return index >= string.length();
    }

    /**
     * ɨ���ַ������ֵ����ֲ���
     *
     * @param string �ַ���
     * @param index  ��ʼɨ���λ��
     * @return ��ɨ��λ�ÿ�ʼ��һ�������ַ���λ��
     */
    private static int scanDigits(String string, int index) {
        while (index < string.length() && string.charAt(index) >= '0' && string.charAt(index) <= '9') {
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("123.45e+6") + "[" + true + "]");
        System.out.println(isNumeric("+500") + "[" + true + "]");
        System.out.println(isNumeric("5e2") + "[" + true + "]");
        System.out.println(isNumeric("3.1416") + "[" + true + "]");
        System.out.println(isNumeric("600.") + "[" + true + "]");
        System.out.println(isNumeric("-.123") + "[" + true + "]");
        System.out.println(isNumeric("-1E-16") + "[" + true + "]");
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("1.79769313486232E+308") + "[" + true + "]");
        System.out.println();

        System.out.println(isNumeric("12e") + "[" + false + "]");
        System.out.println(isNumeric("1a3.14") + "[" + false + "]");
        System.out.println(isNumeric("1+23") + "[" + false + "]");
        System.out.println(isNumeric("1.2.3") + "[" + false + "]");
        System.out.println(isNumeric("+-5") + "[" + false + "]");
        System.out.println(isNumeric("12e+5.4") + "[" + false + "]");
    }
}
