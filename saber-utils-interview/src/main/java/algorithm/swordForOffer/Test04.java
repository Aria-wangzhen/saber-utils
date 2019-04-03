package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-21
 * Time: 19:09
 * Declaration: All Rights Reserved !!!
 */
public class Test04 {
    /**
     * ��ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"�����硰We are happy.�����������We%20are%20happy.����
     *
     * @param string     Ҫת�����ַ�����
     * @param usedLength �Ѿ��ַ��������Ѿ�ʹ�õĳ���
     * @return ת����ʹ�õ��ַ����ȣ�-1��ʾ����ʧ��
     */
    public static int replaceBlank(char[] string, int usedLength) {
        // �ж������Ƿ�Ϸ�
        if (string == null || string.length < usedLength) {
            return -1;
        }

        // ͳ���ַ������еĿհ��ַ���
        int whiteCount = 0;
        for (int i = 0; i < usedLength; i++) {
            if (string[i] == ' ') {
                whiteCount++;
            }
        }

        // ����ת������ַ������Ƕ���
        int targetLength = whiteCount * 2 + usedLength;
        int tmp = targetLength; // ���泤�Ƚ�����ڷ���
        if (targetLength > string.length) { // ���ת����ĳ��ȴ����������󳤶ȣ�ֱ�ӷ���ʧ��
            return -1;
        }

        // ���û�пհ��ַ��Ͳ��ô���
        if (whiteCount == 0) {
            return usedLength;
        }

        usedLength--; // �Ӻ���ǰ����һ����ʼ������ַ�
        targetLength--; // �������ַ����õ�λ��

        // �ַ����пհ��ַ���һֱ�������еĿհ��ַ�������
        while (usedLength >= 0 && usedLength < targetLength) {
            // ���ǵ�ǰ�ַ��ǿհ��ַ�������"%20"�滻
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else { // �����ƶ��ַ�
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }

        return tmp;
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        int length = replaceBlank(string, 12);
        System.out.println(new String(string, 0, length));
    }
}
