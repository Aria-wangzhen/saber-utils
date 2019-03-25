package algorithm.leetCode.simple;

import java.util.Stack;

/**
 * Min Stack 最小栈
 * http://www.cnblogs.com/grandyang/p/4091064.html
 * 保证当前最小栈栈顶为当前数据栈的最小值
 *
 * @author Aria
 * @time on 2019-03-23.
 */
public class L155 {
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> dataStack = new Stack<>();

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        dataStack.push(x);
    }

    public void pop() {
        int data = dataStack.pop();
        if (data == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
}
