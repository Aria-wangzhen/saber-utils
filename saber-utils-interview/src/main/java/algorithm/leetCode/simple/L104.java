package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;

/**
 * Maximum Depth of Binary Tree 二叉树的最大深度
 *
 * @author Aria
 * @time on 2019-03-01.
 */
public class L104 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    /**
     * 遍历 - 就是平时层序遍历求高度
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {

        return 0;

    }
}
