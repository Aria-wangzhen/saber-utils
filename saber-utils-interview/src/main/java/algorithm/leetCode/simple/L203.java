package algorithm.leetCode.simple;

import algorithm.leetCode.ListNode;

/**
 * @author Aria
 * @time on 2019-04-04.
 */
public class L203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.next == null && head.val == val){
            return null;
        }
        //重点
        ListNode root = new ListNode(-1);
        //重点
        root.next  = head;
        //重点
        ListNode pre = root;
        while(pre.next != null){
            if(pre.next.val != val){
                pre = pre.next;
            }else{
                pre.next =  pre.next.next;
            }
        }
        return root.next;

    }
}
