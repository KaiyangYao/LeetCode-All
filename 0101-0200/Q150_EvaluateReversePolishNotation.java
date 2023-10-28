import java.util.*;

/**
 * Stack
 * 2023/10/25
 */

/**
 * O(n) time | O(n) space
 */
class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (!isOperand(s)) {
                stack.push(Integer.valueOf(s));
            } else {
                int right = stack.pop();
                int left = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    case "/":
                        stack.push(left / right);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private boolean isOperand(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}