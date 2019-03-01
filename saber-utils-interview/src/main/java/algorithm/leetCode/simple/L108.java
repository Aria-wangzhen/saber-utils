package algorithm.leetCode.simple;

import algorithm.leetCode.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree 将有序数组转为二叉搜索树
 * http://www.cnblogs.com/grandyang/p/4295245.html
 * https://www.cnblogs.com/springfor/p/3879823.html
 *
 * @author Aria
 * @time on 2019-03-01.
 */
public class L108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {
        if(low > high){
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, low, mid - 1);
        node.right = buildTree(nums, mid + 1, high);
        return node;
    }
}
