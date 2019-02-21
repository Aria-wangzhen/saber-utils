package algorithm.leetCode.simple;

import java.util.Stack;

/**
 * Valid Parentheses 验证括号
 * http://www.cnblogs.com/grandyang/p/4424587.html
 *
 * @author Aria
 * @time on 2019-02-20.
 */
public class L20 {
    public static void main(String[] args) {
        System.out.println(isValid("(}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] strChar = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] == '(' || strChar[i] == '[' || strChar[i] == '{') {
                stack.push(strChar[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (strChar[i] == ')' && stack.pop() != '(') {
                    return false;
                }
                if (strChar[i] == ']' && stack.pop() != '[') {
                    return false;
                }
                if (strChar[i] == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;

    }
}
