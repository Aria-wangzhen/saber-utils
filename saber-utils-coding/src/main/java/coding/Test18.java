package coding;

/**
 * Author: ������
 * Date: 2015-04-23
 * Time: 19:06
 * Declaration: All Rights Reserved !!!
 */
public class Test18 {
    /**
     * �������������
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��
     * �÷�������A�����ҵ�һ����B���ĸ��ڵ���ȵ�Ԫ�صĽ�㣬
     * �������ȵĽ�㿪ʼ�ж���B�ǲ�����A���ӽṹ������ҵ����һ���ͷ��أ�
     * ����ֱ�����еĽ�㶼����Ϊֹ��
     *
     * @param root1 ��A�ĸ����
     * @param root2 ��B�ĸ����
     * @return true����B����A���ӽṹ��false����B�ǲ���A���ӽṹ
     */
    public static boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        // ֻҪ����������ͬһ���ͷ���true
        // ��ע��˴����鱾�ϵĲ�ͬ���鱾�ϵ�û����һ����
        if (root1 == root2) {
            return true;
        }

        // ֻҪ��B�ĸ�����Ϊ�վͷ���true
        if (root2 == null) {
            return true;
        }

        // ��B�ĸ���㲻Ϊ�գ������A�ĸ����Ϊ�վͷ���false
        if (root1 == null) {
            return false;
        }

        // ��¼ƥ����
        boolean result = false;

        // �������ֵ��Ⱦͣ�����ƥ�䷽��
        if (root1.value == root2.value) {
            result = match(root1, root2);
        }

        // ���ƥ���ֱ�ӷ��ؽ��
        if (result) {
            return true;
        }

        // �����ƥ�������A�����ӽ������ӽ������ж�
        return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    /**
     * ����A�����root1����B�����root2��ʼ��һ��һ��Ԫ�ؽ����жϣ��ж�B�ǲ���A���ӽṹ
     *
     * @param root1 ��A��ʼƥ��ĸ����
     * @param root2 ��B��ʼƥ��ĸ����
     * @return ��B����A���ӽṹ��false����B�ǲ���A���ӽṹ
     */
    public static boolean match(BinaryTreeNode root1, BinaryTreeNode root2) {
        // ֻҪ����������ͬһ���ͷ���true
        if (root1 == root2) {
            return true;
        }

        // ֻҪ��B�ĸ�����Ϊ�վͷ���true
        if (root2 == null) {
            return true;
        }
        // ��B�ĸ���㲻Ϊ�գ������A�ĸ����Ϊ�վͷ���false
        if (root1 == null) {
            return false;
        }

        // �����������ֵ��ȣ���ֱ��ж������ӽ������ӽ��
        if (root1.value == root2.value) {
            return match(root1.left, root2.left) && match(root1.right, root2.right);
        }

        // ���ֵ����ȷ���false
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode();
        root1.value = 8;
        root1.right = new BinaryTreeNode();
        root1.right.value = 7;
        root1.left = new BinaryTreeNode();
        root1.left.value = 8;
        root1.left.left = new BinaryTreeNode();
        root1.left.left.value = 9;
        root1.left.right = new BinaryTreeNode();
        root1.left.right.value = 2;
        root1.left.right.left = new BinaryTreeNode();
        root1.left.right.left.left = new BinaryTreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new BinaryTreeNode();
        root1.left.right.left.right.value = 7;

        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 8;
        root2.left = new BinaryTreeNode();
        root2.left.value = 9;
        root2.right = new BinaryTreeNode();
        root2.right.value = 2;

        System.out.println(hasSubtree(root1, root2));
        System.out.println(hasSubtree(root2, root1));
        System.out.println(hasSubtree(root1, root1.left));
        System.out.println(hasSubtree(root1, null));
        System.out.println(hasSubtree(null, root2));
        System.out.println(hasSubtree(null, null));
    }
}
