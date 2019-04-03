package algorithm.swordForOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ������
 * Date: 2015-04-24
 * Time: 13:45
 * Declaration: All Rights Reserved !!!
 */
public class Test25 {
    /**
     * �������������
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * ����һ�ö�������һ�������� ��ӡ���������н��ֵ�ĺ�Ϊ��������������·����
     * �����ĸ���㿪ʼ����һֱ��Ҷ�����������Ľ���γ�һ��·����
     *
     * @param root        ���ĸ����
     * @param expectedSum Ҫ���·����
     */
    public static void findPath(BinaryTreeNode root, int expectedSum) {
        // ����һ���������ڴ�Ÿ���㵽��ǰ��������������Ľ��
        List<Integer> list = new ArrayList<>();

        // �������㲻Ϊ�գ��͵��ø���������
        if (root != null) {
            findPath(root, 0, expectedSum, list);
        }
    }

    /**
     * @param root        ��ǰҪ����Ľ��
     * @param curSum      ��ǰ��¼�ĺͣ���δ���ϵ�ǰ����ֵ��
     * @param expectedSum Ҫ���·����
     * @param result      ����㵽��ǰ��������������Ľ�㣬����δ������ǰ��㣩
     */
    public static void findPath(BinaryTreeNode root, int curSum, int expectedSum, List<Integer> result) {

        // �����㲻Ϊ�վͽ��д���
        if (root != null) {
            // ���ϵ�ǰ����ֵ
            curSum += root.value;
            // ����ǰ������
            result.add(root.value);
            // �����ǰ����ֵС�������ĺ�
            if (curSum < expectedSum) {
                // �ݹ鴦��������
                findPath(root.left, curSum, expectedSum, result);
                // �ݹ鴦��������
                findPath(root.right, curSum, expectedSum, result);
            }
            // �����ǰ���������ĺ����
            else if (curSum == expectedSum) {
                // ��ǰ�����Ҷ��㣬��������
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                }
            }
            // �Ƴ���ǰ���
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 10;
        root.left = new BinaryTreeNode();
        root.left.value = 5;
        root.left.left = new BinaryTreeNode();
        root.left.left.value = 4;
        root.left.right = new BinaryTreeNode();
        root.left.right.value = 7;
        root.right = new BinaryTreeNode();
        root.right.value = 12;

        // ������·���ϵĽ���Ϊ22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);

        // û��·���ϵĽ���Ϊ15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);

        // ��һ��·���ϵĽ���Ϊ19
        System.out.println("findPath(root, 19);");
        findPath(root, 19);


        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 5;
        root2.left = new BinaryTreeNode();
        root2.left.value = 4;
        root2.left.left = new BinaryTreeNode();
        root2.left.left.value = 3;
        root2.left.left.left = new BinaryTreeNode();
        root2.left.left.left.value = 2;
        root2.left.left.left.left = new BinaryTreeNode();
        root2.left.left.left.left.value = 1;

        // ��һ��·������Ľ���Ϊ15
        System.out.println("findPath(root2, 15);");
        findPath(root2, 15);

        // û��·������Ľ���Ϊ16
        System.out.println("findPath(root2, 16);");
        findPath(root2, 16);

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        BinaryTreeNode root3 = new BinaryTreeNode();
        root3.value = 1;
        root3.right = new BinaryTreeNode();
        root3.right.value = 2;
        root3.right.right = new BinaryTreeNode();
        root3.right.right.value = 3;
        root3.right.right.right = new BinaryTreeNode();
        root3.right.right.right.value = 4;
        root3.right.right.right.right = new BinaryTreeNode();
        root3.right.right.right.right.value = 5;

        // ��һ��·������Ľ���Ϊ15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);

        // û��·������Ľ���Ϊ16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);

        // ����ֻ��1�����
        BinaryTreeNode root4 = new BinaryTreeNode();

        root4.value = 1;
        // ��һ��·������Ľ���Ϊ1
        System.out.println("findPath(root4, 1);");
        findPath(root4, 1);

        // û��·������Ľ���Ϊ2
        System.out.println("findPath(root4, 2);");
        findPath(root4, 2);

        // ����û�н��
        System.out.println("findPath(null, 0);");
        findPath(null, 0);
    }
}
