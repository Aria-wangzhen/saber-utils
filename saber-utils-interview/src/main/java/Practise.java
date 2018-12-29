import dataStructure.listList.ListNode;

import java.util.Stack;

import static algorithm.TestSort.printArr;

/**
 * @author Aria
 * @time on 2018-12-28.
 */
public class Practise {


    /*---------------------------------------------------排序和查找---------------------------------------------------*/

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
            temp = temp.getNext();
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
        return linkLengthRec(head.getNext()) + 1;
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
            fast = fast.getNext();
            if (fast == null) {
                return new ListNode();
            }
        }
        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
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
            fast = fast.getNext();
            if (fast == null) {
                return new ListNode();
            }
        }
        ListNode pre = slow;
        while (fast.getNext() != null) {
            pre = slow;
            fast = fast.getNext();
            slow = slow.getNext();
        }

        pre.setNext(slow.getNext());
        return head;
    }


    /**
     * 4.求单链表的中间节点
     */
    public static int getMid(ListNode head) {
        //0个节点和1个节点时
        if (head == null || head.getNext() == null) {
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        //若只有 一个节点 和 两个节点 时while条件不满足
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow.getValue();
    }

    /**
     * 5.判断链表是否有环
     */
    public static boolean isHaveC(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        //若只有 一个节点 和 两个节点 时while条件不满足
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
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
        if (head == null || head.getNext() == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        //若只有 一个节点 和 两个节点 时while条件不满足
        boolean isHave = false;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
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
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }

    /**
     * 7.有环链表环的长度
     */
    public static int isCLength(ListNode head) {
        if (head == null || head.getNext() == null) {
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;
        //若只有 一个节点 和 两个节点 时while条件不满足
        boolean isHave = false;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                isHave = true;
                break;
            }
        }
        if (!isHave) {
            return 0;
        }
        int length = 0;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            length++;
            fast = fast.getNext().getNext();
            slow = slow.getNext();
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
        while (tmp1.getNext() != null) {
            tmp1 = tmp1.getNext();
        }
        ListNode tmp2 = head2;
        while (tmp2.getNext() != null) {
            tmp2 = tmp2.getNext();
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
        while (tmp1.getNext() != null) {
            len1++;
            tmp1 = tmp1.getNext();
        }
        ListNode tmp2 = head2;
        int len2 = 0;
        while (tmp2.getNext() != null) {
            len2++;
            tmp2 = tmp2.getNext();
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
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            stack.push(tmp);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getValue());
        }
    }

    /**
     * 10.从尾到头打印单链表(递归)
     */
    public static void reversePrintListStackRec(ListNode head) {
        if (head == null) {
            return;
        }
        reversePrintListStackRec(head.getNext());
        System.out.println(head.getValue());
    }

    /**
     * 11.逆置单链表(遍历 - 栈)
     */
    public static ListNode reverseListStack(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.getNext();
        }
        ListNode head1 = stack.pop();
        ListNode tmp2 =  head1;

        while (!stack.isEmpty()) {
            ListNode tmp3 = stack.pop();
            tmp2.setNext(tmp3);
            tmp2 = tmp3;

        }
        head.setNext(null);
        return head1;

    }

    /**
     * 11.逆置单链表(遍历 - 尾巴迁移)
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.getNext() == null){
            return head;
        }
        ListNode tail = null;
        ListNode cur = head;
        while (cur != null){
            ListNode pre = cur;   //新链表尾巴的前一个
            cur = cur.getNext();    // cur更新到下一个节点
            pre.setNext(tail);//尾巴前一个节点
            tail = pre;   // 把尾巴的前一个设为新的尾巴

        }
        return tail;


    }

    /**
     * 11.逆置单链表(递归)
     */
    public static ListNode reverseListRec(ListNode head) {
       return null;
    }

    //  12.合并两个有序链表，使合并后的链表依然有序
    //  13.在o(1)的时间复杂度删除单链表中指定的某一节点
    //  14.在指定节点前插入一个节点
    //  15.无序链表排序
    //  16.链表首尾交叉排序
    /*---------------------------------------------------二叉树---------------------------------------------------*/

    //* 1.二叉树的遍历，前序中序后序，递归和非递归
    // *
    // * @see dataStructure.BinaryBaseTree
    // * http://blog.csdn.net/sheepmu/article/details/28941285
    // * 2.二叉树的层序遍历（广度优先遍历）
    // * 3.二叉树的高度/最小高度
    // * 4.二叉树的节点个数
    // * 5.求二叉树的镜像
    // * 6.判断两颗二叉树是否互为镜像
    // * 7.判断一棵树是否本身就是镜像树
    // * 8.判断两颗二叉树是不是相同的树
    // * 9.判断树1是不是树2的子结构
    // * 10.判断二叉树是否是平衡二叉树
    // * 11.二叉树第k层的节点个数
    // * 12.二叉树叶子节点的个数
    // * 13.由前序遍历和中序遍历重构二叉树
    // * 14.由中序遍历和后序遍历重构二叉树
    // * 15.二叉树中两节点的最大距离
    // * 16.二叉树中和为某一值的路径
    // * 17.求二叉树中两个节点的最低公共祖先节点

    /*--------------------------------------------------红黑树---------------------------------------------------*/


    /*---------------------------------------------------动态规划---------------------------------------------------*/

    //数塔取数
    //最长回文字符串
    //编辑距离
    //编辑距离的代价
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
