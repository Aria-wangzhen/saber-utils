package algorithm.leetCode.medium;

import algorithm.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal 二叉树层序遍历
 * http://www.cnblogs.com/grandyang/p/4051321.html
 * https://www.cnblogs.com/springfor/p/3891391.html
 *
 * @author Aria
 * @time on 2019-03-01.
 */
public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 1;
        int nextNum = 0;
        List<Integer> curList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            curNum--;
            curList.add(node.val);
            if (node.left != null) {
                nextNum++;
                queue.add(node.left);
            }
            if (node.right != null) {
                nextNum++;
                queue.add(node.right);
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                res.add(curList);
                curList = new ArrayList<>();
            }

        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        return res;
    }
}
