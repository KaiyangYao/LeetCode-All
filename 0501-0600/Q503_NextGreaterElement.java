import java.util.*;

/*
 * Monotonic Stack 模板题
 * 
 * O(n) time (loop the array once) (每个元素最多被pop 一次，所以是O(1))
 * O(n) space (the result array)
 * 
 * last: #496
 * 
 * 2022/11/09
 */

class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        stack.push(nums[n - 1]);
        for (int i = 2 * n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }

        return result;
    }
}