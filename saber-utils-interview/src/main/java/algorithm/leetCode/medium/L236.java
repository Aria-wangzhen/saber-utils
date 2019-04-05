package algorithm.leetCode.medium;

import algorithm.leetCode.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Tree 二叉树的最小共同父节点
 * https://www.cnblogs.com/grandyang/p/4641968.html
 *
 * @author Aria
 * @time on 2019-04-04.
 */
public class L236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null ||  q == null ){
            return null;
        }
        // 如果有一个match，则说明当前node就是要找的最低公共祖先  注意递归条件！！！！！
        if(root == p || root == q){
            return root;
        }
        TreeNode machLeft = lowestCommonAncestor(root.left, p, q );
        TreeNode machRigth = lowestCommonAncestor(root.right, p, q );
        // 如果一个左子树找到，一个在右子树找到，则说明root是唯一可能的最低公共祖先
        if(machLeft != null && machRigth != null){
            return root;
        }
        // 其他情况是要不然在左子树要不然在右子树
        if(machLeft != null){
            return machLeft;

        }else{
            return machRigth;
        }

    }
}
