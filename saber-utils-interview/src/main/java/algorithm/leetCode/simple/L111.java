package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Minimum Depth of Binary Tree 二叉树的最小深度
 * http://www.cnblogs.com/grandyang/p/4042168.html
 *
 * @author Aria
 * @time on 2019-03-01.
 */
public class L111 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            //防止链表形式的树
            return 1 + minDepth(root.right);
        }
        if (root.left != null && root.right == null) {
            //防止链表形式的树
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));

    }

    /**
     * 遍历
     *
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 1;
        int nextNum = 0;
        int res = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            curNum--;
            if (node.left == null && node.right == null) {
                return res;
            }
            if (node.left != null) {
                nextNum++;
                queue.add(node.left);
            }
            if (node.right != null) {
                nextNum++;
                queue.add(node.right);
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum =0;
                res++;
            }
        }
        return res;

    }
}
