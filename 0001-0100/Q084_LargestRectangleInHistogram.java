import java.util.*;

/**
 * 2023/12/16
 * Monotonic stack 单调栈
 */

/**
 * O(n) time | O(n) space
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] { heights[0], 0 });
        for (int i = 1; i < n; i++) {
            int next = heights[i];
            while (!stack.isEmpty() && stack.peek()[0] > next) {
                int[] curr = stack.pop();
                while (!stack.isEmpty() && stack.peek()[0] == curr[0]) {
                    stack.pop();
                }
                int left = stack.isEmpty() ? -1 : stack.peek()[1];
                ans = Math.max(ans, curr[0] * (i - left - 1));
            }
            stack.push(new int[] { next, i });
        }

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek()[1];
            ans = Math.max(ans, curr[0] * (n - left - 1));
        }

        return ans;
    }
}