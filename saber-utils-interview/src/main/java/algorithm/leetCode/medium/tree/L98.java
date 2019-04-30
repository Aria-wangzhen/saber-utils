package algorithm.leetCode.medium.tree;

import algorithm.leetCode.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * 验证二叉搜索树
 * https://blog.csdn.net/DERRANTCM/article/details/47310557
 * 对二叉搜索树进行中序遍历，结果必须从打到小有序
 *
 * @author Aria
 * @time on 2019-04-20.
 */
public class L98 {
    private Stack<Integer> stack = new Stack<>();;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //中序遍历
        inOrder(root);
        int pre = stack.pop();

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (pre <= cur) {
                return false;
            }
            pre = cur;
        }
        return true;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            stack.push(root.val);
            inOrder(root.right);
        }
    }
}
