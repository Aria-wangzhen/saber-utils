package algorithm.leetCode.medium;

import algorithm.leetCode.ListNode;

/**
 * Rotate List 旋转链表
 * http://www.cnblogs.com/grandyang/p/4355505.html
 *
 * @author Aria
 * @time on 2019-04-15.
 */
public class L61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            ++n;
            cur = cur.next;
        }
        //首尾相连接
        cur.next = head;
        int m = n - k % n;
        for (int i = 0; i < m; ++i) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode pre = dum;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (cur != pre.next) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }
        return dum.next;
    }
}
