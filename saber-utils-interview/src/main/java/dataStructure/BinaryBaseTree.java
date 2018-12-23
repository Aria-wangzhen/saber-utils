package dataStructure;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 来源：https://blog.csdn.net/sheepmu/article/details/28941285
 * 遍历次序：https://www.cnblogs.com/fly-me/p/wei-ti-jiaoer-cha-shu-de-si-zhong-bian-li-fang-fa.html
 * https://blog.csdn.net/aa8568849/article/details/70243956
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
     * 递归 前续遍历：
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
     * 非递归 前续遍历：中左右
     * 思路：对于任意节点T，访问这个节点并压入栈中，然后访问节点的左子树，
     * 遍历完左子树后，取出栈顶的节点T，再先序遍历T的右子树
     */
    public void preOrderNoRecursion() {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode current = null;
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.getValue() + "  ");
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
        System.out.println();
    }

    /**
     * 非递归 中续遍历：左中右
     * 思路：先将T入栈，遍历左子树；遍历完左子树返回时，栈顶元素应为T，
     * 出栈，访问T->data，再中序遍历T的右子树。
     */

    public void inorderNoRecursion() {
        Stack<TreeNode> stack = new Stack<TreeNode>();
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
     * 非递归 后续遍历：左右中  一个栈
     */
    public void postorderNoRecursion() {
        TreeNode rNode = null;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
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

    /**
     * 非递归 后续遍历：左右中 两个栈
     *
     * @param root
     */
    public void thePostOrderTraversal_Stack(TreeNode root) {   //后序遍历
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();//构造一个中间栈来存储逆后序遍历的结果
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRight();
            } else {
                node = stack.pop();
                node = node.getLeft();
            }
        }
        while (output.size() > 0) {
            System.out.print(output.pop().getValue() + " ");
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
        System.out.print(" 非递归 后序遍历------->");
        bt.thePostOrderTraversal_Stack(bt.getRoot());


    }
}
