import java.util.*;

/**
 * 2023/12/05
 * Stack
 */

/**
 * O(n) time | O(n) space
 */
class Solution856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(0);
            } else if (c == ')') {
                if (stack.peek() == 0) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int currScore = 0;
                    while (stack.peek() != 0) {
                        currScore += stack.pop();
                    }
                    stack.pop();
                    stack.push(currScore * 2);
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}