package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 16:50
 * Declaration: All Rights Reserved !!!
 */
public class Test16 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    /**
     * ����һ������������һ�������ͷ��㣬��ת�����������ת�������ͷ��㡣
     *
     * @param head �����ͷ���
     * @return ��ת��������ͷ���
     */
    public static ListNode reverseList(ListNode head) {
        // ����һ����ʱ��㣬����β�巨���߼�ͷ���
        ListNode root = new ListNode();
        // �߼�ͷ�������һ�����Ϊ��
        root.next = null;

        // ���ڼ�¼Ҫ�������һ�����
        ListNode next;
        // ��ǰ����Ľ�㲻Ϊ��
        while (head != null) {
            // ��¼Ҫ�������һ�����
            next = head.next;
            // ��ǰ������һ�����ָ���߼�ͷ������һ�����
            head.next = root.next;
            // �߼�ͷ������һ�����ָ��ǰ����Ľ��
            root.next = head;
            // ������������һ������ͷ��

            // ��ǰ���ָ����һ��Ҫ����Ľ��
            head = next;
        }

        // �߼�ͷ������һ�������Ƿ��غ��ͷ���
        return root.next;
    }

    /**
     * ����һ������������һ�������ͷ��㣬��ת�����������ת�������ͷ��㡣
     * ���鱾�ϵķ�������ʹ���߼�ͷ��㡿
     *
     * @param head �����ͷ���
     * @return ��ת��������ͷ���
     */
    public static ListNode reverseList2(ListNode head) {
        // ���ڼ�¼��ת��������ͷ���
        ListNode reverseHead = null;
        // ���ڼ�¼��ǰ����Ľ���
        ListNode curr = head;
        // ���ڼ�¼��ǰ����ǰ�����
        // ǰ����㿪ʼΪnull����Ϊ���Ƿ�ת������һ��������һ����㣬��null
        ListNode prev = null;
        // ��ǰ������һ�����
        ListNode next;

        // ���������β�巨����
        while (curr != null) {
            // ��¼��ǰ����Ľ�㣬���һ����¼�Ľ����Ƿ�ת���ͷ���
            // ��ע�⣺�����ϵĲ�ͬ����Ϊcurr.next=nullʱ��curr��ʱ�����һ������Ľ�㣬
            // ��Ӧ����ת���������ǵ�һ����㣬��������������ȷ��ֻ�Ƕ���һЩ�жϣ����Բ�Ҫif��
            reverseHead = curr;
            // ��¼��Ȼǰ��һ�����
            next = curr.next;
            // ��ǰ������һ�����ָ��ǰ����㣬������ǰ���Ͳ��뵽�˷�ת�����ͷ��
            curr.next = prev;
            // ��¼��ǰ���Ϊǰ�����
            prev = curr;
            // ��ǰ�����ƶ�����һ�����
            curr = next;
        }

        // ����ת���ͷ���
        return reverseHead;
    }


    /**
     * ��������Ԫ��ֵ
     *
     * @param head �����ͷ���
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;

        head.next = new ListNode();
        head.next.value = 2;

        head.next.next = new ListNode();
        head.next.next.value = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        printList(head);
        head = reverseList(head);
        printList(head);
        head = reverseList2(head);
        printList(head);

    }
}
