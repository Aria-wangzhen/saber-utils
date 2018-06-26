package coding;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-06-14
 * Time: 14:57
 * Declaration: All Rights Reserved !!!
 */
public class Test45 {
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        // Ҫɾ��Ԫ�ص�λ��
        int idx = 0;
        // ��ʼ������λ��
        int start = 0;

        while (list.size() > 1) {

            // ֻҪ�ƶ�m-1�ξͿ����ƶ�����һ��Ҫɾ����Ԫ����
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size(); // ��A��
            }

            list.remove(idx);

            // ȷ��idxָ��ÿһ�ֵĵ�һ��λ��
            // ����Ŀ��Բ��ã���A���Ѿ����Ա�֤����ȷ���ˣ����Է���n=6��m=6�ĵ�һ��ɾ�����
        //  if (idx == list.size()) {
        //      idx = 0;
        //  }
        }

        return list.get(0);
    }

    public static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last + m)%i;
        }

        return last;
    }

    public static void main(String[] args) {
        test01();
        System.out.println();
        test02();
    }

    private static void test01() {
        System.out.println(lastRemaining(5, 3)); // �������3
        System.out.println(lastRemaining(5, 2)); // �������2
        System.out.println(lastRemaining(6, 7)); // �������4
        System.out.println(lastRemaining(6, 6)); // �������3
        System.out.println(lastRemaining(0, 0)); // �������-1
    }

    private static void test02() {
        System.out.println(lastRemaining2(5, 3)); // �������3
        System.out.println(lastRemaining2(5, 2)); // �������2
        System.out.println(lastRemaining2(6, 7)); // �������4
        System.out.println(lastRemaining2(6, 6)); // �������3
        System.out.println(lastRemaining2(0, 0)); // �������-1
    }
}
