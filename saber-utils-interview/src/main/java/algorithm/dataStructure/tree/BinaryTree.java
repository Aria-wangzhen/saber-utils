package algorithm.dataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 来源：https://blog.csdn.net/sheepmu/article/details/38474687
 * 附加参考：https://blog.csdn.net/fightforyourdream/article/details/16843303
 * 1.二叉树的遍历，前序中序后序，递归和非递归
 *
 * @see BinaryBaseTree
 * http://blog.csdn.net/sheepmu/article/details/28941285
 * 2.二叉树的层序遍历（广度优先遍历）
 * 3.二叉树的高度/最小高度
 * 4.二叉树的节点个数
 * 5.求二叉树的镜像
 * 6.判断两颗二叉树是否互为镜像
 * 7.判断一棵树是否本身就是镜像树
 * 8.判断两颗二叉树是不是相同的树
 * 9.判断树1是不是树2的子结构
 * 10.判断二叉树是否是平衡二叉树
 * 11.二叉树第k层的节点个数
 * 12.二叉树叶子节点的个数
 * 13.由前序遍历和中序遍历重构二叉树
 * 14.由中序遍历和后序遍历重构二叉树
 * 15.二叉树中两节点的最大距离
 * 16.二叉树中和为某一值的路径
 * 17.求二叉树中两个节点的最低公共祖先节点
 */

public class BinaryTree {


