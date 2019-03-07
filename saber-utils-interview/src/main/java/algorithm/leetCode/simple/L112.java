package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;

import java.util.Stack;

/**
 * Path Sum 二叉树的路径和
 * http://www.cnblogs.com/grandyang/p/4036961.html
 * https://www.cnblogs.com/springfor/p/3879825.html
 *
 * @author Aria
 * @time on 2019-03-07.
 */
public class L112 {

    /**
     * 递归
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 递归
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                if (node.val == sum) {
                    return true;
                }
            }
            if (node.right != null) {
                node.right.val += node.val;
                stack.push(node.right);
            }
            if (node.left != null) {
                node.left.val += node.val;
                stack.push(node.left);
            }
        }
        return false;
    }
}
