package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-24
 * Time: 18:08
 * Declaration: All Rights Reserved !!!
 */
public class Test26 {
    /**
     * ����������
     */
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    /**
     * ʵ�ֺ�����һ�����������ڸ��������У�ÿ����������һ��next�ֶ�ָ����һ������⣬
     * ����һ��sibling�ֶ�ָ�������е����������NULL
     *
     * @param head �����ͷ���
     * @return ���ƽ���ͷ���
     */
    public static ComplexListNode clone(ComplexListNode head) {
        // �������Ϊ�վ�ֱ�ӷ��ؿ�
        if (head == null) {
            return null;
        }

        // �ȸ��ƽ��
        cloneNodes(head);
        // ������sibling�ֶ�
        connectNodes(head);
        // �����������֣����ظ��������ͷ���
        return reconnectNodes(head);
    }

    /**
     * ����һ���������ҽ����ƺ�Ľ����뵽�����ƵĽ����棬ֻ���Ӹ��ƽ���next�ֶ�
     *
     * @param head �����������ͷ���
     */
    public static void cloneNodes(ComplexListNode head) {
        // ��������գ����и��Ʋ���
        while (head != null) {
            // ����һ���µĽ��
            ComplexListNode tmp = new ComplexListNode();
            // �������ƽ���ֵ�������ƽ��
//            tmp.value = head.value;
            ///////////////////////////////////////////////////////////////////////////////////////////
            // TODO �˴�Ϊ�������ԣ��ø��ƽ���ֵ��������100���������Ҫ���Խ�����һ����ע�͵�������һ�С�
            tmp.value = head.value + 100;
            ///////////////////////////////////////////////////////////////////////////////////////////

            // ���ƽ���nextָ����һ��Ҫ�����ƵĽ��
            tmp.next = head.next;
            // �����ƽ���nextָ���ƽ��
            head.next = tmp;

            // ��Щ�����Ѿ������һ�����ĸ��Ʋ��Ҳ��뵽�����ƽ��ĺ���
            // heedָ����һ�������ƽ���λ��
            head = tmp.next;
        }
    }

    /**
     * ���ø��ƽ���sibling�ֶ�
     *
     * @param head �����ͷ��
     */
    public static void connectNodes(ComplexListNode head) {
        // ������Ϊ��
        while (head != null) {
            // ��ǰ����Ľ��sibling�ֶβ�Ϊ�գ���Ҫ�����临�ƽ���sibling�ֶ�
            if (head.sibling != null) {
                // ���ƽ���siblingָ�򱻸��ƽ���sibling�ֶε���һ�����
                // head.next�������ƽ�㣬
                // head.sibling����ʾ�����ƽ���sibling��ָ��Ľ�㣬
                // ������һ�����������ĸ��ƽ��
                head.next.sibling = head.sibling.next;
            }
            // ָ����һ��Ҫ����ĸ��ƽ��
            head = head.next.next;
        }
    }

    /**
     * �ո��ƽ��ͱ����ƽ��𿪣���ԭ�����Ƶ�����ͬʱ���ɼ�������
     *
     * @param head �����ͷ���
     * @return ���������ͷ���
     */
    public static ComplexListNode reconnectNodes(ComplexListNode head) {

        // ������Ϊ�վ�ֱ�ӷ��ؿ�
        if (head == null) {
            return null;
        }

        // ���ڼ�¼���������ͷ���
        ComplexListNode newHead = head.next;
        // ���ڼ�¼��ǰ����ĸ��ƽ��
        ComplexListNode pointer = newHead;
        // �����ƽ���nextָ����һ�������ƽ��
        head.next = newHead.next;
        // ָ���µı����ƽ��
        head = head.next;

        while (head != null) {
            // pointerָ���ƽ��
            pointer.next = head.next;
            pointer = pointer.next;
            // head����һ��ָ���ƽ�����һ����㣬��ԭ������Ľ��
            head.next = pointer.next;
            // headָ����һ��ԭ�������ϵĽ��
            head = pointer.next;
        }

        // ���ظ��������ͷ���
        return newHead;
    }

    /**
     * ���������Ϣ
     *
     * @param head ����ͷ���
     */
    public static void printList(ComplexListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    /**
     * �ж����������Ƿ���ͬһ����������ֵ��ͬ
     *
     * @param h1 ����ͷ1
     * @param h2 ����ͷ2
     * @return true������������ͬһ������false������
     */
    public static boolean isSame(ComplexListNode h1, ComplexListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }

        return h1 == null && h2 == null;
    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;

        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next.next;
        head.next.next.next.sibling = head.next;

        ComplexListNode tmp = head;
        printList(head);
        ComplexListNode newHead = clone(head);
        printList(head);
        System.out.println(isSame(head, tmp));
        printList(newHead);
        System.out.println(isSame(head, newHead));


        // ��ָ����������
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        ComplexListNode head2 = new ComplexListNode();
        head2.value = 1;
        head2.next = new ComplexListNode();
        head2.next.value = 2;
        head2.next.next = new ComplexListNode();
        head2.next.next.value = 3;
        head2.next.next.next = new ComplexListNode();
        head2.next.next.next.value = 4;
        head2.next.next.next.next = new ComplexListNode();
        head2.next.next.next.next.value = 5;

        head2.next.sibling = head2.next.next.next.next;
        head2.next.next.next.sibling = head2.next.sibling;
        head2.next.next.sibling = head2.next.next;

        System.out.println("\n");
        tmp = head2;
        printList(head2);
        ComplexListNode newHead2 = clone(head2);
        printList(head2);
        System.out.println(isSame(head2, tmp));
        printList(newHead2);
        System.out.println(isSame(head2, newHead2));


        ComplexListNode head3 = new ComplexListNode();
        head3.value = 1;

        System.out.println("\n");
        tmp = head3;
        printList(head3);
        ComplexListNode newHead3 = clone(head3);
        printList(head3);
        System.out.println(isSame(head3, tmp));
        printList(newHead3);
        System.out.println(isSame(head3, newHead3));

        System.out.println("\n");
        ComplexListNode head4 = clone(null);
        printList(head4);
    }
}
