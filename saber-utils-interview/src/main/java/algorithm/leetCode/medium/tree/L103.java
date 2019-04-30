package algorithm.leetCode.medium.tree;

import algorithm.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Zigzag Level Order Traversal 二叉树的之字形层序遍历
 * https://www.cnblogs.com/springfor/p/3891393.html
 * http://www.cnblogs.com/grandyang/p/4297009.html
 *
 * @author Aria
 * @time on 2019-04-21.
 */
public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int curLevel = 1;
        int nextLevel = 0;
        boolean reverse = false;
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            curLevel--;
            tmp.add(cur.val);
            if (cur.left != null) {
                nextLevel++;
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                nextLevel++;
                queue.addLast(cur.right);
            }
            if (curLevel == 0) {
                curLevel = nextLevel;
                nextLevel = 0;
                if (reverse) {
                    Collections.reverse(tmp);
                    reverse = false;
                } else {
                    reverse = true;
                }
                //在if里面
                res.add(tmp);
                //重点
                tmp = new ArrayList<>();
            }
        }
        return res;

    }
}
