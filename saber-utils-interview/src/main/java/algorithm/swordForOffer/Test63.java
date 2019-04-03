package algorithm.swordForOffer;

/**
 * Author: ������
 * Date: 2015-06-16
 * Time: 21:39
 * Declaration: All Rights Reserved !!!
 */
public class Test63 {
    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
        if (root == null || k < 1) {
            return null;
        }

        int[] tmp = {k};
        return kthNodeCore(root, tmp);
    }

    private static BinaryTreeNode kthNodeCore(BinaryTreeNode root, int[] k) {
        BinaryTreeNode result = null;

        // �ȳ�����������
        if (root.left != null) {
          result =  kthNodeCore(root.left, k);
        }

        // �������������û���ҵ�
        if (result == null) {
            // ˵����ǰ�ĸ��������Ҫ�ҵĽ��
            if(k[0] == 1) {
                result = root;
            } else {
                // ��ǰ�ĸ���㲻��Ҫ�ҵĽ�㣬�����Ѿ��ҹ��ˣ����Լ�������һ
                k[0]--;
            }
        }

        // ������Լ����������ӽ�㶼û���ҵ���������������
        if (result == null && root.right != null) {
            result = kthNodeCore(root.right, k);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        print(n1);
        System.out.println();

        for (int i = 0; i <= 10; i++) {
            System.out.printf(kthNode(n1, i) + ", ");
        }

    }

    /**
     * �������һ����
     * @param root
     */
    private static void print(BinaryTreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.printf("%-3d", root.val);
            print(root.right);
        }
    }
}
