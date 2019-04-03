package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 15:17
 * Declaration: All Rights Reserved !!!
 */
public class Test13 {
    /**
     * ������
     */
    public static class ListNode {
        int value; // ���������ֵ
        ListNode next; // ��һ�����
    }

    /**
     * �������������ͷָ���һ�����ָ�룬����һ��������0(1)ʱ��ɾ���ý��,
     * ��ע��1������������ı��ϵĲ�һ�������ϵ�û�з���ֵ�������ΪJAVA���ô��ݵ�ԭ��
     * ���ɾ���Ľ����ͷ��㣬��������÷���ֵ�ķ�ʽ����ôͷ�����Զɾ�����ˡ�
     * ��ע��2������Ĵ�ɾ���������Ǵ������еĽ�㣬����������������������û����б�֤��
     *
     * @param head        ������ͷ
     * @param toBeDeleted ��ɾ���Ľ��
     * @return ɾ�����ͷ���
     */
    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {

        // �����������п�ֵ�ͷ��ر�ͷ���
        if (head == null || toBeDeleted == null) {
            return head;
        }

        // ���ɾ������ͷ��㣬ֱ�ӷ���ͷ������һ�����
        if (head == toBeDeleted) {
            return head.next;
        }

        // �������������������������

        // �ڶ���ڵ������£����ɾ���������һ��Ԫ��
        if (toBeDeleted.next == null) {
            // �Ҵ�ɾ��Ԫ�ص�ǰ��
            ListNode tmp = head;
            while (tmp.next != toBeDeleted) {
                tmp = tmp.next;
            }
            // ɾ�������
            tmp.next = null;

        }
        // �ڶ���ڵ������£����ɾ������ĳ���м���
        else {
            // ����һ������ֵ���뵱ǰ��ɾ���Ľ��
            toBeDeleted.value = toBeDeleted.next.value;
            // ��ɾ���Ľ�����һ��ָ��ԭ�ȴ�ɾ�����ŵ����¸���㣬������ɾ������һ�����ɾ��
            toBeDeleted.next = toBeDeleted.next.next;
        }

        // ����ɾ���ڵ�������ͷ���
        return head;
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

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;

        head = deleteNode(head, null); // ɾ���Ľ��Ϊ��
        printList(head);
        ListNode node = new ListNode();
        node.value = 12;

        head = deleteNode(head, head); // ɾ��ͷ���
        printList(head);
        head = deleteNode(head, last); // ɾ��β���
        printList(head);
        head = deleteNode(head, middle); // ɾ���м���
        printList(head);

        head = deleteNode(head, node); // ɾ���Ľ�㲻��������
        printList(head);
    }
}
