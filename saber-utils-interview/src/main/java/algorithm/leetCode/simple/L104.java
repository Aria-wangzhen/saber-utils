package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;

/**
 * Maximum Depth of Binary Tree 二叉树的最大深度
 *
 * @author Aria
 * @time on 2019-03-01.
 */
public class L104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right));

    }
}
