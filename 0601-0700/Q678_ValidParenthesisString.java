import java.util.*;

/**
 * 2023/12/05
 * Greedy
 */

/**
 * O(n) time | O(n) space
 */
class Solution678 {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            int nextL = left.pop();
            int nextS = star.pop();
            if (nextS < nextL) {
                return false;
            }
        }

        return left.isEmpty();
    }
}