    /**
     * 2.二叉树的层序遍历（广度优先遍历）
     * 思路：利用队列实现二叉树的层序遍历。
     *
     * @param root
     */
    public void cx(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }

        }
    }

    /**
     * 3.二叉树的高度  --递归--
     *
     * @param root
     * @return
     */
    public int getHighRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //1是根
        return Math.max(getHighRec(root.left), getHighRec(root.right)) + 1;
    }

    /**
     * 3.二叉树的高度  --非 递归--
     * 思路：层序遍历，对当前层和下一层的节点数计数。
     *
     * @param root
     * @return
     */
    public int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        int high = 0;
        int curLevelNodes = 1, nextLevelNodes = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            curLevelNodes--;
            if (cur.left != null) {
                queue.addLast(cur.left);
                nextLevelNodes++;
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
                nextLevelNodes++;
            }
            if (curLevelNodes == 0) {
                high++;
                curLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return high;
    }

    /**
     * 求二叉树的最低高度(最小深度),若有左or右子树为null的情况，则最小高度是另一非null子树的最小高度 --递归--
     * 最小深度是从根节点到最近的叶节点的最短路径上的节点数
     *
     * @param root
     * @return
     */
    public int getMinHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + getMinHigh(root.right);
        }
        if (root.right == null) {
            return 1 + getMinHigh(root.left);
        }
        return 1 + Math.min(getMinHigh(root.right), getMinHigh(root.left));
    }

    /**
     * 4.二叉树的节点个数   --递归--
     *
     * @param root
     * @return
     */
    public int getNodesNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNodesNumRec(root.left) + getNodesNumRec(root.right) + 1;
    }

    /**
     * 4.二叉树的节点个数   --非递归--
     * 思路:层序遍历记录个数
     *
     * @param root
     * @return
     */
    public int getNodesNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        int num = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if (cur.left != null) {
                queue.addLast(cur.left);
                num++;
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
                num++;
            }
        }
        return num;
    }

    /**
     * 5.求二叉树的镜像(直接把原树变为其镜像树，即破坏原树)   --递归--
     * 思路:把原树的左子树置为其右子树的镜像；把原树的右子树置为其左子树的镜像
     *
     * @param root
     * @return
     */
    public TreeNode getJXRec(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tleft = getJXRec(root.right);
        TreeNode tright = getJXRec(root.left);
        root.left = tleft;
        root.right = tright;
        return root;
    }

    /**
     * 5.求二叉树的镜像(直接把原树变为其镜像树，即破坏原树)   --非递归--
     * 思路: 利用Stack,让节点的子节点互相交换
     *
     * @param root
     * @return
     */
    public TreeNode getJX(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            //交换
            TreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = temp;

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return root;
    }

    //5.求二叉树的镜像（生成一颗新树，即不改变原树结构） --递归--
    public TreeNode newJXRec(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newTree = new TreeNode(root.value);
        newTree.left = newJXRec(root.right);
        newTree.right = newJXRec(root.left);
        return newTree;
    }

    //5.求二叉树的镜像（生成一颗新树，即不改变原树结构） --非 递归--
    public static TreeNode mirrorCopy(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> newStack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode newRoot = new TreeNode(root.value);
        newStack.push(newRoot);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode newCur = newStack.pop();

            if (cur.right != null) {
                stack.push(cur.right);
                newCur.left = new TreeNode(cur.right.value);
                newStack.push(newCur.left);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                newCur.right = new TreeNode(cur.left.value);
                newStack.push(newCur.right);
            }
        }

        return newRoot;
    }

    //6.判断两颗二叉树是否互为镜像    --递归--
    public boolean isJXRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isJXRec(root1.left, root2.right) && isJXRec(root1.right, root2.left);
    }

    //7.判断一颗二叉树本身是否为镜像树    --递归--
    public static boolean isJXSelfRec2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isJXSelf(root.left, root.right);
    }

    private static boolean isJXSelf(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.value != right.value) {
            return false;
        }
        return isJXSelf(left.left, right.right) && isJXSelf(left.right, right.left);
    }

    //8.判断两颗二叉树是不是相同的树  --递归--
    public boolean isSameTreeRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isSameTreeRec(root1.left, root2.left) && isSameTreeRec(root1.right, root2.right);
    }

    //8.判断两颗二叉树是不是相同的树  --非递归--
    public boolean isSameTree(TreeNode root1, TreeNode root2) {

        return true;
    }

    //9.判断二叉树1是不是二叉树2的子结构
    public boolean hasSub(TreeNode root, TreeNode node) {
        boolean res = false;
        if (root != null && node != null) {
            if (root.value == node.value) {
                res = dosTree(root, node);
                if (!res) {
                    hasSub(root.left, node);
                }
                if (!res) {
                    hasSub(root.right, node);
                }
            }
        }
        return res;
    }

    private boolean dosTree(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (node == null) {
            return true;
        }
        if (root.value != node.value) {
            return false;
        }
        return dosTree(root.left, node.left) && dosTree(root.right, node.right);
    }

    //10.判断二叉树是否是平衡二叉树    --递归--   但是这种方式虽然简洁，但是每个节点会被遍历多次，并不高效
    public boolean isBlanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHighRec(root.left) - getHighRec(root.right)) > 1)//先判断整个左右子树高度差
        {
            return false;
        }
        return isBlanced(root.left) && isBlanced(root.right);
    }

    //10.判断二叉树是否是平衡二叉树    --递归--   更加高效的解法：每个节点只被遍历一次
    //11.在遍历的过程中一边遍历一边计算高度
    public boolean isBalanced1(TreeNode root) {
        if (checkDepth(root) == -1) {
            return false;
        } else {
            return true;
        }

    }

    private int checkDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = checkDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = checkDepth(root.right);
        if (right == -1) {
            return -1;
        }
        //比较差值
        int diff = Math.abs(left - right);
        if (diff > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }

    //11.求二叉树第k层的节点个数  --递归--
    public int getNodesInKRec(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }

        return getNodesInKRec(root.left, k - 1) + getNodesInKRec(root.right, k - 1);
    }

    //11.求二叉树第k层的节点个数  --非 递归--
    //思路:层序遍历，类似于非递归求高度
    public int getNodesInK(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        int curLevelNodes = 1;
        int nextLevelNodes = 0;
        int high = 1;
        while (!queue.isEmpty() && high < k) {
            TreeNode cur = queue.removeFirst();
            curLevelNodes--;
            if (cur.left != null) {
                queue.addLast(root.left);
                nextLevelNodes++;
            }
            if (cur.right != null) {
                queue.addLast(root.right);
                nextLevelNodes++;
            }
            if (curLevelNodes == 0) {
                high++;
                curLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return curLevelNodes;
    }

    //12.求二叉树的叶子节点数   --递归--
    public int getYeNodesRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getYeNodesRec(root.left) + getYeNodesRec(root.right);
    }

    //12.求二叉树的叶子节点数   --非递归--
    public int getYeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int num = 0;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right == null && cur.left == null) {
                num++;
            }
        }
        return num;
    }

    //13.由前序遍历和中序遍历重构二叉树  --递归--
    //先找到根节点，在分别找到左右子树的前序和中序，递归
    public TreeNode buildTreeRec(String pre, String mid) {
        if (pre == null || mid == null) {
            return null;
        }
        if (pre.length() == 0 || mid.length() == 0) {
            return null;
        }
        if (pre.length() != mid.length()) {
            return null;
        }
        int len = pre.length();
        TreeNode root = new TreeNode(pre.charAt(0) + "");//先找到根节点，前序遍历的第一个是根节点
        int i = 0;
        //找到中序遍历中根节点的位置，那么它前面的即是左树，后面的是右树
        while (mid.charAt(i) != pre.charAt(0)) {
            i++;
        }

        root.left = buildTreeRec(pre.substring(1, 1 + i), mid.substring(0, i));//由左树的前序和后序构造新左树
        root.right = buildTreeRec(pre.substring(i + 1, len), mid.substring(i + 1, len));//由右树的前序和后序构造新的右树
        return root;
    }

    //14.由中序遍历和后序遍历重构二叉树 --递归--
    //先找到根节点，在分别找到左右子树的中序和后序，递归
    public TreeNode buildTreeRec2(String mid, String pro) {
        if (mid == null || pro == null) {
            return null;
        }
        if (mid.length() == 0 || pro.length() == 0) {
            return null;
        }
        if (mid.length() != pro.length()) {
            return null;
        }
        int len = mid.length();
        TreeNode root = new TreeNode(pro.charAt(len - 1) + "");//后序的最后一个是根节点
        int i = 0;
        while (mid.charAt(i) != pro.charAt(len - 1))//找到中序遍历中根节点的位置，那么它前面的即是左树，后面的是右树
        {
            i++;
        }
        root.left = buildTreeRec2(mid.substring(0, i), pro.substring(0, i));
        root.right = buildTreeRec2(mid.substring(i + 1, len), pro.substring(i, len - 1));
        return root;
    }

    /**
     * 15.二叉树中两节点的最大距离 L543
     * 设置一个全局变量记录左右子树最大深度和。
     */
    int maxDepth = 0;

    public int diameterOfBinaryTree(algorithm.leetCode.TreeNode root) {
        maxDepth(root);
        return maxDepth;
    }

    private int maxDepth(algorithm.leetCode.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //额外计算最大长度 - 否则两个递归
        maxDepth = Math.max(maxDepth, left + right);
        return Math.max(left, right) + 1;
    }


    /**
     * 17.二叉树中和为某一值的路径 L113
     * <p>
     * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶销点所经过的结点形成一条路径。
     */
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


    //16.最低公共祖先节点 -- 前提是一定有 L236
    public TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        /**
         * 1、如果有一个match，则说明当前node就是要找的最低公共祖先  注意递归条件！！！！！
         */
        if (root.equals(n1) || root.equals(n2)) {
            return root;
        }
        TreeNode commonInLeft = getLastCommonParentRec(root.left, n1, n2);
        TreeNode commonInRight = getLastCommonParentRec(root.right, n1, n2);

        /**
         * 2、如果一个左子树找到，一个在右子树找到，则说明root是唯一可能的最低公共祖先
         */
        if (commonInLeft != null && commonInRight != null) {
            return root;
        }
        /**
         * 3、其他情况是要不然在左子树要不然在右子树
         */
        if (commonInLeft != null) {
            return commonInLeft;
        } else {
            return commonInRight;
        }

    }


    /*
                                 A
                               /   \
                             B      C
                            / \        \
                          D    E        F


  */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode("A");
        TreeNode n2 = new TreeNode("B");
        TreeNode n3 = new TreeNode("C");
        TreeNode n4 = new TreeNode("D");
        TreeNode n5 = new TreeNode("E");
        TreeNode n6 = new TreeNode("F");
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        TreeNode root = n1;
        BinaryTree bt = new BinaryTree();
        /*System.out.print("层序遍历---->");
        bt.cx(root);
        System.out.print("\n");
        System.out.println("递归高度---->" + bt.getHighRec(root));
        System.out.println("非递归高度---->" + bt.getHigh(root));
        System.out.println("递归节点个数---->" + bt.getNodesNumRec(root));
        System.out.println("非递归节点个数---->" + bt.getNodesNum(root));*/

