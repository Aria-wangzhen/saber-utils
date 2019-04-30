package algorithm.ZPractise;


import com.alibaba.fastjson.JSON;

/**
 * @author Aria
 * @time on 2018-12-29.
 */
public class PraTest {
    public static void main(String[] args) {


        /*---------------------------------------------------排序和查找---------------------------------------------------*/

        //algorithm();

        /*---------------------------------------------------链表---------------------------------------------------*/

        linkList();

        /*---------------------------------------------------二叉树---------------------------------------------------*/

        tree();

        /*--------------------------------------------------红黑树---------------------------------------------------*/


        /*---------------------------------------------------动态规划---------------------------------------------------*/
        dynamic();

    }

    private static void dynamic() {
        //先左到右，再从上到下 -- 即先循环行数，再循环列数
        System.out.println("1.数塔取数 - 倒着走，二维数组：");
        int[][] tower = {{13}, {11, 8}, {12, 7, 26}, {6, 14, 15, 8}, {12, 7, 13, 24, 11}};
        Practise.dataTower(tower);

        String str = "1233215869";
        System.out.println("2.最长回文字符串 - 二维数组表示是否:" + Practise.getMaxHW(str));

        //编辑距离
        System.out.println("3.最少编辑次数:");
        String aStr = "qbcde146788148";
        String bStr = "qbcdwewftwegtg";
        Practise.editDistance(aStr, bStr);
        //编辑代价
        System.out.println("4.最小编辑距离代价:");
        String str1 = "ab12cd3";
        String str2 = "abcdf";
        Practise.editDistanceCost(str1, str2, 5, 3, 2);
        // 矩阵取数问题(最大和最小)
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1},
                {8, 8, 4, 0}};
        System.out.println("4.矩阵取数问题(最大和最小):" + Practise.matrixFetchMin(m));
        //最长递增子序列
        int[] longSub = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println("6.最长递增子序列:" + Practise.getLongestSubSequence(longSub));
        //最长连续递增子序列
        int[] sub = {1, 9, 2, 5, 7, 3, 4, 6, 8, 0, 11, 15, 17, 17, 10};
        System.out.println("7.最长连续递增子序列:" + Practise.getLongestString(sub));
        //最大字段和
        int[] subSum = {2, -100, -9, -1, 9, -6, 1};
        System.out.println("8.最大字段和:" + Practise.maxSubSum1(subSum));
        //最长公共子序列路径长度
        String subStr1 = "A1BC2D3EFGH45I6JK7LMN";
        String sunStr2 = "12OPQ3RST4U5V6W7XYZ";
        System.out.println("9.最长公共子序列路径长度:");
        Practise.getLp(subStr1, sunStr2);
        System.out.println("10.最长公共子序列路径:" + Practise.getStringFromLp(subStr1, sunStr2));
        System.out.println("11.最长公共子串:");
        String string1 = "ABC1234567DEFG";
        String string2 = "HIJKL1234567MNOP";
        Practise.getLcsChuan(string1.toCharArray(), string2.toCharArray());
        System.out.println("13.正整数分组:");
        //TODO 实现
        System.out.println("14.斐波那契数列:" + Practise.fbnq(6));
        int[] arr1 = {1, 20, 5, 10, 2, 50, 1};
        int aim1 = 3;
        System.out.println("17.换钱最少货币数(重复):" + Practise.minCoinsRepetition(arr1, aim1));
        int[] arr2 = {10, 100, 2, 5, 5, 5, 10, 1, 1, 1, 2, 100};
        int aim2 = 223;
        System.out.println("18.换钱最少货币数(不重复):" + Practise.minCoins(arr2, aim2));
        int[] coins = {10, 5, 1, 25};
        int aim = 29;
        System.out.println("19.换钱的方法数(可重复)(累加 + ) -- 区别于最大(max)和最小(min):" + Practise.maxCoinWays(coins, aim));

    }

    private static void tree() {
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

        TreeNode m1 = new TreeNode(10);
        TreeNode m2 = new TreeNode(3);
        TreeNode m3 = new TreeNode(5);
        TreeNode m4 = new TreeNode(8);
        TreeNode m5 = new TreeNode(9);
        TreeNode m6 = new TreeNode(10);
        m1.left = m2;
        m1.right = m3;
        m2.left = m4;
        m2.right = m5;
        m3.right = m6;
        TreeNode mroot = m1;

        System.out.println("二叉树的前序遍历(深度优先搜索) - 遍历：");
        Practise.preTree(root);
        System.out.println("二叉树的前序遍历(深度优先搜索) - 递归：");
        Practise.preTreeRec(root);

        System.out.println("二叉树的中序遍历 - 遍历：");
        System.out.println(JSON.toJSONString(Practise.inOrderUnRecur(root)));;

        System.out.println("二叉树的后续序遍历 - 遍历 - 两个栈：");
        Practise.postOrderUnRecur(root);
        System.out.println("二叉树的后续序遍历 - 遍历 - 一个栈：");
        Practise.postOrderUnRecur2(root);

        System.out.println("二叉树的层序遍历(广度优先搜索) - 遍历:");
        Practise.cxTree(root);

        System.out.println("二叉树的高度 - 递归:" + Practise.getTreeHighRec(root));
        System.out.println("二叉树的高度 - 遍历 - 层序遍历(广度优先搜索):" + Practise.getTreeHigh(root));

        System.out.println("二叉树的最小高度 - 遍历:" + Practise.getTreeMinHighRec(root));

        System.out.println("二叉树的节点的个数 - 递归:" + Practise.getNodesNumRec(root));
        System.out.println("二叉树的节点的个数 - 遍历 - 层序遍历(广度优先搜索):" + Practise.getNodesNum(root));

        System.out.println("原树:");
        Practise.cxTree(root);
        System.out.println("求二叉树的镜像(破坏原树) - 递归:");
        Practise.cxTree(Practise.getJXDesRec(root));
        System.out.println("求二叉树的镜像(破坏原树) - 遍历(先序遍历 + 加交换):");
        Practise.cxTree(Practise.getJXDes(root));
        System.out.println("求二叉树的镜像(新建树) - 递归:");
        Practise.cxTree(Practise.getJXNewRec(root));
        System.out.println("求二叉树的镜像(新建树) - 遍历(先序遍历 + 新建树):");
        Practise.cxTree(Practise.getJXNew(root));
        System.out.println("判断两颗二叉树是否互为镜像 - 递归:" + Practise.isJXTwoRec(wroot, root));
        System.out.println("判断两颗二叉树是否互为镜像 -遍历(先序遍历):" + Practise.isJXSelfRec(root));

        System.out.println("判断二叉树是否是平衡二叉树 -递归:" + Practise.isBalance(root));
        System.out.println("二叉树第k层的节点个数 -- 递归:" + Practise.getNodesKRec(root, 4));
        System.out.println("二叉树第k层的节点个数 -- 遍历(层序遍历[广度优先搜索]):" + Practise.getNodesK(root, 4));

        System.out.println("二叉树叶子节点的个数 - 递归:" + Practise.getYeNodesRec(root));
        System.out.println("二叉树叶子节点的个数 - 遍历(前序遍历):" + Practise.getYeNodes(root));
        //System.out.println("二叉树中两节点的最大距离:" + Practise.getMaxDistanceRec(root).maxDistance);

        System.out.println("二叉树中和为某一值的路径:");
        //Practise.findPath(mroot, 25);
        System.out.println("求二叉树中两个节点的最低公共祖先节点:" + Practise.getLastCommonParentRec(root, t4, t5).value);
    }

    private static void linkList() {
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
        System.out.println("链表的长度 - 遍历：" + Practise.linkLength(n1));
        System.out.println("链表的长度 - 递归：" + Practise.linkLengthRec(n1));
        System.out.println("链表的倒数第K个节点 ：" + Practise.getKNode(n1, 7).value);
        System.out.println("删除链表的倒数第K个节点 ：" + Practise.deleteK(n1, 2).value);
        System.out.println("链表的中间节点 ：" + Practise.getMid(n1));
        System.out.println("链表是否有环 ：" + Practise.isHaveC(n1));
        System.out.println("链表环入口节点 ：" + (null == Practise.isFirstC(n1) ? "无环" : Practise.isFirstC(n1).value));
        System.out.println("链表环,环的长度 ：" + (Practise.isCLength(n1)));
        System.out.println("两个单链表是否相交 ：" + (Practise.isXJ(n1, n1)));
        System.out.println("从尾到头打印打单链表 - 遍历：");
        Practise.reversePrintListStack(n1);
        System.out.println("从尾到头打印打单链表 - 递归：");
        Practise.reversePrintListStackRec(n1);
        System.out.println("逆置单链表 - 遍历 栈：");
        printLinkList(Practise.reverseListStack(n1));
        System.out.println("(重点)逆置单链表 - 遍历 - 尾巴迁移)：");
        printLinkList(Practise.reverseList(n1));
        System.out.println("(重点)逆置单链表 - 递归 ：");
        printLinkList(Practise.reverseListRec(n1));
        System.out.println("合并两个有序链表，使合并后的链表依然有序 - 遍历：");
        printLinkList(Practise.mergeSortedList(n1, n21));
        System.out.println("合并两个有序链表，使合并后的链表依然有序 -递归：");
        printLinkList(Practise.mergeSortedListRec(n1, n21));


        System.out.println("无序链表排序：");
        printLinkList(Practise.sortList(n1));
    }

    private static void algorithm() {
        int[] numbers = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        System.out.print("排序前：");
        printArr(numbers);
        //堆排序
        System.out.print("堆排序后：");
        Practise.heapSort(numbers);
        //快排
        Practise.quickSort(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);
        //归并
        Practise.mergeSort(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);
        //二分查找
        System.out.print("二分查找：" + Practise.twoSearch(numbers, 2));
    }

    private static void printLinkList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + "" +
                    "");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    private static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");

    }
}
