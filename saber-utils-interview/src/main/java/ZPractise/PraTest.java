package ZPractise;


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
        n1.next = (n2);
        n2.next = (n3);
        n3.next = (n4);
        n4.next = (n5);
        n5.next = (n6);

        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(2);
        ListNode n23 = new ListNode(3);
        ListNode n24 = new ListNode(4);
        ListNode n25 = new ListNode(5);
        ListNode n26 = new ListNode(6);
        n21.next = (n22);
        n22.next = (n23);
        n23.next = (n24);
        n24.next = (n25);
        n25.next = (n26);
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
        //System.out.println("(重点)逆置单链表 - 遍历 - 尾巴迁移)：" );
        //printLinkList(Practise.reverseList(n1));
        //System.out.println("(重点)逆置单链表 - 递归 ：" );
        //printLinkList(Practise.reverseListRec(n1));
        //System.out.println("合并两个有序链表，使合并后的链表依然有序 - 遍历：");
        // printLinkList(Practise.mergeSortedList1(n1, n21));
        //System.out.println("合并两个有序链表，使合并后的链表依然有序 -递归：");
        //printLinkList(Practise.mergeSortedListRec(n1, n21));

        /*System.out.println("无序链表排序：");
        printLinkList(Practise.sortList(n1));*/

        /*---------------------------------------------------二叉树---------------------------------------------------*/


    /*
                                 A
                               /   \
                             B      C
                            / \        \
                          D    E        F


  */
        TreeNode t1 = new TreeNode("A");
        TreeNode t2 = new TreeNode("B");
        TreeNode t3 = new TreeNode("C");
        TreeNode t4 = new TreeNode("D");
        TreeNode t5 = new TreeNode("E");
        TreeNode t6 = new TreeNode("F");
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        //t3.left = t4;
        TreeNode root = t1;

        TreeNode w1 = new TreeNode("A");
        TreeNode w2 = new TreeNode("B");
        TreeNode w3 = new TreeNode("C");
        TreeNode w4 = new TreeNode("D");
        TreeNode w5 = new TreeNode("E");
        TreeNode w6 = new TreeNode("F");
        w1.left = w3;
        w1.right = w2;
        w2.left = w5;
        w2.right = w4;
        w3.left = w6;
        TreeNode wroot = w1;

        /*System.out.println("二叉树的前序遍历 - 遍历：");
        Practise.preTree(root);
        System.out.println("二叉树的前序遍历 - 递归：");
        Practise.preTreeRec(root);*/

        /*System.out.println("二叉树的中序遍历 - 遍历：");
        Practise.inOrderUnRecur(root);*/

        /*System.out.println("二叉树的后续序遍历 - 遍历 - 两个栈：");
        Practise.postOrderUnRecur(root);
        System.out.println("二叉树的后续序遍历 - 遍历 - 一个栈：");
        Practise.postOrderUnRecur2(root);*/

       /* System.out.println("二叉树的层序遍历(广度优先搜索) - 遍历:");
        Practise.cxTree(root);*/

        /*System.out.println("二叉树的高度 - 递归:" +  Practise.getTreeHighRec(root));
        System.out.println("二叉树的高度 - 遍历 - 层序遍历(广度优先搜索):" +  Practise.getTreeHigh(root));*/

        //System.out.println("二叉树的最小高度 - 遍历:" +  Practise.getTreeMinHighRec(root));

       /* System.out.println("二叉树的节点的个数 - 递归:" + Practise.getNodesNumRec(root));
        System.out.println("二叉树的节点的个数 - 遍历 - 层序遍历(广度优先搜索):" + Practise.getNodesNum(root));*/

        System.out.println("原树:");
        Practise.cxTree(root);
        //System.out.println("求二叉树的镜像(破坏原树) - 递归:");
        //Practise.cxTree(Practise.getJXDesRec(root));
        //System.out.println("求二叉树的镜像(破坏原树) - 遍历(先序遍历 + 加交换):");
        //Practise.cxTree(Practise.getJXDes(root));
        //System.out.println("求二叉树的镜像(新建树) - 递归:");
        //Practise.cxTree(Practise.getJXNewRec(root));
        //System.out.println("求二叉树的镜像(新建树) - 遍历(先序遍历 + 新建树):");
        //Practise.cxTree(Practise.getJXNew(root));
        //System.out.println("判断两颗二叉树是否互为镜像 - 递归:" + Practise.isJXTwoRec(wroot, root));
        //System.out.println("判断两颗二叉树是否互为镜像 -遍历(先序遍历):" + Practise.isJXSelfRec(root));

        System.out.println("判断二叉树是否是平衡二叉树 -递归:" + Practise.isBalance(root));

    }

    private static void printLinkList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    private static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");

    }
}
