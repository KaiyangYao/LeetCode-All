import java.util.*;

/**
 * 模拟题
 * 
 * 2023/07/06
 */

/**
 * O(n) time | O(n) space
 */
class Solution682 {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.parseInt(operations[0]));
        for (int i = 1; i < operations.length; i++) {
            if (operations[i].equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (operations[i].equals("C")) {
                stack.pop();
            } else if (operations[i].equals("+")) {
                int temp = stack.pop();
                int next = stack.peek() + temp;
                stack.push(temp);
                stack.push(next);
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}