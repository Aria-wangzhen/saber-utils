package algorithm.ZPractise;


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
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
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
     * 思路:先让长的链表的指针先走长度差的距离，然后两个指针一起走，相遇的地方便是交点的开始处。
     */
    public static ListNode getFirstXJ(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode tail1 = head1;
        int len1 = 1;
        while (tail1.next != null) {
            len1++;
            tail1 = tail1.next;
        }
        ListNode tail2 = head2;
        int len2 = 1;
        while (tail2.next != null) {
            len2++;
            tail2 = tail2.next;
        }
        ListNode n1 = head1;
        ListNode n2 = head2;
        if (len1 > len2) {
            int k = len1 - len2;
            //这样写更精妙~~~~
            while (k-- > 0) {
                n1 = n1.next;
            }
        } else {
            int k = len2 - len1;
            while (k-- > 0) {
                n2 = n2.next;
            }
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
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
            System.out.println(stack.pop().value);
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
        System.out.println(head.value);
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
        ListNode mergeNode = null;
        if (head1.value > head2.value) {
            mergeNode = new ListNode(head2.value);
            mergeNode.next = mergeSortedListRec(head1, head2.next);
        } else {
            mergeNode = new ListNode(head1.value);
            mergeNode.next = mergeSortedListRec(head1.next, head2);
        }

        return mergeNode;
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
     * 1.1 前序遍历(深度优先搜索) -- 遍历
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
     * 1.1 前序遍历(深度优先搜索) -- 递归
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
    public static List<Integer> inOrderUnRecur(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;

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
     * 先序遍历 + 加交换
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
        //Math.abs()取绝对值
        if (Math.abs(getTreeHighRec(root.left) - getTreeHighRec(root.right)) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }


    /**
     * 思路：https://blog.csdn.net/u013276277/article/details/78575033
     * 11.判断二叉树是否是平衡二叉树
     */
    //以下是错误的 见  L110
    /*private boolean isBalanced = true;//最后的返回值

    //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            isBalanced = true;
            return 0;
        }
        int left = getDepth(root.left);//左子树
        int right = getDepth(root.right);//右子树
        int depth = left > right ? left + 1 : right + 1;
        if (Math.abs(left - right) <= 1) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }
        return depth;//下层的深度，上层可以接着用免得再遍历
    }*/
    public boolean isBalanced1(TreeNode root) {
        if (checkDepth(root) == -1) {
            return false;
        } else {
            return true;
        }

    }

    private int checkDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = checkDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = checkDepth(root.right);
        if (right == -1) {
            return -1;
        }
        int diff = Math.abs(left - right);
        if (diff > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
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



    /**
     * 17.二叉树中和为某一值的路径
     * <p>
     * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶销点所经过的结点形成一条路径。
     */



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

        if (commonInLeft != null) {
            return commonInLeft;
        }

        return commonInRight;
    }


    /*--------------------------------------------------红黑树---------------------------------------------------*/


    /*---------------------------------------------------动态规划---------------------------------------------------*/

    /**
     * 1.数塔取数 - 倒着走，二维数组
     */
    public static void dataTower(int[][] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int high = arr.length;
        int len = arr[arr.length - 1].length;
        int[][] dp = new int[high][len];
        int[][] path = new int[high][len];
        //初始化
        for (int i = 0; i < arr[arr.length - 1].length; i++) {
            dp[high - 1][i] = arr[high - 1][i];
        }

        //行
        for (int i = high - 2; i >= 0; i--) {
            //列
            for (int j = 0; j <= i; j++) {
                if (dp[i + 1][j] > dp[i + 1][j + 1]) {
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                    path[i][j] = j;
                } else {
                    dp[i][j] = arr[i][j] + dp[i + 1][j + 1];
                    path[i][j] = j + 1;
                }
            }
        }
        out.println("最大值：" + dp[0][0]);
        int j = path[0][0];
        for (int i = 1; i <= high - 1; i++) {
            System.out.println("第" + i + "层数值：" + arr[i][j]);
            j = path[i][j];
        }

    }

    /**
     * 2.最长回文字符串
     * 二位数组：lps[j][i] 表示以 j 为起始坐标，i 为终点坐标是否为回文子串
     */
    public static String getMaxHW(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        int length = chars.length;
        boolean[][] lps = new boolean[length][length];
        int start = 0;
        int maxLen = 1;
        //终点下标
        for (int i = 0; i < length; i++) {
            //起点
            for (int j = 0; j <= i; j++) {
                //特殊情况处理
                if (i - j < 2) {
                    // 子字符串长度小于 2 的时候单独处理
                    lps[j][i] = (chars[i] == chars[j]);
                } else {
                    // 如果 [i, j] 是回文子串，那么一定有 [j+1, i-1] 也是回子串
                    lps[j][i] = lps[j + 1][i - 1] && (chars[i] == chars[j]);
                }
                if (lps[j][i] && (i - j + 1) > maxLen) {
                    // 如果 [i, j] 是回文子串，并且长度大于 max，则刷新最长回文子串
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return str.substring(start, start + maxLen);
    }

    /**
     * 左程云：218
     * 4.编辑距离 - 二位数据，长度+1(涉及到空字符串编辑)
     * http://www.cnblogs.com/BlackStorm/p/5400809.html
     * dp[i][j] 代表str1[0,...,i-1] 编辑成 str2[0,....,j-1]需要的最少次数
     * dp[i][0] 代表str1[0,...,i-1] 编辑成空串的次数 - 删除
     * dp[0][j] 代表空串 编辑成str2[0,...,j-1]的次数 - 新增
     *
     * @return
     */
    public static void editDistance(String str1, String str2) {
        int aLen = str1.length();
        int bLen = str2.length();
        int[][] dp = new int[aLen + 1][aLen + 1];
        //初始化
        for (int i = 0; i < aLen + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < bLen + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //1为次数
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        System.out.println("最少编辑次数：" + dp[aLen][bLen]);
    }

    /**
     * 左程云：218
     * 4.编辑距离的代价
     */
    public static void editDistanceCost(String str1, String str2, int ic, int dc, int rc) {
        int aLen = str1.length();
        int bLen = str2.length();
        int[][] dp = new int[aLen + 1][aLen + 1];
        //初始化
        for (int i = 0; i < aLen + 1; i++) {
            dp[i][0] = i * dc;
        }
        for (int j = 0; j < bLen + 1; j++) {
            dp[0][j] = j * ic;
        }

        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //1为次数
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rc, Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
                }
            }
        }
        System.out.println("最小编辑距离代价：" + dp[aLen][bLen]);
    }

    /**
     * 左程云：188
     * 5. 矩阵取数问题(最大和最小)
     * 二维数组
     * dp[i][j] 表示从左上角的位置(0,0)走到右下角(i，j)的最小值
     */
    public static int matrixFetchMin(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        //初始化
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }


    /**
     * 6. 最长递增子序列
     * 一维数组：两重循环：
     * dp[i]表示到第i元素时候，递增子序列是多大
     */
    public static int getLongestSubSequence(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int length = array.length;
        int[] dp = new int[length];
        int maxLen = 0;
        //截止下标
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (maxLen < dp[i]) {
                    maxLen = dp[i];
                }
            }
        }
        return maxLen;

    }

    /**
     * 7.最长递增连续子序列
     */
    public static int getLongestString(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int length = array.length;
        int cur = 1;
        int maxLen = 1;
        for (int i = 1; i < length; i++) {
            if (array[i] > array[i - 1]) {
                cur++;
            } else {
                if (maxLen < cur) {
                    maxLen = cur;
                }
                //否则断掉初始化
                cur = 1;
            }


        }
        return maxLen;

    }


    /**
     * 8.最大子段和,当全为负数时候合为0
     * 一维数组
     */
    public static int maxSubSum1(int[] nums) {
        int res = Integer.MIN_VALUE, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //（1）当前最大和 （2）及时更新最大位置
            curSum = Math.max(curSum + nums[i], nums[i]);
            res = Math.max(res, curSum);
        }
        return res;
    }


    /**
     * 左程云：210
     * <p>
     * 9.最长公共子序列路径长度
     * dp[i][j] 表示str1[0,...,i]与str1[0,...,j]最长公共子序列长度，从左到右，从上到下
     */

    public static int[][] getLp(String str1, String str2) {
        if (str1 == null || str1.length() <= 0) {
            return null;
        }
        if (str2 == null || str2.length() <= 0) {
            return null;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int aLen = str1.length();
        int bLen = str2.length();
        int[][] dp = new int[aLen][bLen];
        //初始化
        dp[0][0] = arr1[0] == arr2[0] ? 1 : 0;
        for (int i = 1; i < aLen; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], arr1[i] == arr2[0] ? 1 : 0);
        }
        for (int j = 1; j < bLen; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], arr2[j] == arr1[0] ? 1 : 0);
        }
        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println("最长公共子序列路径长度:" + dp[aLen - 1][bLen - 1]);
        return dp;
    }

    /**
     * 10.最长公共子序列的路径
     */
    public static String getStringFromLp(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getLp(str1, str2);
        int m = chs1.length - 1;
        int n = chs2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);

    }

    /**
     * 左程云：213
     * 11.最长公共子串
     * 二维数组
     * dp[i][j]表示把str1[i]和str2[j]当做最后字符串的情况下，最长公共子串有多长
     * 从左向右，再从上到下
     */
    public static int[][] getLcsChuan(char[] str1, char[] str2) {
        int alen = str1.length;
        int blen = str2.length;

        int[][] dp = new int[alen][blen];
        int maxLen = 0;
        //初始化
        for (int i = 0; i < alen; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : 0;
        }
        for (int j = 0; j < blen; j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : 0;
        }

        for (int i = 0; i < alen; i++) {
            for (int j = 0; j < blen; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                }
            }
        }
        out.println("最长公共子串:" + maxLen);
        return dp;
    }


    /**
     * 左程云：213
     * 找到dp最大值和下标，然后截取
     * 12.最长公共子串路径
     */


    /**
     * 13.正整数分组
     */


    /**
     * 左：181
     * <p>
     * 14.斐波那契数列
     */
    public static int fbnq(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1;
        int res = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = tmp + pre;
            pre = tmp;
        }
        return res;
    }

    /**左：181
     * 15.台阶 -- 左
     */

    /**左：181
     * 16.奶牛
     */

    /**
     * 17.换钱最少货币数(前提：钱币值不重复，但是可以重复使用) - 求钱的数量
     * 二维数组
     * dp[i][j]可以使用任意arr[0,..,i]货币的情况下，组成j所需要的最小张数
     * 从左到右，再从上到下
     * dp[i][j] = min{ dp[i-1][j], dp[i][j - arr[i]] + 1 }
     *
     * @link{Problem_03_CoinsMin}
     */
    public static int minCoinsRepetition(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int len = arr.length;
        //因为是钱一定会取到aim下边，所以aim + 1放aim（由于数组从0开始）
        int[][] dp = new int[len][aim + 1];
        //初始化
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }
        //找不开的
        int max = Integer.MAX_VALUE;
        int min = 0;
        for (int j = 0; j <= aim; j++) {
            dp[0][j] = max;
            //其他情况找不开
            //此处处理能找开的情况
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= aim; j++) {
                min = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    min = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j], min);
            }
        }
        return dp[len - 1][aim] != max ? dp[len - 1][aim] : -1;
    }

    /**
     * 18.换钱最少货币数(前提：钱币值不重复，且只能使用一次) - 目的求钱的数量
     * 二维数组
     * dp[i][j]可以使用任意arr[0,..,i]货币的情况下(每个值仅代表一张货币)，组成j所需要的最小张数
     * 初始化不同；
     */
    public static int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int len = arr.length;
        //因为是钱一定会到aim下边（由于数组从0开始）;数据最大下标比长度小1
        int[][] dp = new int[len][aim + 1];
        //找不开的
        int max = Integer.MAX_VALUE;
        int min = 0;
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }
        //只用一张情况下，只有相等才能找开,其他都找不开
        for (int j = 0; j <= aim; j++) {
            dp[0][j] = max;
        }
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= aim; j++) {
                min = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    min = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j], min);
            }
        }
        return dp[len - 1][aim] != max ? dp[len - 1][aim] : -1;

    }


    /**
     * 左程云：196 - 求方法的数量
     * <p>
     * 19.换钱的方法数(前提：钱币值可重复)(累加 + ) -- 区别于最大(max)和最小(min)
     * 二维数组
     * dp[i][j] 表示在使用arr[0,..,i]货币的情况下，组成钱数j有多少种方法
     *
     * @see{Problem_04_CoinsWay}
     */
    public static int maxCoinWays(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int len = arr.length;
        //因为是钱一定会到aim下边（由于数组从0开始）
        int[][] dp = new int[len][aim + 1];
        //初始化
        //不使用任何货币兑换0，也是一种方法
        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
        }
        //在只有arr[0],一种货币情况下。倍数才行，其他不行
        for (int j = 0; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        int sum = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= aim; j++) {
                //每一次都是从新的开始
                sum = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    sum += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = sum;
            }
        }
        return dp[len - 1][aim];


    }

    /**
     * 20.背包问题
     * <p>
     * 参考：https://www.cnblogs.com/lfeng1205/p/5981198.html
     *
     * @param m 表示背包的最大容量 m = 10
     * @param w 表示商品重量数组 w[] = {3, 4, 5}
     * @param p 表示商品价值数组 p[] = {4, 5, 6}
     */
    public static int BackPack_Solution1(int m, int[] w, int[] p) {
        //c[i][j] 表示前i件物品恰放入一个容量为j的背包可以获得的最大价值
        //行是物品数字。列是容量
        //下标会走到n或者m所以加1
        int n = w.length;
        int c[][] = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            //可以重复放
           /* if (j >= w[0]) {
                c[0][j] = (j / w[0]) * p[0];
            } else {
                c[0][j] = 0;
            }*/
            //不可重复放
            if (j >= w[0]) {
                c[0][j] = p[0];
            } else {
                c[0][j] = 0;
            }

        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m ; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i]] + p[i])) {
                        c[i][j] = c[i - 1][j - w[i]] + p[i];
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c[n - 1][m];
    }
    /**
     * 21.汉诺塔问题
     */

    /**
     * 22.字符串交错组成
     */

    /**
     * 23.数字字符串转成字母组合的种数
     */
    /**
     * 24.跳跃游戏
     */
    /**
     * 25.N皇后问题
     */

    /**
     * 26.https://blog.csdn.net/give_me_energy/article/details/51006708
     */

}
