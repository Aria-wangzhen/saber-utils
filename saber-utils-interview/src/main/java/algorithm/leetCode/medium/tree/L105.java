package algorithm.leetCode.medium.tree;

import algorithm.leetCode.TreeNode;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal 由先序和中序遍历建立二叉树
 * https://blog.csdn.net/DERRANTCM/article/details/47371985
 * http://www.cnblogs.com/grandyang/p/4296500.html
 *
 * @author Aria
 * @time on 2019-04-21.
 */
public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0 || inorder == null || inorder.length <= 0) {
            return null;
        }
        int preLen = preorder.length;
        int inLen = inorder.length;
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);

    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIndx = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndx = i;
                break;
            }
        }

        int len = rootIndx - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, rootIndx - 1);
        root.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, rootIndx + 1, inEnd);
        return root;
    }
}
