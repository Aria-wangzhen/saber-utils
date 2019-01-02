package dataStructure.tree;

import java.util.LinkedList;
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
     * 思路: 利用Stsck,让节点的子节点互相交换
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
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack1.isEmpty()) {
            TreeNode cur1 = stack1.pop();
            TreeNode cur2 = stack2.pop();
            if (cur1.value != cur2.value) {
                return false;
            } else {
                if (cur1.right != null && cur2.right != null) {
                    stack1.push(cur1.right);
                    stack2.push(cur2.right);
                }
                if (cur1.left != null && cur2.left != null) {
                    stack1.push(cur1.left);
                    stack2.push(cur2.left);
                }
                if (cur1.left == null && cur1.right == null && cur2.left == null && cur2.right == null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    //9.判断二叉树1是不是二叉树2的子结构


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
    public boolean isBlanced2(TreeNode root) {
        int high = 0;
        return isBlanced3(root, high);
    }

    public boolean isBlanced3(TreeNode root, int high) {
        if (root == null) {
            high = 0;
            return true;
        }
        int lefthigh = 0, righthigh = 0;
        if (isBlanced3(root.left, lefthigh) && isBlanced3(root.right, righthigh)) {
            if (Math.abs(lefthigh - righthigh) <= 1) {
                high = 1 + Math.max(lefthigh, righthigh);
                return true;
            }
        }
        return false;
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
        while (mid.charAt(i) != pre.charAt(0))//找到中序遍历中根节点的位置，那么它前面的即是左树，后面的是右树
        {
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
    //15.二叉树中两节点的最大距离

    /**
     * 计算一个二叉树的最大距离有两个情况:
     * <p>
     * 情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
     * 情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
     * 只需要计算这两个情况的路径距离，并取其大者，就是该二叉树的最大距离
     */
    public static Result getMaxDistanceRec(TreeNode root) {
        if (root == null) {
            Result empty = new Result(0, -1);       // 目的是让调用方 +1 后，把当前的不存在的 (NULL) 子树当成最大深度为 0
            return empty;
        }

        // 计算出左右子树分别最大距离
        Result lmd = getMaxDistanceRec(root.left);
        Result rmd = getMaxDistanceRec(root.right);

        Result res = new Result();
        res.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;        // 当前最大深度
        // 取情况A和情况B中较大值
        res.maxDistance = Math.max(lmd.maxDepth + rmd.maxDepth, Math.max(lmd.maxDistance, rmd.maxDistance));
        return res;
    }

    private static class Result {
        int maxDistance;
        int maxDepth;

        public Result() {
        }

        public Result(int maxDistance, int maxDepth) {
            this.maxDistance = maxDistance;
            this.maxDepth = maxDepth;
        }
    }


    //16.最低公共祖先节点
    public TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        // 如果有一个match，则说明当前node就是要找的最低公共祖先  注意递归条件！！！！！
        if (root.equals(n1) || root.equals(n2)) {
            return root;
        }
        TreeNode commonInLeft = getLastCommonParentRec(root.left, n1, n2);
        TreeNode commonInRight = getLastCommonParentRec(root.right, n1, n2);
        // 如果一个左子树找到，一个在右子树找到，则说明root是唯一可能的最低公共祖先
        if (commonInLeft != null && commonInRight != null) {
            return root;
        }
        // 其他情况是要不然在左子树要不然在右子树
        if (commonInLeft != null) {
            return commonInLeft;
        }
        return commonInRight;
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

