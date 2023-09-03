import java.util.*;

/**
 * Stack Template Question
 * 2023/09/01
 */

/**
 * O(n) time | O(n) space
 */
class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            int next = asteroids[i];
            boolean add = true;
            while (!stack.isEmpty() && stack.peek() > 0 && next < 0) {
                int a = stack.peek(), b = -next;
                if (a < b) {
                    stack.pop();
                } else if (a == b) {
                    stack.pop();
                    add = false;
                    break;
                } else {
                    add = false;
                    break;
                }
            }

            if (add)
                stack.push(next);
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}