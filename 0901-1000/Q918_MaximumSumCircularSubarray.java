/**
 * DP
 * 
 * 2023/07/20  CN Daily
 */

/**
 * O(n) time | O(1) space
 * sum - minSum = max(带环子数组)
 */
class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int currMin = nums[0];
        int currMax = nums[0];
        int minSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMax);
            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(minSum, currMin);
            sum += nums[i];
        }
        
        // 如果minSum是整个数组的sum，说明跨界子数组的sum是空的，只能用不跨界的maxSum答案
        return minSum == sum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
