package algorithm.leetCode.medium;

import algorithm.leetCode.ListNode;

/**
 * 交换链表节点
 *
 * @author Aria
 * @time on 2019-04-15.
 */
public class L24 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode.printList(swapPairs(n1));
    }

    static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode tmp = pre.next.next;
            pre.next.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
            pre = tmp.next;
        }
        return dummy.next;
    }

    ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = head.next;
        head.next = swapPairs(head.next.next);
        t.next = head;
        return t;
    }


}
