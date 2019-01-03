package ZPractise;


import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static java.lang.System.out;

/**
 * @author Aria
 * @time on 2018-12-28.
 */
public class Practise {


    /*---------------------------------------------------排序和查找---------------------------------------------------*/

    /**
     * 堆排序
     */

    public static void heapSort(int[] arr) {
    }

    /**
     * 快排
     */
    public static int[] quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        return quick(arr, 0, arr.length - 1);

    }

    private static int[] quick(int[] arr, int low, int high) {
        if (low < high) {
            int mid = getMid(arr, low, high);
            quick(arr, 0, mid);
            quick(arr, mid + 1, high);
        }
        return arr;

    }

    private static int getMid(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] > temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[high] < temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;

    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        return mergeSort(arr, 0, arr.length - 1);

    }

    private static int[] mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, 0, mid);
            mergeSort(arr, mid + 1, high);
            twoMerge(arr, low, mid, high);
        }
        return arr;
    }

    private static void twoMerge(int[] arr, int low, int mid, int high) {
        int[] newArr = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left < mid && right < high) {
            if (arr[left] < arr[right]) {
                newArr[k++] = arr[left++];
            } else {
                newArr[k++] = arr[right++];
            }
        }
        while (left <= mid) {
            newArr[k++] = arr[left++];
        }

        while (right <= high) {
            newArr[k++] = arr[right++];
        }
        for (int i = 0; i < newArr.length; i++) {
            arr[i + low] = newArr[i];
        }

    }

    /**
     * 二分查找
     *
     * @param arr
     * @return
     */
    public static Integer twoSearch(int[] arr, int key) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        if (key < arr[0] || key > arr[arr.length - 1]) {
            return null;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            }
            if (key == arr[mid]) {
                return mid;
            }
        }
        return null;
    }


    /*---------------------------------------------------链表---------------------------------------------------*/

    /**
     * 1.链表长度
     */
    public static int linkLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    /**
     * 1.链表长度
     */
    public static int linkLengthRec(ListNode head) {
        if (head == null) {
            return 0;
        }
        return linkLengthRec(head.next) + 1;
    }

    /**
     * 2.得到链表倒数第k个节点的值
     */
    public static ListNode getKNode(ListNode head, int k) {
        if (head == null || k <= 0) {
            return new ListNode();
        }
        ListNode fast = head;
        ListNode slow = head;
        while (--k != 0) {
            fast = fast.next;
            if (fast == null) {
                return new ListNode();
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }


    /**
     * 3.删除链表的倒数第k个节点
     */
    public static ListNode deleteK(ListNode head, int k) {
        if (head == null || k <= 0) {
            return new ListNode();
        }
        ListNode fast = head;
        ListNode slow = head;
        while (--k != 0) {
            fast = fast.next;
            if (fast == null) {
                return new ListNode();
            }
        }
        ListNode pre = slow;
        while (fast.next != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }

        pre.next = slow.next;
        return head;
    }


    /**
     * 4.求单链表的中间节点
     */
    public static int getMid(ListNode head) {
        //0个节点和1个节点时
        if (head == null || head.next == null) {
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        //若只有 一个节点 和 两个节点 时while条件不满足
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.value;
    }

    /**
     * 5.判断链表是否有环
     */
    public static boolean isHaveC(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        //若只有 一个节点 和 两个节点 时while条件不满足
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 6.找出有环链表的环的入口
     * 思路：若有环肯定会在环中相遇第一次相遇的位置到环开始的位置的距离（按环的方向）与头节点到环的开始的距离相等。
     * 故当相遇时，让节点slow置于头节点，让后两个节点同时走，再次相遇处就是环开始的位置。
     */
    public static ListNode isFirstC(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        //若只有 一个节点 和 两个节点 时while条件不满足
        boolean isHave = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isHave = true;
                break;
            }
        }
        if (!isHave) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 7.有环链表环的长度
     */
    public static int isCLength(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;
        //若只有 一个节点 和 两个节点 时while条件不满足
        boolean isHave = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isHave = true;
                break;
            }
        }
        if (!isHave) {
            return 0;
        }
        int length = 0;
        while (fast.next != null && fast.next.next != null) {
            length++;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        return length;
    }

    /**
     * 8.判断两个单链表是否相交
     */
    public static boolean isXJ(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return true;
        }
        ListNode tmp1 = head1;
        while (tmp1.next != null) {
            tmp1 = tmp1.next;
        }
        ListNode tmp2 = head2;
        while (tmp2.next != null) {
            tmp2 = tmp2.next;
        }
        return tmp1 == tmp2;
    }


    /**
     * 9.找出两个相交链表的第一个交点
     */
    public static boolean getFirstXJ(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return true;
        }
        ListNode tmp1 = head1;
        int len1 = 0;
        while (tmp1.next != null) {
            len1++;
            tmp1 = tmp1.next;
        }
        ListNode tmp2 = head2;
        int len2 = 0;
        while (tmp2.next != null) {
            len2++;
            tmp2 = tmp2.next;
        }
        if (len1 > len2) {
            int k = len1 - len2;
            while (--k >= 0) {
            }
        }
        return tmp1 == tmp2;
    }

    /**
     * 10.从尾到头打印单链表(遍历)
     */
    public static void reversePrintListStack(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        stack.push(tmp);
        while (tmp.next != null) {
            tmp = tmp.next;
            stack.push(tmp);
        }
        while (!stack.isEmpty()) {
            out.println(stack.pop().value);
        }
    }

    /**
     * 10.从尾到头打印单链表(递归)
     */
    public static void reversePrintListStackRec(ListNode head) {
        if (head == null) {
            return;
        }
        reversePrintListStackRec(head.next);
        out.println(head.value);
    }

    /**
     * 11.逆置单链表(遍历 - 栈)
     */
    public static ListNode reverseListStack(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        ListNode head1 = stack.pop();
        ListNode tmp2 = head1;

        while (!stack.isEmpty()) {
            ListNode tmp3 = stack.pop();
            tmp2.next = tmp3;
            tmp2 = tmp3;

        }
        head.next = null;
        return head1;

    }

    /**
     * 11.逆置单链表(遍历 - 尾巴迁移)
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = null;
        ListNode cur = head;
        while (cur != null) {
            //顺序不能错
            ListNode pre = cur;   //新链表尾巴的前一个
            cur = cur.next;    // cur更新到下一个节点
            pre.next = tail;//尾巴前一个节点
            tail = pre;   // 把尾巴的前一个设为新的尾巴

        }
        return tail;


    }

    /**
     * 11.逆置单链表(递归)
     */
    public static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return rHead;

    }

    /**
     * 12.合并两个有序链表，使合并后的链表依然有序 - 遍历
     */
    public static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;   // 先确定合并后的头节点
        if (head1.value < head2.value) {
            mergeHead = head1;
            head1 = head1.next;         // 跳过已经合并了的元素
            mergeHead.next = null;  // 断开mergeHead的下一个置空
        } else {
            mergeHead = head2;
            head2 = head2.next;
            mergeHead.next = null;
        }

        ListNode cur = mergeHead;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                cur.next = head1;       // 把找到较小的元素合并到merge中
                head1 = head1.next;              // 跳过已经合并了的元素
                cur = cur.next;    // 找到下一个准备合并的元素
                cur.next = null;            // 断开mergeCur和后面的联系
            } else {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        // 合并剩余的元素
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return mergeHead;
    }


    /**
     * 12.合并两个有序链表，使合并后的链表依然有序 - 递归
     */
    public static ListNode mergeSortedListRec(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if (head1.value < head2.value) {
            mergeHead = head1;
            mergeHead.next = mergeSortedListRec(head1.next, head2);
        } else {
            mergeHead = head2;
            mergeHead.next = mergeSortedListRec(head1, head2.next);
        }
        return mergeHead;
    }

    /**
     * 13.在o(1)的时间复杂度删除单链表中指定的某一节点
     */
    public static void delete(ListNode head, ListNode toDelete) {
        if (head == null) {
            return;
        }
        if (toDelete.next != null) {
            toDelete.next = toDelete.next.next;
            toDelete.value = toDelete.next.value;
        } else {
            if (head.next == null) {
                head = null;
            } else {
                ListNode cur = head;
                while (cur.next != toDelete) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }

    //  14.在指定节点前插入一个节点

    //  15.无序链表排序
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {  // 链表没有元素或是只有一个元素的情况直接返回
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = head;
        // 找到中间节点的前一个
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }

//      System.out.println(preSlow.val);
        // 断开，分成两段
        preSlow.next = null;

        ListNode first = sortList(head);        // 得到以排序好的前半段
        ListNode second = sortList(slow);   // 得到以排序好的后半段


        ListNode dummy = new ListNode(-1);
        ListNode dummyCur = dummy;
        while (first != null && second != null) { // 合并两半段
            if (first.value < second.value) {
                dummyCur.next = first;
                first = first.next;
            } else if (second.value <= first.value) {
                dummyCur.next = second;
                second = second.next;
            }
            dummyCur = dummyCur.next;
        }

        while (first != null) {
            dummyCur.next = first;
            first = first.next;
            dummyCur = dummyCur.next;
        }

        while (second != null) {
            dummyCur.next = second;
            second = second.next;
            dummyCur = dummyCur.next;
        }
        return dummy.next;

    }


    //  16.链表首尾交叉排序

    /*---------------------------------------------------二叉树---------------------------------------------------*/

    /**
     * 1.二叉树的遍历，前序中序后序，递归和非递归
     */

    /**
     * 1.1 前序遍历 -- 遍历
     */
    public static void preTree(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                out.print(node.value + " ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * 1.1 前序遍历 -- 递归
     */
    public static void preTreeRec(TreeNode root) {
        if (root == null) {
            return;
        }
        out.print(root.value + " ");
        preTreeRec(root.left);
        preTreeRec(root.right);

    }

    /**
     * 1.2 中序遍历 -- 遍历
     */
    public static void inOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (head != null || !stack.isEmpty()) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    out.print(head.value + " ");
                    head = head.right;
                }
            }
            System.out.println();
        }

    }

    /**
     * 1.3 后续遍历 -- 两个栈
     */
    public static void postOrderUnRecur(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> out = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    out.push(root);
                    stack.push(root);
                    root = root.right;
                } else {
                    root = stack.pop();
                    root = root.left;
                }
            }
            while (!out.isEmpty()) {
                System.out.print(out.pop().value + " ");
            }
            System.out.println();
        }
    }

    /**
     * 1.3 后续遍历 -- 一个栈
     */
    public static void postOrderUnRecur2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode cur = null;
            while (!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.left != null && cur.left != root && cur.right != root) {
                    stack.push(cur.left);
                } else if (cur.right != null && cur.right != root) {
                    stack.push(cur.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    root = cur;
                }
            }
        }
        System.out.println();
    }

    /**
     * 2.二叉树的层序遍历（广度优先遍历）
     */
    public static void cxTree(TreeNode root) {
        if (root != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.removeFirst();
                System.out.print(cur.value + " ");
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
        }
        System.out.println();

    }

    /**
     * 3.二叉树的高高度 - 递归
     */
    public static int getTreeHighRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeHighRec(root.left), getTreeHighRec(root.right)) + 1;
    }

    /**
     * 3.二叉树的高高度 - 遍历（利用层序遍历[广度优先搜索]）
     */
    public static int getTreeHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int high = 0;
        int curLevel = 1;
        int nextLevel = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            curLevel--;
            if (cur.left != null) {
                nextLevel++;
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                nextLevel++;
                queue.addLast(cur.right);
            }
            if (curLevel == 0) {
                high++;
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return high;
    }

    /**
     * 4.二叉树的最小高度 - 递归
     */
    public static int getTreeMinHighRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(getTreeHighRec(root.left), getTreeHighRec(root.right)) + 1;
    }

    /**
     * 5.二叉树的节点个数 - 递归
     */
    public static int getNodesNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNodesNumRec(root.left) + getNodesNumRec(root.right) + 1;
    }

    /**
     * 5.二叉树的节点个数 - 遍历(利用层序遍历[广度优先搜搜])
     */
    public static int getNodesNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        num++;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if (null != cur.left) {
                queue.addLast(cur.left);
                num++;
            }
            if (null != cur.right) {
                queue.addLast(cur.right);
                num++;
            }
        }
        return num;
    }

    /**
     * 6.求二叉树的镜像(破坏原树) - 递归
     */
    public static TreeNode getJXDesRec(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tLeft = getJXDesRec(root.right);
        TreeNode tRight = getJXDesRec(root.left);
        root.left = tLeft;
        root.right = tRight;
        return root;
    }

    /**
     * 6.求二叉树的镜像(破坏原树) - 遍历
     */
    public static TreeNode getJXDes(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            //交换
            TreeNode tem = cur.right;
            cur.right = cur.left;
            cur.left = tem;

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return root;
    }

    /**
     * 6.求二叉树的镜像(新建树) - 递归
     */
    public static TreeNode getJXNewRec(TreeNode root) {
        if (root == null) {
            return null;
        }
        //一定要走new 创建，不然是老树
        TreeNode newRoot = new TreeNode(root.value);
        newRoot.left = getJXNewRec(root.right);
        newRoot.right = getJXNewRec(root.left);
        return newRoot;

    }

    /**
     * 6.求二叉树的镜像(新建树) - 遍历
     */
    public static TreeNode getJXNew(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> newStack = new Stack<>();
        stack.push(root);
        //每一个节点必须是新的new出来的
        TreeNode newRoot = new TreeNode(root.value);
        newStack.push(newRoot);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode newCur = newStack.pop();

            if (cur.right != null) {
                stack.push(cur.right);
                //每一个节点必须是新的new出来的
                newCur.left = new TreeNode(cur.right.value);
                newStack.push(newCur.left);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                //每一个节点必须是新的new出来的
                newCur.right = new TreeNode(cur.left.value);
                newStack.push(newCur.right);
            }
        }

        return newRoot;

    }

    /**
     * 7.判断两颗二叉树是否互为镜像 - 递归
     */
    public static boolean isJXTwoRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isJXTwoRec(root1.left, root2.right) && isJXTwoRec(root1.right, root2.left);
    }

    /**
     * 8.判断一棵树是否本身就是镜像树
     */
    public static boolean isJXSelfRec(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isJXSelf(root.left, root.right);
    }

    private static boolean isJXSelf(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.value != right.value) {
            return false;
        }
        return isJXSelf(left.left, right.right) && isJXSelf(left.right, right.left);
    }

    /**
     * 9.判断两颗二叉树是不是相同的树 - 递归
     */

    /**
     * 9.判断两颗二叉树是不是相同的树 - 遍历(前序遍历)
     */

    /**
     * 10.判断树1是不是树2的子结构
     */

    /**
     * 11.判断二叉树是否是平衡二叉树
     */
    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getTreeHighRec(root.left) - getTreeHighRec(root.right)) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }

    /**
     * 12.二叉树第k层的节点个数 -- 递归
     */
    public static int getNodesKRec(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getNodesKRec(root.left, k - 1) + getNodesKRec(root.right, k - 1);
    }

    /**
     * 12.二叉树第k层的节点个数 -- 遍历(层序遍历[广度优先搜索])
     */
    public static int getNodesK(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int high = 1;
        int curLevel = 0;
        int nextLevel = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        curLevel++;
        while (!queue.isEmpty() && high < k) {
            TreeNode cur = queue.removeFirst();
            curLevel--;
            if (cur.left != null) {
                queue.addLast(cur.left);
                nextLevel++;
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
                nextLevel++;
            }
            if (curLevel == 0) {
                high++;
                curLevel = nextLevel;
                nextLevel = 0;
            }

        }
        return curLevel;
    }

    /**
     * 13.二叉树叶子节点的个数 - 递归
     */
    public static int getYeNodesRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getYeNodesRec(root.left) + getYeNodesRec(root.right);
    }

    /**
     * 13.二叉树叶子节点的个数 - 遍历(前序遍历)
     */
    public static int getYeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right == null && cur.left == null) {
                num++;
            }
        }
        return num;
    }

    /**
     * 14.由前序遍历和中序遍历重构二叉树
     */

    /**
     * 15.由中序遍历和后序遍历重构二叉树
     */

    /**
     * 16.二叉树中两节点的最大距离
     * 情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
     * * 情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
     * * 只需要计算这两个情况的路径距离，并取其大者，就是该二叉树的最大距离
     */
    public static Result getMaxDistanceRec(TreeNode root) {
        if (root == null) {
            Result empty = new Result(0, -1);        // 目的是让调用方 +1 后，把当前的不存在的 (NULL) 子树当成最大深度为 0
            return empty;
        }

        // 计算出左右子树分别最大距离
        Result lmd = getMaxDistanceRec(root.left);
        Result rmd = getMaxDistanceRec(root.right);

        Result res = new Result();
        res.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;        // 当前最大深度
        // 取情况A和情况B中较大值
        res.maxDistance = Math.max(lmd.maxDepth + rmd.maxDepth, Math.max(lmd.maxDistance, rmd.maxDistance));

        return res;
    }


    public static class Result {
        public int maxDistance;
        public int maxDepth;

        public Result() {
        }

        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }


    /**
     * 17.二叉树中和为某一值的路径
     * <p>
     * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶销点所经过的结点形成一条路径。
     */
    public static void findPath(TreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }
        List<Integer> result = new ArrayList<>();
        findPath(root, 0, expectedSum, result);
    }

    private static void findPath(TreeNode root, int curSum, int expectedSum, List<Integer> result) {
        if (root != null) {
            curSum += root.val;
            result.add(root.val);
            if (curSum < expectedSum) {
                findPath(root.left, curSum, expectedSum, result);
                findPath(root.right, curSum, expectedSum, result);
            } else if (curSum == expectedSum) {
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                }

            }
            result.remove(result.size() - 1);
        }
    }


    /**
     * 18.求二叉树中两个节点的最低公共祖先节点
     */
    public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }

        if (root.equals(n1) || root.equals(n2)) {
            return root;
        }
        TreeNode commonInLeft = getLastCommonParentRec(root.left, n1, n2);
        TreeNode commonInRight = getLastCommonParentRec(root.right, n1, n2);
        if (commonInLeft != null && commonInRight != null) {
            return root;
        }

        if(commonInLeft != null){
            return commonInLeft;
        }

        return commonInRight;
    }


    /*--------------------------------------------------红黑树---------------------------------------------------*/


    /*---------------------------------------------------动态规划---------------------------------------------------*/

    /**
     * 数塔取数
     */

    /**
     * 最长回文字符串
     */

    /**
     * 编辑距离
     */

    /**
     * 编辑距离的代价
     */
    //矩阵取数问题
    //背包问题
    //最长递增子序列
    //最长递增连续子序列
    //最大子段和,当全为负数时候合为0
    //最长公共子序列路径
    //最长公共子序列路径长度
    //最长公共子串
    //最长公共子串路径
    //正整数分组
    //斐波那契数列
    //台阶
    //奶牛
    //矩阵最小路径和
    //换钱最少货币数(重复)
    //换钱最少货币数(不重复)
    //换钱的方法数
    //汉诺塔问题
    //字符串交错组成
    //数字字符串转成字母组合的种数
    //跳跃游戏
    //数组中最长连续的序列
    //N皇后问题
}
