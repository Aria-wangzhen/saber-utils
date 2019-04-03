package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 13:03
 * Declaration: All Rights Reserved !!!
 */
public class Test11 {

    /**
     * ʵ�ֺ���double Power(double base, int exponent)����base��exponent�η���
     * ����ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ������⡣
     *
     * @param base     ָ��
     * @param exponent ��
     * @return ���
     */
    public static double power(double base, int exponent) {
        // ָ���͵�������ͬʱΪ0
        if (base == 0 && exponent == 0) {
            throw new RuntimeException("invalid input. base and exponent both are zero");
        }

        // ָ��Ϊ0�ͷ���1
        if (exponent == 0) {
            return 1;
        }


        // ��ָ���ľ���ֵ
        long exp = exponent;
        if (exponent < 0) {
            exp = -exp;
        }

        // ���ݴη�
        double result = powerWithUnsignedExponent(base, exp);

        // ָ���Ǹ�����Ҫ��������
        if (exponent < 0) {
            result = 1 / result;
        }

        // ���ؽ��
        return result;
    }

    /**
     * ��һ���������������ݣ����������
     *
     * @param base     ָ��
     * @param exponent ��
     * @return ���
     */
    public static double powerWithUnsignedExponent(double base, long exponent) {
        // ���ָ��Ϊ0������1
        if (exponent == 0) {
            return 1;
        }

        // ָ��Ϊ1�����ص���
        if (exponent == 1) {
            return base;
        }

        // �ݹ���һ���ֵ
        double result = powerWithUnsignedExponent(base, exponent >> 2);

        // �����յ�ֵ������������ͻ�Ҫʣ��һ�ε���
        result *= result;
        if (exponent % 2 != 0) {
            result *= base;
        }

        // ���ؽ��
        return result;
    }

    public static void main(String[] args) {

        System.out.println(0.0000000000000000000000001111 == 0);
        System.out.println(0.0000000000000000000000000000 == 0);

        System.out.println(power(2, -4));
        System.out.println(power(2, 4));
        System.out.println(power(2, 0));
        System.out.println(power(0.00000000000000000000000000001, -1));
        System.out.println(power(0.00000000000000000000000000001, 1));
        System.out.println(power(0.00000000000000000000000000001, 0));
        System.out.println(power(0.00000000000000000000000000000, 0));
    }
}
