package dataStructure.listList;

/**
 * @author Aria
 * @time on 2018/12/11.
 */

import java.util.Stack;

/**
 * 来源：https://blog.csdn.net/sheepmu/article/details/38282457
 * 附加参考：https://blog.csdn.net/fightforyourdream/article/details/16353519
 * 环相关的：https://www.cnblogs.com/xudong-bupt/p/3667729.html
 * 1.链表长度
 * 2.得到链表倒数第k个节点的值
 * 3.删除链表的倒数第k个节点
 * 4.求单链表的中间节点
 * 5.判断链表是否有环
 * 6.找出有环链表的环的入口
 * 7.判断两个单链表是否相交
 * 8.找出两个相交链表的第一个交点
 * 9.从尾到头打印单链表
 * 10.逆置单链表
 * 11.合并两个有序链表，使合并后的链表依然有序
 * 12.在o(1)的时间复杂度删除单链表中指定的某一节点
 * 13.在指定节点前插入一个节点
 * 14.无序链表排序
 * 15.链表首尾交叉排序
 *
 * @author sheepmu
 */

public class List {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        /*System.out.println("链表长度---->" + getLenRec(n1));
        System.out.println("链表倒数第三个节点的值---->" + getLastK(n1, 3));
        System.out.println("删除链表倒数第3个节点---->" + moveLastK(n1, 3));//此时链表已经是 1,2,3,5,6
        System.out.println("删除倒数第k个后的链表长度---->" + getLenRec(n1));
        System.out.println("链表中间节点的值---->" + getMid(n1));
        System.out.println("链表是否有环---->" + isHaveC(n1));
        System.out.println("链表环的入口---->" + getFirstC(n1));
        System.out.println("从尾到头打印单链表---->");
        reversePrintListStack(n1);
        System.out.println("逆置单链表后的头节点--->" + reverseList(n1).value);*/

