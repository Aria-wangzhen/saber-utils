package algorithm.leetCode.medium;

import algorithm.leetCode.ListNode;
import com.alibaba.fastjson.JSON;

/**
 * @author Aria
 * @time on 2019-04-14.
 */
public class L19 {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode n1 = new ListNode(2);

        //n.next = n1;

        System.out.println(JSON.toJSONString(removeNthFromEnd(n,1)));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <=0 ){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;


    }
}
