package ZChengYun.chapter_5_stringproblem;

import java.util.LinkedList;

/**
 * 公式字符串求值
 */
public class Problem_15_ExpressionCompute {

    public static int getValue(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    public static int[] value(char[] str, int i) {
        //存放以前累计结果和当前数字最近的运算符
        LinkedList<String> que = new LinkedList<String>();
        int pre = 0;
        //bra括号的意思
        int[] bra = null;
        while (i < str.length && str[i] != ')') {
            // 0 - 9 数字处理
            if (str[i] >= '0' && str[i] <= '9') {
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') {
                //不是数字和左括号进去处理
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            } else {
                //左括号处理
                bra = value(str, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        //右括号处理
        addNum(que, pre);
        return new int[]{getNum(que), i};
    }

    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String exp = "4*((7*5)-43)+8*1";
        System.out.println(getValue(exp));

        /*exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "10-5*3";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));*/

    }

}
