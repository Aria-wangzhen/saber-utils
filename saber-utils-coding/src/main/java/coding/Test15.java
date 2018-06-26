package coding;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 16:20
 * Declaration: All Rights Reserved !!!
 */
public class Test15 {
    public static class ListNode {
        int value;
        ListNode next;
    }

    /**
     * ����һ����������������е�����k ����㣮Ϊ�˷��ϴ�����˵�ϰ�ߣ�
     * �����1��ʼ�������������β����ǵ�����1����㣮����һ��������6����㣬
     * ��ͷ��㿪ʼ���ǵ�ֵ������1��2��3��4��5 6���������ĵ�����3�������ֵΪ4�Ľ�㣮
     *
     * @param head �����ͷ���
     * @param k    ������k�����
     * @return ������k�����
     */
    public static ListNode findKthToTail(ListNode head, int k) {

        // �����������Ϊ�գ�����k����0
        if (k < 1 || head == null) {
            return null;
        }

        // ָ��ͷ���
        ListNode pointer = head;

        // ������k������뵹����һ��������k-1��λ��
        // pointer����k-1��λ��
        for (int i = 1; i < k; i++) {
            // ˵�����н��
            if (pointer.next != null) {
                pointer = pointer.next;
            }
            // �Ѿ�û�нڵ��ˣ�����i��û�е���k-1˵��k̫��������û����ô���Ԫ��
            else {
                // ���ؽ��
                return null;
            }

        }

        // pointer��û���ߵ������ĩβ����ôpointer��headһ���ߣ�
        // ��pointer�ߵ����һ����㼴��pointer.next=nullʱ��head���ǵ�����k�����
        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }

        // ���ؽ��
        return head;
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

        System.out.println(findKthToTail(head, 1).value); // ������һ��
        System.out.println(findKthToTail(head, 5).value); // �м��һ��
        System.out.println(findKthToTail(head, 9).value); // �������һ������˳����һ��

        System.out.println(findKthToTail(head, 10));
    }
}
