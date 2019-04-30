package algorithm.leetCode.medium.tree;

import algorithm.leetCode.TreeNode;

/**
 * 二叉树展开为链表
 * https://www.cnblogs.com/springfor/p/3864355.html
 *
 * @author Aria
 * @time on 2019-04-22.
 */
public class L114 {
    TreeNode lastVisited = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode realRight = root.right;
        if (lastVisited != null) {
            lastVisited.left = null;
            lastVisited.right = root;
        }

        lastVisited = root;
        flatten(root.left);
        flatten(realRight);
    }
}
