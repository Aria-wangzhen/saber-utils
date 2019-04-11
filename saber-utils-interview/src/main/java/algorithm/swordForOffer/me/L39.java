package algorithm.swordForOffer.me;

import algorithm.dataStructure.tree.TreeNode;

/**
 * @author Aria
 * @time on 2019-04-07.
 */
public class L39 {
    public static boolean isBalanced(TreeNode root) {
        int[] depth = new int[1];
        return isBalancedHelper(root, depth);
    }

    public static boolean isBalancedHelper(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];

        if (isBalancedHelper(root.left, left) && isBalancedHelper(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }

        return false;
    }

}
