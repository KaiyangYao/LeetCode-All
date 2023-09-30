/*
 * DP
 * 
 * O(n) time | O(1) space
 * 
 * 2023/02/02
 */

class Solution053_01 {
    /**
     * 状态定义： 设动态规划列表 dp，dp[i]代表以元素 nums[i] 为结尾的连续子数组最大和。
     * 注意nums[i]必须要算进去，这样结果才是连续子数组
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(currMax, maxSum);
        }
        return maxSum;
    }
}

/**
 * Sliding Window
 * O(n) time | O(1) space
 * 
 * 2023/09/26
 */
class Solution053_02 {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int ans = nums[0];
        for (int left = 0, right = 0; right < nums.length; right++) {
            currSum += nums[right];
            // 注意和模板不一样要先求ans再移动左指针，反例: [-1]
            ans = Math.max(ans, currSum);

            while (currSum < 0) {
                currSum -= nums[left++];
            }
        }
        return ans;
    }
}