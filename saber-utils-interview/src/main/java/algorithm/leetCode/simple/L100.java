package algorithm.leetCode.simple;

import java.util.Stack;

/**
 * Same Tree 判断相同树
 *
 * @author Aria
 * @time on 2019-02-28.
 */
public class L100 {

    /**
     * 递归
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }

    /**
     * 遍历
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTre1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty() && !stack1.isEmpty()) {
            TreeNode cur1 = stack1.pop();
            TreeNode cur2 = stack2.pop();
            if (cur1.val != cur2.val) {
                return false;
            } else {
                if (cur1.right != null) {
                    stack1.push(cur1.right);

                }
                if (cur2.right != null) {
                    stack2.push(cur2.right);
                }
                if (stack1.size() != stack2.size()) {
                    return false;
                }
                if (cur1.left != null) {
                    stack1.push(cur1.left);
                }
                if (cur2.left != null) {
                    stack2.push(cur2.left);
                }
                if (stack1.size() != stack2.size()) {
                    return false;
                }

            }
        }
        return stack1.size() == stack2.size();


    }
}
