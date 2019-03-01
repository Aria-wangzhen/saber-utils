package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;

import java.util.LinkedList;

/**
 * Symmetric Tree 判断对称树
 *
 * @author Aria
 * @time on 2019-03-01.
 */
public class L101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);

    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        queue1.addLast(root.left);
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue2.addLast(root.right);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.removeFirst();
            TreeNode node2 = queue2.removeFirst();
            if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
                return false;
            }
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue1.addLast(node1.left);
            queue1.addLast(node1.right);
            queue2.addLast(node2.right);
            queue2.addLast(node2.left);
        }
        return queue1.size() == queue2.size();
    }
}
