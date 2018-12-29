import dataStructure.listList.ListNode;

import java.util.Stack;

/**
 * @author Aria
 * @time on 2018-12-29.
 */
public class PraTest {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};

        /*---------------------------------------------------排序和查找---------------------------------------------------*/

       /* System.out.print("排序前：");
        printArr(numbers);*/
        //快排
       /* quickSort(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);*/
        //归并
       /* mergeSort(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);*/
        //二分查找
        // System.out.print("二分查找：" + twoSearch(numbers, 2));

        /*---------------------------------------------------链表---------------------------------------------------*/

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        //System.out.println("链表的长度 - 遍历：" + Practise.linkLength(n1));
        //System.out.println("链表的长度 - 递归：" + Practise.linkLengthRec(n1));
        //System.out.println("链表的倒数第K个节点 ：" + Practise.getKNode(n1,7).getValue());
        //System.out.println("删除链表的倒数第K个节点 ：" + Practise.deleteK(n1,2).getValue());
        //System.out.println("链表的中间节点 ：" + Practise.getMid(n1));
        //System.out.println("链表是否有环 ：" + Practise.isHaveC(n1));
        //System.out.println("链表环入口节点 ：" + (null == Practise.isFirstC(n1) ? "无环" : Practise.isFirstC(n1).getValue()));
        //System.out.println("链表环,环的长度 ：" + (Practise.isCLength(n1)));
        //System.out.println("两个单链表是否相交 ：" + (Practise.isXJ(n1,n1)));
       /* System.out.println("从尾到头打印打单链表 - 遍历：");
        Practise.reversePrintListStack(n1);
        System.out.println("从尾到头打印打单链表 - 递归：");
        Practise.reversePrintListStackRec(n1);*/
        //System.out.println("逆置单链表 - 遍历 栈：" );
        //printLinkList(Practise.reverseListStack(n1));
        System.out.println("逆置单链表(遍历 - 尾巴迁移)：" );
        printLinkList(Practise.reverseList(n1));



    }

    private static void printLinkList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
    }

    private static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");

    }
}
