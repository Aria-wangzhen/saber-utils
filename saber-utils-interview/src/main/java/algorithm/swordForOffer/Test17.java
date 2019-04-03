package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 17:24
 * Declaration: All Rights Reserved !!!
 */
public class Test17 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    /**
     * ����������������������ϲ�����������ʹ�������еĽ����Ȼ�ǰ��յ��������
     *
     * @param head1 ��һ����������
     * @param head2 �ڶ�����������
     * @return �ϲ������������ͷ
     */
    public static ListNode merge(ListNode head1, ListNode head2) {
        // �����һ������Ϊ�գ����صڶ�������ͷ���
        if (head1 == null) {
            return head2;
        }

        // ����ڶ������Ϊ�գ����ص�һ������ͷ���
        if (head2 == null) {
            return head1;
        }

        // ����һ����ʱ��㣬�������Ԫ��ʱ����
        ListNode root = new ListNode();
        // ����ָ��ϲ����������β���
        ListNode pointer = root;

        // ������������Ϊ�վͽ��кϲ�����
        while (head1 != null && head2 != null) {
            // ����Ĳ����ϲ���С��Ԫ��
            if (head1.value < head2.value) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }

            // ��ָ���ƶ����ϲ���������ĩβ
            pointer = pointer.next;
        }

        // ���������if����ֻһ��if���ڵ����ݻ�ִ��

        // �����һ�������Ԫ��δ�����꽫�䣬�ӵ��ϲ���������һ�����֮��
        if (head1 != null) {
            pointer.next = head1;
        }

        // ����ڶ��������Ԫ��δ�����꽫�䣬�ӵ��ϲ���������һ�����֮��
        if (head2 != null) {
            pointer.next = head2;
        }

        // ���ش�����
        return root.next;
    }


    /**
     * ����������������������ϲ�����������ʹ�������еĽ����Ȼ�ǰ��յ��������
     * ��ʹ�õ��ǵݹ�Ľⷨ�����Ƽ����ݹ���õ�ʱ����з�����ջ����Ҫ������ڴ桿
     *
     * @param head1 ��һ����������
     * @param head2 �ڶ�����������
     * @return �ϲ������������ͷ
     */
    public static ListNode merge2(ListNode head1, ListNode head2) {
        // �����һ������Ϊ�գ����صڶ�������ͷ���
        if (head1 == null) {
            return head2;
        }

        // ����ڶ�������Ϊ�գ����ص�һ������ͷ���
        if (head2 == null) {
            return head1;
        }

        // ��¼����������ͷ����С�Ľ��
        ListNode tmp = head1;
        if (tmp.value < head2.value) {
            // �����һ�������ͷ���С���͵ݹ鴦���һ���������һ�����͵ڶ��������ͷ���
            tmp.next = merge2(head1.next, head2);
        } else {
            // ����ڶ��������ͷ���С���͵ݹ鴦���һ�������ͷ���͵ڶ��������ͷ������һ�����
            tmp = head2;
            tmp.next = merge2(head1, head2.next);
        }

        // ���ش�����
        return tmp;
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


        ListNode head2 = new ListNode();
        head2.value = 1;

        head2.next = new ListNode();
        head2.next.value = 3;

        head2.next.next = new ListNode();
        head2.next.next.value = 5;

        head2.next.next.next = new ListNode();
        head2.next.next.next.value = 6;

        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.value = 7;

//        head = merge(head, head2);
        head = merge2(head, head2);
        printList(head);
    }
}
