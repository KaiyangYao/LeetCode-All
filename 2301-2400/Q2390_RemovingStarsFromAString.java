import java.util.*;

/**
 * Stack
 * 2023/09/01
 */

/**
 * Solution 1: Stack
 * O(n) time | O(n) space
 */
class Solution2390_01 {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}


/**
 * Solution 2: 2 pointers 原地更新
 * 但是因为Java的String是immutable的，所以没有setCharAt方法，需要StringBuilder或者转成char array
 * 因此还是 O(n) space
 */