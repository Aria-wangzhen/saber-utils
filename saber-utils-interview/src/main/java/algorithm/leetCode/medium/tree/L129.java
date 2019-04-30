package algorithm.leetCode.medium.tree;

import algorithm.leetCode.TreeNode;

import java.util.Stack;

/**
 * Sum Root to Leaf Numbers（所有根到叶子结点组组成的数字相加）
 * http://www.cnblogs.com/grandyang/p/4273700.html
 *
 * @author Aria
 * @time on 2019-04-22.
 */
public class L129 {
    /**
     * 递归
     */
    int sumNumbers(TreeNode root) {
        return sumNumbersDFS(root, 0);
    }

    int sumNumbersDFS(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNumbersDFS(root.left, sum) + sumNumbersDFS(root.right, sum);
    }

    /**
     * 遍历
     *
     * @param root
     * @return
     */
    int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right == null && cur.left == null) {
                res += cur.val;
            }
            if (cur.right != null) {
                cur.right.val += cur.val * 10;
                stack.push(cur.right);
            }
            if (cur.left != null) {
                cur.left.val += cur.val * 10;
                stack.push(cur.left);
            }

        }
        return res;

    }


}
