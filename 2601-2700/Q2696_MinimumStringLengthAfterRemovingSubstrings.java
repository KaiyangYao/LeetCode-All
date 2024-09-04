import java.util.*;

/**
 * Stack
 * 2023/01/10
 */

/**
 * O(n) time | O(n) space
 */
class Solution2696 {
    public int minLength(String s) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
            int m = stack.size();
            if (m >= 2 && ((stack.get(m - 2) == 'A' && stack.get(m - 1) == 'B')
                    || (stack.get(m - 2) == 'C' && stack.get(m - 1) == 'D'))) {
                stack.remove(m - 1);
                stack.remove(m - 2);
            }
        }
        return stack.size();
    }
}