        printLinkList(sortList(n1));

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
    /**
     * 1.链表长度
     *
     * @param head
     * @return
     */
    public static int getLen(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 1;
        while (head.next != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 1.链表长度                -----递归------
     *
     * @param head
     * @return
     */
    public static int getLenRec(ListNode head) {
        if (head == null) {
            return 0;
        }
        return getLenRec(head.next) + 1;
    }

    /**
     * 2.得到链表倒数第k个节点的值
     * 思路：因为倒数第k个和最后一个相距k-1个节点，故采用前后指针，第一个先走k-1步，即走到第k个，链表我习惯从1开始计算，
     * 然后两个指针在同时走，当前指针p走到末尾时，后指针q的位置刚好是倒数第k个节点。
     */
    public static int getLastK(ListNode head, int k) {
        if (head == null || k <= 0) {
            return -1;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (--k > 0)//让p先走k-1步，即p走到第k个节点，从1开始计数哈~
        {
            fastNode = fastNode.next;
            if (fastNode.next == null) {
                break;//防止输入的倒数k值特别大的异常情况
            }
        }
        if (fastNode.next == null)//说明输入的k超出链表长度范围or等于链表长度，即删除第一个。一定要特别注意这些特别情况，代码的鲁棒性~~
        {
            return head.value;
        } else {
            while (fastNode.next != null) {
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
            return slowNode.value;
        }

    }

    /**
     * 3.删除链表的倒数第k个节点
     * 思路：和上面相比就是要删除倒数第k个，那么就需要记录后指针的前一节点，因为删除链表的本质就是它的前一节点指向它的后一节点
     */

    public static ListNode moveLastK(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (--k > 0)//让p先走k-1步，即p走到第k个节点，从1开始计数哈~
        {
            fast = fast.next;
            if (fast.next == null) {
                break;
            } //防止输入的倒数k值特别大的异常情况
        }
        if (fast.next == null)//说明输入的k超出链表长度范围or等于链表长度，即删除第一个。
        {
            return head.next;
        } else {
            ListNode pre = slow;//用于记录删除节点的前一节点
            while (fast.next != null) {
                pre = slow;
                fast = fast.next;
                slow = slow.next;
            }
            pre.next = slow.next;
            return head;
        }
    }

    /**
     * 4.求单链表的中间节点
     * 前后指针，一个每次走2步一个每次走1步，若链表长度为奇数返回中间值，为偶数返回中间2者的前一者
     */
    public static int getMid(ListNode head) {
        //0个节点和1个节点时
        if (head == null || head.next == null) {
            return -1;
        }
        //两个节点时
        if (head.next.next == null) {
            return head.value;
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
     * 思路：前后指针，一个每次走两步一个每次走一步，若两指针相遇了则说明链表有环
     */
    public static boolean isHaveC(ListNode head) {
        //只有两个节点时也无环吧
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
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

    public static ListNode getFirstC(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //pq相遇后break
                break;
            }
        }
        //无环
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        //把q置于头节点
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 7.判断两个单链表是否相交
     * 思路：若两链表相交，则两链表的尾节点肯定是同一节点
     */

    public boolean isXJ(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return false;
        }

        ListNode tail1 = head1;
        //不包含只有一个节点的情况 ,所以上面需要考虑只有一个节点的情况，但是此时虽只有一个节点都不进入入while,就return时比较就可以了
        while (tail1.next != null) {
            //得到head1的尾巴
            tail1 = tail1.next;
        }
        ListNode tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        return tail1 == tail2;
    }

    /**
     * 8.找出两个相交链表的第一个交点
     * 思路:先让长的链表的指针先走长度差的距离，然后两个指针一起走，相遇的地方便是交点的开始处。
     */
    public static ListNode getFirstJD(ListNode head1, ListNode head2) {
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
     * 9.从尾到头打印单链表
     * 思路：逆序的问题首先想到栈，先进后出，要么用Stack，要么让系统使用栈，即递归~~
     */
    public static void reversePrintListStack(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
            ListNode pop = stack.pop();
            System.out.print(pop.value + " ");
        }
        System.out.println();
    }

    /**
     * 9.从尾到头打印单链表                    -----递归------
     *
     * @param head
     */
    public static void reversePrintListRec(ListNode head) {
        if (head == null) {
            return;
        }
        reversePrintListRec(head.next);  //默认已经把子问题解决了，即已经输出了6-->5-->3-->2,后面只需要再输出头节点的值
        System.out.print(head.value + " ");  //这样理解会方便我们很快写出递归，但是还是要知道递归真正的实现过程~
    }

    /**
     * 10.逆置单链表 --- 遍历 ----
     * 思路：把每次遍历到的都放到新链表的尾巴的前一个
     */
    public static ListNode reverseList(ListNode head) {
        // 如果链表为空或只有一个节点，无需反转，直接返回原链表表头
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newTail = null;  //新链表的尾巴
        ListNode cur = head;

        while (cur != null) {
            ListNode pre = cur;   //新链表尾巴的前一个
            cur = cur.next;    // cur更新到下一个节点
            pre.next = newTail;
            newTail = pre;   // 把尾巴的前一个设为新的尾巴
        }

        return newTail;
    }

    /**
     * 10.逆置单链表                          ----递归-----
     *
     * @param head
     * @return
     */
    public static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reHead = reverseListRec(head.next); //默认为已经逆置好了6-->5-->3-->2,即只需要在2的后面接1，因为2是head.next.所以 head.next.next = head;
        head.next.next = head;
        head.next = null;               // 防止循环链表
        return reHead;
    }

    /**
     * 11.合并两个有序链表，使合并后的链表依然有序
     * 思路：先确定合并后的头节点，然后对比两个链表的每一个节点值，若有个链表没有合并完就直接加在后面就可以了
     */
    public static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
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

        ListNode mergeCur = mergeHead;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                mergeCur.next = head1;       // 把找到较小的元素合并到merge中
                head1 = head1.next;              // 跳过已经合并了的元素
                mergeCur = mergeCur.next;    // 找到下一个准备合并的元素
                mergeCur.next = null;            // 断开mergeCur和后面的联系
            } else {
                mergeCur.next = head2;
                head2 = head2.next;
                mergeCur = mergeCur.next;
                mergeCur.next = null;
            }
        }
        if (head1 != null)    // 合并剩余的元素
            mergeCur.next = head1;
        else if (head2 != null)
            mergeCur.next = head2;
        return mergeCur;
    }

    //11.合并两个有序链表，使合并后的链表依然有序           ----递归-----
    public static ListNode mergeSortedListRec(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        ListNode mergeHead = null;
        if (head1.value < head2.value) {
            mergeHead = head1;
            mergeHead.next = mergeSortedListRec(head1.next, head2);   // 连接已解决的子问题
        } else {
            mergeHead = head2;
            mergeHead.next = mergeSortedListRec(head1, head2.next);
        }
        return mergeHead;
    }

    /**
     * 12.在o(1)的时间复杂度删除单链表中指定的某一节点
     * 对于删除节点，我们普通的思路就是让该节点的前一个节点指向该节点的下一个节点
     * ，这种情况需要遍历找到该节点的前一个节点，时间复杂度为O(n)。对于链表，
     * 链表中的每个节点结构都是一样的，所以我们可以把该节点的下一个节点的数据复制到该节点
     * ，然后删除下一个节点即可。要注意最后一个节点的情况，这个时候只能用常见的方法来操作，先找到前一个节点，但总体的平均时间复杂度还是O(1)
     */
    public void delete(ListNode head, ListNode toDelete) {
        if (toDelete == null) {
            return;
        }
        //带删除的不是尾巴！！！~~~~~~~~~
        if (toDelete.next != null) {
            toDelete.value = toDelete.next.value;
            toDelete.next = toDelete.next.next;
        } else {
            if (head == toDelete)//只有一个节点时
            {
                head = null;
            } else {
                ListNode node = head;
                while (node.next != toDelete) {
                    // 找到倒数第二个节点
                    node = node.next;
                }
                node.next = null;
            }
        }
    }

    /**
     * 14.无序链表排序
     * 采用归并排序，先分成两段分别排序，再合并两段已排序的。O(nlgn)
     */

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

    //15.链表首尾交叉排序

    /**
     * 断成两段，后段逆序，把前段和逆序后的后段交叉排序
     */
    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 找到中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode preReverse = slow; // preReverse不用翻转，因为它永远在最后一个
        if (preReverse == null) {
            return;
        }

        // 翻转后半段
        ListNode reHead = preReverse.next;
        if (reHead == null) {
            return;
        }

        ListNode preCur = reHead.next;
        ListNode cur = reHead.next;
        reHead.next = null;
        while (cur != null) {
            cur = cur.next;
            preCur.next = reHead;
            reHead = preCur;
            preCur = cur;
        }
        preReverse.next = reHead;

        // 交叉合并两个链表
        preReverse.next = null;     // 断开前半段和翻转后的后半段元素
        cur = head;
        while (reHead != null && cur != null) {
            ListNode tmp = cur.next;
            cur.next = reHead;
            reHead = reHead.next;
            cur.next.next = tmp;
            cur = tmp;
            tmp = cur.next;
        }
    }

}

