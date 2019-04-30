package algorithm.leetCode.medium.tree;

import algorithm.leetCode.TreeNode;
import com.alibaba.fastjson.JSON;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://blog.csdn.net/DERRANTCM/article/details/47310553
 * 二叉树的中序遍历
 *
 * @author Aria
 * @time on 2019-04-20.
 */
public class L94 {
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> inorderTraversal1(TreeNode root) {
        inorder(root);
        return list;
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;

    }
}
