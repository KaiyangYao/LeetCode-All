import java.util.*;

/**
 * 2023/08/29
 * 2023/09/16
 */

/**
 * Monotonic Stack
 * 
 * O(n) time | O(n) space
 * 
 * Similar: Q901
 */

// Suggest this version
class Solution739_01 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] { temperatures[0], 0 });

        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] prev = stack.pop();
                ans[prev[1]] = i - prev[1];
            }
            stack.push(new int[] { temperatures[i], i });
        }

        // 可以不加这个，因为int[] 初始化默认是 0
        while (!stack.isEmpty()) {
            ans[stack.peek()[1]] = 0;
            stack.pop();
        }

        return ans;
    }
}

class Solution739_02 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}