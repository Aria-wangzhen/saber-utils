package algorithm.leetCode.simple;

import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 *
 * @author Aria
 * @time on 2019-04-12.
 */
public class L225 {
    private LinkedList<Integer> que = new LinkedList<>();
    private LinkedList<Integer> topQue = new LinkedList<>();

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        topQue.add(x);
        while (topQue.size() > 1) {
            que.add(topQue.removeFirst());
        }

    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int x = top();
        topQue.removeFirst();
        return x;
    }

    /**
     * Get the top element.
     */
    public int top() {
        Integer x = null;
        if (topQue.isEmpty() && !que.isEmpty()) {
            for (int i = 0; i < que.size() - 1; i++) {
                que.add(que.removeFirst());
            }
            topQue.add(que.removeFirst());
        }
        return topQue.getFirst();


    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return topQue.isEmpty() && que.isEmpty();

    }
}
