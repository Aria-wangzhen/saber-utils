package algorithm.leetCode.medium;

import algorithm.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II 二叉树路径之和之二
 * http://www.cnblogs.com/grandyang/p/4042156.html
 * https://blog.csdn.net/DERRANTCM/article/details/47438073
 *
 * @author Aria
 * @time on 2019-04-04.
 */
public class L113 {


    public List<List<Integer>> findPath(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<List<Integer>>();
        List<Integer> sumList = new ArrayList<Integer>();
        pathSumHelper(root, sum, sumList, pathList);
        return pathList;
    }

    private void pathSumHelper(TreeNode root, int sum, List<Integer> sumList, List<List<Integer>> pathList) {
        if (root == null) {
            return;
        }
        sumList.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                pathList.add(new ArrayList<Integer>(sumList));
            }
        } else {
            if (root.left != null) {
                pathSumHelper(root.left, sum, sumList, pathList);
            }
            if (root.right != null) {
                pathSumHelper(root.right, sum, sumList, pathList);
            }
        }
        sumList.remove(sumList.size() - 1);
    }


}
