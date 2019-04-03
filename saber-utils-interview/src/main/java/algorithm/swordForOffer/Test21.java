package algorithm.swordForOffer;

import java.util.Stack;

/**
 * Author: ������
 * Date: 2015-04-24
 * Time: 08:41
 * Declaration: All Rights Reserved !!!
 */
public class Test21 {
    /**
     * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�У����СԪ�ص�min������
     * �ڸ�ջ�У�����pop��push ��min��ʱ�临�Ӷȶ���0(1)
     *
     * @param <T> ���Ͳ���
     */
    public static class StackWithMin<T extends Comparable<T>> {
        // ����ջ�����ڴ�Ų��������
        private Stack<T> dataStack;
        // ��С��λ��ջ���������ջ����С������λ��
        private Stack<Integer> minStack;

        // ���캯��
        public StackWithMin() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        /**
         * ��ջ����
         * @return ջ��Ԫ��
         */
        public T pop() {
            // ���ջ�Ѿ�Ϊ�գ��ٳ�ջ�׳��쳣
            if (dataStack.isEmpty()) {
                throw new RuntimeException("The stack is already empty");
            }

            // ��������ݣ���С��λ��ջ������ջ�ض�������ͬ��Ԫ�ظ�����
            // ����ջͬʱ��ջ
            minStack.pop();
            return dataStack.pop();
        }

        /**
         * Ԫ����ջ
         * @param t ��ջ��Ԫ��
         */
        public void push(T t) {
            // �����ջ��Ԫ��Ϊ�վ��׳��쳣
            if (t == null) {
                throw new RuntimeException("Element can be null");
            }

            // �������ջ�ǿյģ�ֻ�ӽ�Ԫ����ջ��ͬʱ������С��ջ�е�����
            if (dataStack.isEmpty()) {
                dataStack.push(t);
                minStack.push(0);
            }
            // �������ջ��������
            else {
                // ��ȡ����ջ�е���СԪ�أ�δ����t֮ǰ�ģ�
                T e = dataStack.get(minStack.peek());
                // ��t��ջ
                dataStack.push(t);
                // �����������ݱ�ջ�е���СԪ��С
                if (t.compareTo(e) < 0) {
                    // ���µ���СԪ�ص�λ������Сջ
                    minStack.push(dataStack.size() - 1);
                } else {
                    // �����Ԫ�ز���ԭ������СԪ��С��������Сջջ��Ԫ�أ�������ջ
                    minStack.push(minStack.peek());
                }
            }
        }

        /**
         * ��ȡջ�е���СԪ��
         * @return ջ�е���СԪ��
         */
        public T min() {
            // �����С����λ��ջ�Ѿ�Ϊ�գ�����ջ���Ѿ�û�������ˣ������׳��쳣
            if (minStack.isEmpty()) {
                throw new RuntimeException("No element in stack.");
            }

            // ��ȡ����ջ�е���СԪ�أ����ҷ��ؽ��
            return dataStack.get(minStack.peek());
        }
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }
}
