package coding;

import java.util.Stack;

/**
 * Author: ������
 * Date: 2015-04-24
 * Time: 09:15
 * Declaration: All Rights Reserved !!!
 */
public class Test22 {
    /**
     * ���������������У���һ�����б�ʾջ��ѹ��˳�����ж϶��������Ƿ�Ϊ��ջ�ĵ���˳��
     * ����ѹ��ջ���������־�����ȡ���������1 ��2��3 ��4��5 ��ĳջѹջ���У�
     * ����4��5��3��2��1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
     * ��4��3��5��1��2�Ͳ������Ǹ�ѹ�����еĵ������С�
     * �����鱾�ĵķ�����ͬ��
     *
     * @param push ��ջ����
     * @param pop  ��ջ����
     * @return true����ջ��������ջ���е�һ������˳��
     */
    public static boolean isPopOrder(int[] push, int[] pop) {
        // ����У�飬��������Ϊ�գ��������������б��������֣��������������е����ָ�����ͬ
        // ���򷵻�false
        if (push == null || pop == null || pop.length == 0 || push.length == 0 || push.length != pop.length) {
            return false;
        }

        // ��������Ĳ���У�飬����������һ�������ݣ���������Ŀ���
        // ���ڴ����ջʱ������
        Stack<Integer> stack = new Stack<>();
        // ���ڼ�¼��ջ����Ԫ�صĴ���λ��
        int pushIndex = 0;
        // ���ڼ�¼��ջ����Ԫ�صĴ���λ��
        int popIndex = 0;
        // ������г�ջԪ��Ҫ����
        while (popIndex < pop.length) {
            // ��ջԪ�ػ�δȫ����ջ�������£����ջΪ�գ�����ջ����Ԫ�ز��뵱ǰ�������ȣ���һֱ����ջ������
            // ֱ����ջԪ��ȫ����ջ�����ҵ���һ���뵱��ջԪ����ȵ�Ԫ��
            while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                // ��ջ�����е�Ԫ����ջ
                stack.push(push[pushIndex]);
                // ָ����һ��Ҫ�������ջԪ��
                pushIndex++;
            }

            // �������һ������ջ�������ҵ������ջ��Ԫ����ȵ�Ԫ��
            if (stack.peek() == pop[popIndex]) {
                // ��Ԫ�س�ջ
                stack.pop();
                // ������һ����ջԪ��
                popIndex++;
            }
            // ���û���ҵ����ջԪ����ȵ�Ԫ�أ�˵�������ջ˳���ǲ��Ϸ���
            // �ͷ���false
            else {
                return false;
            }
        }

        // �����������ǳ�����
        // return stack.isEmpty();

        // Ϊʲô����ֱ�ӷ���true������������while���з�����֪������ÿһ����ջ��Ԫ�أ�
        // ��stackջ�У�ͨ��һЩ��ջ�������ܿ�����ջ�����ҵ�����ջԪ��ֵ��ͬ��Ԫ�أ�
        // ���˵���������ջ��˳������ջ˳���һ���������У���Ҳ���Խ���Ϊʲôstack.isEmpty()
        // ���Ƿ���true�����е���ջԪ�ض����Խ�ջ�����ҿ��Ա�ƥ�䵽��֮��͵��������ջ�о���Ԫ�ء�
        return true;
    }

    /**
     * ���������������У���һ�����б�ʾջ��ѹ��˳�����ж϶��������Ƿ�Ϊ��ջ�ĵ���˳��
     * �����鱾�ϵ�˼·������⣬��������
     *
     * @param push ��ջ����
     * @param pop  ��ջ����
     * @return true����ջ��������ջ���е�һ������˳��
     */
    public static boolean isPopOrder2(int[] push, int[] pop) {

        // ���ڼ�¼�жϳ�ջ˳���ǲ�����ջ˳��һ����ջ���У�Ĭ��false
        boolean isPossible = false;

        // ����ջ�ͳ�ջ�����߶���Ϊ�գ����Ҷ������ݣ��������ݸ��������
        if (push != null && pop != null && push.length > 0 && push.length == pop.length) {
            // ���ڴ����ջʱ������
            Stack<Integer> stack = new Stack<>();
            // ��¼��һ��Ҫ�������ջԪ�ص�λ��
            int nextPush = 0;
            // ��¼��һ��Ҫ����ĳ�ջԪ�ص�λ��
            int nextPop = 0;
            // �����ջԪ��û�д�����ͼ������д���
            while (nextPop < pop.length) {
                // ���ջΪ�ջ���ջ����Ԫ���뵱ǰ����ĳ�ջԪ�ز���ͬ��һֱ���в���
                while (stack.isEmpty() || stack.peek() != pop[nextPop]) {
                    // �����ջ��Ԫ���Ѿ�ȫ����ջ�ˣ����˳��ڲ�ѭ��
                    if (nextPush >= push.length) {
                        break;
                    }

                    // ִ�е��˴�˵��������ջԪ�ؿ�����ջ
                    // ����Ԫ����ջ
                    stack.push(push[nextPush]);
                    // ָ����һ��Ҫ�������ջԪ�ص�λ��
                    nextPush++;
                }

                // ִ�е��˴������������
                // ��һ�֣���ջ�����ҵ���һ������ջԪ����ȵ�Ԫ��
                // �ڶ��֣���ջ����û���ҵ�һ������ջԪ����ȵ�Ԫ�أ���������ջ��Ԫ���Ѿ�ȫ����ջ��

                // ���ڵڶ��������˵����ջ��˳���ǲ�����Ҫ��ģ��˳����ѭ��
                if (stack.peek() != pop[nextPop]) {
                    break;
                }

                // ��Ӧ����һ���������ҪҪջ��ջ��Ԫ�ص���
                stack.pop();
                // ָ����һ��Ҫ����ĳ�ջԪ�ص�λ��
                nextPop++;
            }

            // ִ�е��˴����������
            // ��һ�֣����whileѭ�����ڵ�һ��������˳���
            // �ڶ��֣����еĳ�ջԪ�ض�����ȷƥ��

            // ���ڳ��ֵĵ�һ�������stack.isEmpty()�ز�Ϊ�գ�ԭ��Ϊ�������£�
            // ���е���ջԪ��һ������ջ������ֻ��ƥ�������²Ż��ջ��
            // ƥ��Ĵ����������ջԪ�ظ���Ԫ����ͬ����������ĳ�����ȣ�������в�ƥ���Ԫ�أ�
            // ��Ȼ��ʹ��ջ�Ĵ�������ջ�Ĵ����٣�����ջ�����ٻ���һ��Ԫ��
            // ���ڵڶ��������stack.isEmpty()һ��Ϊ��
            // �����鱾�ϵ�nextPop == pop.length��pNextPop-pPop==nLength���Ƕ����
            if (stack.isEmpty()) {
                isPossible = true;
            }
        }

        return isPossible;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));

        System.out.println("false: " + isPopOrder(null, null));

        // ���Է���2
        System.out.println();
        System.out.println("true: " + isPopOrder2(push, pop1));
        System.out.println("true: " + isPopOrder2(push, pop2));
        System.out.println("false: " + isPopOrder2(push, pop3));
        System.out.println("false: " + isPopOrder2(push, pop4));
        System.out.println("false: " + isPopOrder2(push5, pop5));
        System.out.println("true: " + isPopOrder2(push6, pop6));
        System.out.println("false: " + isPopOrder2(null, null));
    }
}
