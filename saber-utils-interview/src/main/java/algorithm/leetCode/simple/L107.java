package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal II 二叉树层序遍历之二
 *
 * @author Aria
 * @time on 2019-03-01.
 */
public class L107 {
    public static void main(String[] args) {
        List<Integer> curList = new ArrayList<>();
        curList.add(0, 1);
        curList.add(0, 2);
        curList.add(0, 3);
        System.out.println(JSON.toJSONString(curList));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
                res.add(0, curList);
                curList = new ArrayList<>();
            }

        }
        return res;

    }
}
