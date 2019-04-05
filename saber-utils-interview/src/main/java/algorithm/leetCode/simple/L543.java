package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;

/**
 * Diameter of Binary Tree 二叉树的直径：确实有不经过更节点最大的
 * [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
 * http://www.cnblogs.com/grandyang/p/6607318.html
 * <p>
 * https://blog.csdn.net/liyazhou0215/article/details/78253308
 *
 * @author Aria
 * @time on 2019-04-04.
 */
public class L543 {
    /**
     * 设置一个全局变量记录左右子树最大深度和。
     */
    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDepth;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //额外计算最大长度 - 否则两个递归
        maxDepth = Math.max(maxDepth, left + right);
        return Math.max(left, right) + 1;
    }
}
