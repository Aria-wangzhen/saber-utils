package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;

/**
 * Balanced Binary Tree 平衡二叉树
 * http://www.cnblogs.com/grandyang/p/4045660.html
 * 优化后的方法为：对于每一个节点，我们通过checkDepth方法递归获得左右子树的深度，如果子树是平衡的，则返回真实的深度
 *
 * @author Aria
 * @time on 2019-03-01.
 */
public class L110 {
    public boolean isBalanced(TreeNode root) {
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
}
