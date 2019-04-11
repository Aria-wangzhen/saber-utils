package algorithm.swordForOffer.me;

import algorithm.dataStructure.tree.TreeNode;

/**
 * 由前序和中序遍历重建二叉树
 *
 * @author Aria
 * @time on 2019-04-06.
 */
public class S6 {

    public static TreeNode rebuild(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length <= 0 || inOrder.length <= 0
                || preOrder.length != inOrder.length) {
            return null;
        }
        try {
            return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static TreeNode construct(int[] preOrder, int preLow, int preHigh
            , int[] inOrder, int inLow, int inHigh) throws Exception {
        if (preLow > preHigh) {
            return null;
        }
        int rootValue = preOrder[preLow];
        int index = inLow;
        while (index <= inHigh && inOrder[index] != rootValue) {
            ++index;
        }
        if (index > inHigh) {
            throw new Exception();
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = construct(preOrder, preLow + 1, preLow + index - inLow, inOrder, inLow, index - 1);
        root.right = construct(preOrder, preLow + index - inLow + 1, preHigh, inOrder, index + 1, inHigh);
        return root;
    }

    // 中序遍历二叉树
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }

    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = rebuild(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        TreeNode root = rebuild(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        TreeNode root = rebuild(preorder, inorder);
        printTree(root);
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode root = rebuild(preorder, inorder);
        printTree(root);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode root = rebuild(preorder, inorder);
        printTree(root);
    }

    // 输入空指针
    private static void test6() {
        rebuild(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        TreeNode root = rebuild(preorder, inorder);
        printTree(root);
    }


    public static void main(String[] args) {

        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
        System.out.println();
        test7();


    }
}
