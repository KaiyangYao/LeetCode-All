import java.util.*;

/*
 * Monotonic Stack 模板题
 * 
 * O(m+n) time (loop each array once)
 * O(n) space (the hashmap)
 * 
 * next: #503
 * 
 * 2022/11/09
 */
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        stack.push(nums2[n - 1]);
        map.put(nums2[n - 1], -1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}