//		 bt.getJXRec(root);
//		 bt.cx(root);
//		 System.out.print("\n");
//		System.out.print("把树变为本身的镜像树后层序遍历---->" );
//		 bt.getJX(root);
//		 bt.cx(root);
       /* System.out.println("是否是平衡二叉树---->" + bt.isBlanced(root));
        System.out.println("是否是平衡二叉树,每个节点只遍历一次的方法---->" + bt.isBlanced2(root));
        System.out.println("递归第 k层节点个数---->" + bt.getNodesInKRec(root, 3));
        System.out.println("非递归第 k层节点个数---->" + bt.getNodesInK(root, 3));
        System.out.println("递归叶节点个数---->" + bt.getYeNodesRec(root));
        System.out.println("非递归叶节点个数---->" + bt.getYeNodes(root));
        System.out.print("由前序遍历和中序遍历构造的树的  层序遍历---->");
        bt.cx(bt.buildTreeRec("ABDECF", "DBEACF"));
        System.out.print("\n");
        System.out.print("由中序遍历和后序遍历构造的树的  层序遍历---->");
        bt.cx(bt.buildTreeRec2("DBEACF", "DEBFCA"));
        System.out.print("\n");
        System.out.println("最低公共祖先---->" + bt.getLastCommonParentRec(root, n4, n3).value);
*/
        System.out.println("最小高度---->" + bt.getMinHigh(root));
        ;
    }
}

