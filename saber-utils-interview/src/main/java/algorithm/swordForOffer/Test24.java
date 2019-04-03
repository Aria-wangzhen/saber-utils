package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-24
 * Time: 10:59
 * Declaration: All Rights Reserved !!!
 */
public class Test24 {
    /**
     * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
     * ������򷵻�true�����򷵻�false���������������������������ֶ�������ͬ��
     *
     * @param sequence ĳ�����������ĺ�������Ľ��
     * @return true����������ĳ�����������ĺ�������Ľ����false������
     */
    public static boolean verifySequenceOfBST(int[] sequence) {

        // ��������鲻��Ϊ�գ�����������
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        // �����ݣ��͵��ø�������
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    /**
     * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
     * ���˷�������һ��������ͬ��δ���п�ֵ�жϣ����������Ϊ0��������ص�trueҲ�����ⲻͬ��
     * �˷���ֻ������һ�������ĸ���ʵ�֣�����������Ϊnull�����鳤��Ϊ0�������ִ�н��������ͬ��
     * ��Ҳ����˵�˷���ֻ�������������ݵ�����²�������ķ�������ͬ���Ľ�㣬
     * verifySequenceOfBST(sequence) ===
     * verifySequenceOfBST(sequence, 0, sequence.length - 1)
     * ��sequence�������ݲų���
     * ��
     *
     * @param sequence ĳ�����������ĺ�������Ľ��
     * @param start    ����Ŀ�ʼλ��
     * @param end      ����Ľ���λ��
     * @return true����������ĳ�����������ĺ�������Ľ����false������
     */
    public static boolean verifySequenceOfBST(int[] sequence, int start, int end) {

        // �����ӦҪ���������ֻ��һ�������Ѿ�û������Ҫ����start>end���ͷ���true
        if (start >= end) {
            return true;
        }

        // ���������ҵ�һ�������ڸ���㣨sequence[end]����Ԫ�ص�λ��
        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }

        // ִ�е��˴�[end, index-1]��Ԫ�ض���С�ڸ����ģ�sequence[end]��
        // [end, index-1]���Կ����Ǹ�����������

        // right���ڼ�¼��һ����С�ڸ�����Ԫ�ص�λ��

        int right = index;

        // ������Ҫ��֤[index, end-1]������Ԫ�ض��Ǵ��ڸ�����ġ�A��
        // ��Ϊ[index, end-1]ֻ�г�Ϊ������������
        // �ӵ�һ����С�ڸ�����Ԫ�ؿ�ʼ���ҵ�һ�������ڸ�����Ԫ��
        while (index < end - 1 && sequence[index] > sequence[end]) {
            index++;
        }

        // �����A���������㣬��ôһ����index=end-1��
        // �����������˵��������������[index, end-1]����С�ڵ��ڸ�����Ԫ�أ�
        // �����϶����������Ķ��壬����false
        if (index != end - 1) {
            return false;
        }

        // ִ�е��˴�˵��ֱ��ĿǰΪֹ�����ǺϷ���
        // [start, index-1]Ϊ�������������λ��
        // [index, end-1]Ϊ�������������λ��
        index = right;
        return verifySequenceOfBST(sequence, start, index - 1) && verifySequenceOfBST(sequence, index, end - 1);
    }

    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySequenceOfBST(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySequenceOfBST(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySequenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySequenceOfBST(data4));

        // ����ֻ��1�����
        int[] data5 = {5};
        System.out.println("true: " + verifySequenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySequenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySequenceOfBST(data7));
    }
}
