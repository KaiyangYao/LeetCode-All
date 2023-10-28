import java.util.*;

/**
 * 固定长度 sliding window
 * 递减单调栈
 * 2023/10/25
 */

/**
 * O(n) time
 * O(k) space
 */
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.removeLast();
            }
            dq.offerLast(nums[i]);
        }

        ans[0] = dq.peekFirst();

        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == nums[i - k]) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                dq.removeLast();
            }
            dq.offerLast(nums[i]);
            ans[i - k + 1] = dq.peekFirst();
        }

        return ans;
    }
}