package dataStructure;

import java.util.LinkedList;

/**
 * 来源：https://blog.csdn.net/sheepmu/article/details/28941285
 *
 * @author Aria
 * @time on 2018/12/23.
 */
public class BinaryBaseTree {
    private TreeNode root;// 根节点

    public BinaryBaseTree() {
    }

    public BinaryBaseTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 递归 前续遍历
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + "  ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * 递归 中续遍历
     */
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue() + "  ");
            inOrder(node.getRight());
        }
    }

    /**
     * 递归 后续遍历
     */
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValue() + "  ");
        }
    }

    /**
     * 非递归 前续遍历
     */
    public void preOrderNoRecursion() {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode current = null;
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.getValue() + "  ");
            if (current.getRight() != null)
                stack.push(current.getRight());
            if (current.getLeft() != null)
                stack.push(current.getLeft());
        }
        System.out.println();
    }

    /**
     * 非递归 中续遍历
     */
    public void inorderNoRecursion() {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.getValue() + "  ");
                current = current.getRight();
            }
        }
        System.out.println();
    }

    /**
     * 非递归 后续遍历
     */
    public void postorderNoRecursion() {
        TreeNode rNode = null;
        TreeNode current = root;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            while (current != null && (current.getRight() == null || current.getRight() == rNode)) {
                System.out.print(current.value + "  ");
                rNode = current;
                if (stack.isEmpty()) {
                    System.out.println();
                    return;
                }
                current = stack.pop();
            }
            stack.push(current);
            current = current.getRight();
        }
    }

    public static void main(String[] args) {
        TreeNode l2 = new TreeNode("E", null, null);//这五行构造一棵二叉树
        TreeNode r2 = new TreeNode("D", null, null);
        TreeNode l1 = new TreeNode("B", null, r2);// 根节点左子树
        TreeNode r1 = new TreeNode("C", l2, null);// 根节点右子树
        TreeNode root = new TreeNode("A", l1, r1);// 创建根节点

        BinaryBaseTree bt = new BinaryBaseTree(root);
        System.out.print(" 递归 前序遍历------->");
        bt.preOrder(bt.getRoot());
        System.out.print(" 非递归 前序遍历------->");
        bt.preOrderNoRecursion();
        System.out.print(" 递归 中序遍历------->");
        bt.inOrder(bt.getRoot());
        System.out.print(" 非递归 中序遍历------->");
        bt.inorderNoRecursion();
        System.out.print(" 递归 后序遍历------->");
        bt.postOrder(bt.getRoot());
        System.out.print(" 非递归 后序遍历------->");
        bt.postorderNoRecursion();

    }
}
