import java.util.*;
/**
 * Sliding Window
 * 先排序的原因: 在其他区间找到的Max-Min最小值一定比排序后的区间内的Max-Min的最小值要大
 * 
 * 2023/07/06
 */
/**
 * O(n logn) time | O(n) space
 */
class Solution1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            result = Math.min(result, nums[i] - nums[i - k + 1]);
        }
        return result;
    }
}